package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class RemovebyIdCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons, String ida){
        int id = Integer. parseInt(ida);
        for (int i=0;i<dragons.size();++i){
            if(dragons.get(i).getId() == id){
                dragons.remove(dragons.get(i));
            }
        }
    }

}
