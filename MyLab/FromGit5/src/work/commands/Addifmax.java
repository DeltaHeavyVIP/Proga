package work.commands;

import dragon.Dragon;
import dragon.DragonBuilder;
import work.Commands;
import work.DragonComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Addifmax extends Commands {

    public static void execute(ArrayList<Dragon> dragons) {
        Comparator comparator = new DragonComparator();
        DragonBuilder dragonBuilder = new DragonBuilder();
        Dragon dragonplus = dragonBuilder.plusDragon();
        if (dragonplus != null && !dragonplus.equals("null"))
            dragons.add(dragonplus);
        dragons.sort(comparator);
        if(!dragonplus.equals(dragons.get(0))){
            dragons.remove(dragonplus);
        }

    }

}
