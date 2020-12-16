package work.commands;

import dragon.Dragon;
import work.Commands;
import work.DragonComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Addifmax extends Commands {

    public static String execute(ArrayList<Dragon> dragons, Dragon dragon) {
        String answ = "добавлено";
        Comparator comparator = new DragonComparator();
        Dragon dragonplus = dragon;
        if (dragonplus != null && !dragonplus.equals("null"))
            dragons.add(dragonplus);
        dragons.sort(comparator);
        if(!dragonplus.equals(dragons.get(0))){
            dragons.remove(dragonplus);
            answ = "не добавлено";
        }
        return answ;
    }

}
