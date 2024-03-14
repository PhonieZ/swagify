package phoni.swagify;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ImportantPeopleAPI.PersonDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;




public class swagify_sprite_override extends BaseModPlugin 
{   
    static void swagify_init()
    {
        List<PersonDataAPI> important_character_wrapper_list = Global.getSector().getImportantPeople().getPeopleCopy();
        PersonAPI player_object = Global.getSector().getCharacterData().getPerson();


        List<PersonAPI> character_object_list = character_wrapper_list_to_object_list(important_character_wrapper_list);
        character_object_list.add(player_object);


        Dictionary<String, PersonAPI> character_object_dict = character_object_list_to_dict(character_object_list);



        Iterator<String> swag_characters_iterator = swagify_config.swag_characters.iterator();

        String current_swag_character;
        PersonAPI current_swag_character_object;


        while (swag_characters_iterator.hasNext()) 
        {   
            current_swag_character = swag_characters_iterator.next();
            current_swag_character_object = character_object_dict.get(current_swag_character);
            
            
            if (current_swag_character.equals(swagify_config.ALL_PLAYERS))
            {
                swagify_character(player_object);
            }

            else if (current_swag_character_object != null)
            {   
                swagify_character(current_swag_character_object);
            }
        }
    }




    static void swagify_character(PersonAPI character_object)
    {   
        StringBuilder string_builder = new StringBuilder();

        
        String character_sprite_pointer = character_object.getPortraitSprite();
        String swag_character_sprite_pointer;


        Dictionary<String, String> string_target_pair = new Hashtable<>();
        Dictionary<String, Integer> substring_index_pair = new Hashtable<>();


        string_target_pair.put("target", "graphics");
        string_target_pair.put("replacement", "graphics/phoni/swagify");


        substring_index_pair.put(
                                    "start_index", 
                                    character_sprite_pointer.indexOf(string_target_pair.get("target"))
                                );
        substring_index_pair.put(
                                    "end_index", 
                                    substring_index_pair.get("start_index") + string_target_pair.get("target").length()
                                );


        

        if (character_sprite_pointer.contains(string_target_pair.get("replacement")))
        {
            return;
        }
        

     
        
        string_builder.append(character_sprite_pointer.substring(0, substring_index_pair.get("start_index"))); 
        //Start Index ==> Index Before Target

        string_builder.append(string_target_pair.get("replacement"));
        //Replacement String

        string_builder.append(character_sprite_pointer.substring(substring_index_pair.get("end_index"), character_sprite_pointer.length()));
        //Index After Target ==> End Index


        swag_character_sprite_pointer = string_builder.toString();




        character_object.setPortraitSprite(swag_character_sprite_pointer);
    }  
    
    

    
    static Dictionary<String, PersonAPI> character_object_list_to_dict(List<PersonAPI> character_object_list)
    {   
        StringBuilder string_builder = new StringBuilder();

        String current_character_name;

        Dictionary<String, PersonAPI> character_object_dict = new Hashtable<>();



        for (PersonAPI current_character_object : character_object_list)
        {
            string_builder.append(current_character_object.getName().getFirst().toLowerCase());
            //Lowercase First Name

            string_builder.append(swagify_config.SEPARATOR);
            //Separator

            string_builder.append(current_character_object.getName().getLast().toLowerCase());
            //Lowercase Last Name


            current_character_name = string_builder.toString();
            string_builder.setLength(0);


            character_object_dict.put(current_character_name, current_character_object);
        }



        return character_object_dict;
    }



    static List<PersonAPI> character_wrapper_list_to_object_list(List<PersonDataAPI> character_wrapper_list)
    {   
        List<PersonAPI> character_object_list = new ArrayList<PersonAPI>();


        for (PersonDataAPI current_character_wrapper : character_wrapper_list)
            character_object_list.add(current_character_wrapper.getPerson());


        return character_object_list;
    }




    @Override
    public void onGameLoad(boolean newGame)
    {
        swagify_init();
    }
}
