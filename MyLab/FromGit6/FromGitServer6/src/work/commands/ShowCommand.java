package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class ShowCommand extends Commands {

    public static String execute(ArrayList<Dragon> dragons){
        for (Dragon o : dragons){
            System.out.println(o.getName());
        }
        String answ = "Количество элементов: " + dragons.size();
        return answ;
    }
}
