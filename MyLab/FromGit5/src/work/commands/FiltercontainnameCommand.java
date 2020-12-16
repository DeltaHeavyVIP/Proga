package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class FiltercontainnameCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons, String subname){

        for (Dragon dragon : dragons){
            if(dragon.getName().contains(subname)){
                System.out.println(dragon.getName());
            }
        }

    }
}
