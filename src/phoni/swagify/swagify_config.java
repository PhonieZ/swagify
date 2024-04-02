package phoni.swagify;

import phoni.swagify.utils.json;

import com.fs.starfarer.api.Global;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;




public class swagify_config 
{   
    public static final String SEPARATOR = "_";
    public static final String ALL_PLAYERS = "all_players";
    public static final String ALL_CHARACTERS = "all_characters";


    public static final Dictionary<String, String> SWAG_STRING_TARGET_PAIR = new Hashtable<>();
    static
    {
        SWAG_STRING_TARGET_PAIR.put("target", "graphics");
        SWAG_STRING_TARGET_PAIR.put("replacement", "graphics/phoni/swagify");
    }

    public static final Dictionary<String, String> DESWAG_STRING_TARGET_PAIR = new Hashtable<>();
    static
    {
        DESWAG_STRING_TARGET_PAIR.put("target", "graphics/phoni/swagify");
        DESWAG_STRING_TARGET_PAIR.put("replacement", "graphics");
    }


    public static final String CONFIG_FILE = "phoni_swagify_config.json";


    public static Set<String> swag_characters;
    public static boolean is_sprite_change_permanent;




    static 
    {
		try 
        {   
            JSONObject settings = Global.getSettings().loadJSON(CONFIG_FILE);


			swag_characters = new HashSet<>(json.JSONArray_to_list(settings.optJSONArray("swag_characters")));
            is_sprite_change_permanent = settings.optBoolean("is_sprite_change_permanent", is_sprite_change_permanent);
		} 
        



		catch (IOException | JSONException exception) 
        {
			throw new RuntimeException("Failed To Load Swagify Config", exception);
		}
	}
}
