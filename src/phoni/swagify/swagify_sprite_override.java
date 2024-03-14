package phoni.swagify;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ImportantPeopleAPI.PersonDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import phoni.swagify.utils.character;




public class swagify_sprite_override extends BaseModPlugin 
{   
    static void swagify_init()
    {
        List<PersonDataAPI> important_character_wrapper_list = Global.getSector().getImportantPeople().getPeopleCopy();
        PersonAPI player_object = Global.getSector().getCharacterData().getPerson();


        List<PersonAPI> character_object_list = character.wrapper_list_to_object_list(important_character_wrapper_list);
        character_object_list.add(player_object);


        Dictionary<String, PersonAPI> character_object_dict = character.object_list_to_dict(character_object_list);



        Iterator<String> swag_characters_iterator = swagify_config.swag_characters.iterator();

        String current_swag_character;
        PersonAPI current_swag_character_object;


        while (swag_characters_iterator.hasNext()) 
        {   
            current_swag_character = swag_characters_iterator.next();
            current_swag_character_object = character_object_dict.get(current_swag_character);
            
            
            if (current_swag_character.equals(swagify_config.ALL_PLAYERS))
            {
                swagify_character(player_object, swagify_config.SWAG_STRING_TARGET_PAIR);
            }

            else if (current_swag_character_object != null)
            {   
                swagify_character(current_swag_character_object, swagify_config.SWAG_STRING_TARGET_PAIR);
            }
        }
    }




    static void swagify_character(PersonAPI character_object, Dictionary<String, String> string_target_pair)
    {   
        StringBuilder string_builder = new StringBuilder();

        
        String character_sprite_pointer = character_object.getPortraitSprite();
        String swag_character_sprite_pointer;


        Dictionary<String, Integer> substring_index_pair = new Hashtable<>();


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
    



    @Override
    public void onGameLoad(boolean newGame)
    {
        swagify_init();
    }
}
