package phoni.swagify.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.fs.starfarer.api.Global;

public class json 
{
    public static List<String> JSONArray_to_list(JSONArray json_array)
    {   
        List<String> exampleList = new ArrayList<String>();

        for(int i=0; i< json_array.length(); i++)
        {
            try 
            {
                exampleList.add(json_array.getString(i));
            } 
            
            catch (JSONException exception) 
            {
                Global.getLogger(json.class).error(exception);
            }
        }

        return exampleList;
    }
}
