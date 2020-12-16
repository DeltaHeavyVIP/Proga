package work.commands;

import dragon.Dragon;
import dragon.DragonBuilder;
import work.Commands;
import work.Output;

import java.util.ArrayList;

public class AddCommand extends Commands {

    public static String execute(ArrayList<Dragon> dragons, Dragon dragon){
        Dragon dragonplus = dragon;
        if (dragonplus != null && !dragonplus.equals("null"))
        dragons.add(dragonplus);
        return "добавлено";
    }
}
