package phoni.swagify.data.console.commands;

import com.fs.starfarer.api.campaign.CharacterDataAPI;
import com.fs.starfarer.api.Global;

import org.lazywizard.console.BaseCommand;
import org.lazywizard.console.CommonStrings;
import org.lazywizard.console.Console;

public class set_portrait implements BaseCommand {

    @Override
    public CommandResult runCommand(String args, CommandContext context) {
        if (context == CommandContext.COMBAT_MISSION) {
            Console.showMessage(CommonStrings.ERROR_CAMPAIGN_ONLY);
            return CommandResult.WRONG_CONTEXT;
        }

        CharacterDataAPI characterData;


        characterData = Global.getSector().getCharacterData();

        Console.showMessage(args);
        characterData.setPortraitName(args);

        return(CommandResult.SUCCESS);
    }

}