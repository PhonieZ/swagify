package phoni.swagify.utils;

import com.fs.starfarer.api.characters.AdminData;
import com.fs.starfarer.api.characters.ImportantPeopleAPI.PersonDataAPI;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import phoni.swagify.swagify_config;




public class character
{   
    public static Dictionary<String, PersonAPI> object_list_to_dict(List<PersonAPI> character_object_list)
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



    public static List<PersonAPI> wrapper_list_to_object_list(List<?> character_wrapper_list) 
    {   
        final boolean is_type_PersonDataAPI  = (character_wrapper_list.get(0) instanceof PersonDataAPI);
        final boolean is_type_OfficerDataAPI = (character_wrapper_list.get(0) instanceof OfficerDataAPI);
        final boolean is_type_AdminData      = (character_wrapper_list.get(0) instanceof AdminData);
        List<PersonAPI> character_object_list = new ArrayList<PersonAPI>();



        if (character_wrapper_list.isEmpty() || !(is_type_OfficerDataAPI || is_type_PersonDataAPI || is_type_AdminData)) 
        {
            throw new IllegalArgumentException("List Must Be Of Type PersonDataAPI, OfficerDataAPI Or AdminData");
        }



        if (is_type_PersonDataAPI) 
        {
            for (Object current_character_wrapper : character_wrapper_list) 
            {
                character_object_list.add(((PersonDataAPI) current_character_wrapper).getPerson());
            }
        } 

        else if (is_type_OfficerDataAPI)
        {
            for (Object current_character_wrapper : character_wrapper_list) 
            {
                character_object_list.add(((OfficerDataAPI) current_character_wrapper).getPerson());
            }
        } 

        else if (is_type_AdminData)
        {
            for (Object current_character_wrapper : character_wrapper_list) 
            {
                character_object_list.add(((AdminData) current_character_wrapper).getPerson());
            }
        } 



        return character_object_list;
    }
}
