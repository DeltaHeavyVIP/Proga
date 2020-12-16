package work.commands;

import dragon.Dragon;
import dragon.DragonBuilder;
import work.Commands;

import java.util.ArrayList;

public class AddCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons){
        DragonBuilder dragonBuilder = new DragonBuilder();
        Dragon dragonplus = dragonBuilder.plusDragon();
        if (dragonplus != null && !dragonplus.equals("null"))
        dragons.add(dragonplus);

    }
}
