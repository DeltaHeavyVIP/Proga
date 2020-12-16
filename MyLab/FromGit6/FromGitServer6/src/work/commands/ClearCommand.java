package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class ClearCommand extends Commands {

    public static String execute(ArrayList<Dragon> dragons){
        dragons.clear();
        return "Почистил";
    }

}
