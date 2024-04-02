package phoni.swagify;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.ImportantPeopleAPI.PersonDataAPI;
import com.fs.starfarer.api.characters.AdminData;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import phoni.swagify.utils.character;




public class swagify_sprite_override extends BaseModPlugin 
{   
    static void swagify_init(boolean should_swagify_characters)
    {
        List<PersonDataAPI> important_character_wrapper_list = Global.getSector().getImportantPeople().getPeopleCopy();
        List<OfficerDataAPI> officer_wrapper_list            = Global.getSector().getPlayerFleet().getFleetData().getOfficersCopy();
        List<AdminData> admin_wrapper_list                   = Global.getSector().getCharacterData().getAdmins();
        PersonAPI player_object                              = Global.getSector().getCharacterData().getPerson();


        List<PersonAPI> character_object_list = character.wrapper_list_to_object_list(important_character_wrapper_list);
        List<PersonAPI> officer_object_list   = character.wrapper_list_to_object_list(officer_wrapper_list);
        List<PersonAPI> admin_object_list     = character.wrapper_list_to_object_list(admin_wrapper_list);


        character_object_list.addAll(officer_object_list);
        character_object_list.addAll(admin_object_list);
        character_object_list.add(player_object);


        Dictionary<String, PersonAPI> character_object_dict = character.object_list_to_dict(character_object_list);



        
        if (!should_swagify_characters)
        {
            for (PersonAPI current_character_object : character_object_list)
            {
                swagify_character(current_character_object, swagify_config.DESWAG_STRING_TARGET_PAIR);
            }
        }




        else
        {   
            if (swagify_config.swag_characters.contains(swagify_config.ALL_CHARACTERS))
            {
                for (PersonAPI current_character_object : character_object_list)
                {
                    swagify_character(current_character_object, swagify_config.SWAG_STRING_TARGET_PAIR);
                }

                return;
            }


            if (swagify_config.swag_characters.contains(swagify_config.ALL_PLAYERS))
            {
                swagify_character(player_object, swagify_config.SWAG_STRING_TARGET_PAIR);
            }




            Iterator<String> swag_characters_iterator = swagify_config.swag_characters.iterator();

            String current_swag_character;
            PersonAPI current_swag_character_object;
    
    
            while (swag_characters_iterator.hasNext()) 
            {   
                current_swag_character = swag_characters_iterator.next();
                current_swag_character_object = character_object_dict.get(current_swag_character);

                if (current_swag_character_object != null)
                {   
                    swagify_character(current_swag_character_object, swagify_config.SWAG_STRING_TARGET_PAIR);
                }
            }
        }
    }




    static void swagify_character(PersonAPI character_object, Dictionary<String, String> string_target_pair)
    {   
        StringBuilder string_builder = new StringBuilder();

        
        String character_sprite_pointer = character_object.getPortraitSprite();
        String swag_character_sprite_pointer;


        //Failsafe Incase Replacement Target Isn't In Sprite Pointer
        if (!(character_sprite_pointer.contains(string_target_pair.get("target"))))
        {
            return;
        }

        //Failsafe Incase Substring We Are Inserting Into String Is Already In String, Unless Substring Is In What We Want To Replace In The String (Prevents Infinite Feedback Loops)
        if ((character_sprite_pointer.contains(string_target_pair.get("replacement"))) && !(string_target_pair.get("target").contains(string_target_pair.get("replacement"))))
        {
            return;
        }


        Dictionary<String, Integer> substring_index_pair = new Hashtable<>();


        substring_index_pair.put(
                                    "start_index", 
                                    character_sprite_pointer.indexOf(string_target_pair.get("target"))
                                );
        substring_index_pair.put(
                                    "end_index", 
                                    substring_index_pair.get("start_index") + string_target_pair.get("target").length()
                                );
        

     
        
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
        swagify_init(true);
    }

    @Override
    public void afterGameSave()
    {
        if (!swagify_config.is_sprite_change_permanent)
        {
            swagify_init(true);
        }
    }


    @Override
    public void beforeGameSave()
    {
        if (!swagify_config.is_sprite_change_permanent)
        {
            swagify_init(false);
        }
    }
}
