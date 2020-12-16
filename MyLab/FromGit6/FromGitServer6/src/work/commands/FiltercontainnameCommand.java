package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class FiltercontainnameCommand extends Commands {
    private static String answ = "";

    public static String execute(ArrayList<Dragon> dragons, String subname) {

        for (Dragon dragon : dragons) {
            if (dragon.getName().contains(subname)) {
                answ = answ + "\n" + dragon.getName();
            }
        }
        return answ;
    }
}
