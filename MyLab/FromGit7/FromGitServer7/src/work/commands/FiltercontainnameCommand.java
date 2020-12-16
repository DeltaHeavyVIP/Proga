package work.commands;

import dragon.Dragon;
import work.Commands;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class FiltercontainnameCommand extends Commands {
    private static String answ = "";

    public static String execute(CopyOnWriteArrayList<Dragon> dragons, String subname) {

        for (Dragon dragon : dragons) {
            if (dragon.getName().contains(subname)) {
                answ = answ + "\n" + dragon.getName();
            }
        }
        return answ;
    }
}
