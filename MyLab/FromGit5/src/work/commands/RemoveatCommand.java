package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class RemoveatCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons, String idaa){
        int id = Integer. parseInt(idaa);
        dragons.remove(id);
    }

}
