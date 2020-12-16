package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class ShowCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons){
        for (Dragon o : dragons){
            System.out.println(o.getName());
        }
        System.out.println("Количество элементов: " + dragons.size());
    }
}
