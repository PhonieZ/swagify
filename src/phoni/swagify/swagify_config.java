package phoni.swagify;

import phoni.swagify.utils.json;

import com.fs.starfarer.api.Global;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;




public class swagify_config 
{   
    public static final String SEPARATOR = "_";
    public static final String ALL_PLAYERS = "all_players";

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
