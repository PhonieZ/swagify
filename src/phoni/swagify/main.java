package phoni.swagify;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CharacterDataAPI;

public class main extends BaseModPlugin 
{
    private static void sprite_changer_test(boolean newGame)
    {   
        String sprite_pointer = "graphics/portraits/characters/yannick_ram.png";
        String init_sprite_pointer = "graphics/portraits/characters/andrada1.png";
        CharacterDataAPI characterData = Global.getSector().getCharacterData();


        if (newGame)
        {
            characterData.setPortraitName(init_sprite_pointer);
        }

        else
        {
            characterData.setPortraitName(sprite_pointer);
        }
    }


    @Override
    public void onGameLoad(boolean newGame)
    {
        sprite_changer_test(newGame);
    }
}
