package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class SaveCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons, String filepath){
        jsonWorker.end(dragons, filepath);
    }
}
