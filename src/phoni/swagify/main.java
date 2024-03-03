package phoni.swagify;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.Dictionary;
import java.util.Hashtable;

public class main extends BaseModPlugin 
{
    private static void swagify_player()
    {   
        StringBuilder string_builder = new StringBuilder();

        
        PersonAPI player_sprite_wrapper= Global.getSector().getCharacterData().getPerson();
        String player_sprite_pointer = player_sprite_wrapper.getPortraitSprite();
        String swag_player_sprite_pointer;


        Dictionary<String, String> string_target_pair = new Hashtable<>();
        Dictionary<String, Integer> substring_index_pair = new Hashtable<>();


        string_target_pair.put("target", "portraits");
        string_target_pair.put("replacement", "swag_portraits");


        substring_index_pair.put(
                                    "start_index", 
                                    player_sprite_pointer.indexOf(string_target_pair.get("target"))
                                );
        substring_index_pair.put(
                                    "end_index", 
                                    substring_index_pair.get("start_index") + string_target_pair.get("target").length()
                                );

        

        
        string_builder.append(player_sprite_pointer.substring(0, substring_index_pair.get("start_index"))); 
        //Start Index ==> Index Before Target

        string_builder.append(string_target_pair.get("replacement"));
        //Replacement String

        string_builder.append(player_sprite_pointer.substring(substring_index_pair.get("end_index"), player_sprite_pointer.length()));
        //Index After Target ==> End Index


        swag_player_sprite_pointer = string_builder.toString();




        player_sprite_wrapper.setPortraitSprite(swag_player_sprite_pointer);
    }   


    @Override
    public void onGameLoad(boolean newGame)
    {
        swagify_player();
    }
}
