package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class RemoveatCommand extends Commands {

    public static String execute(ArrayList<Dragon> dragons, String idaa){
        int id = Integer. parseInt(idaa);
        dragons.remove(id);
        return "удалено по index";
    }

}
