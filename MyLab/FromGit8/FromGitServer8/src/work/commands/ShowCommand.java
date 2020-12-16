package work.commands;

import dragon.Dragon;
import work.Commands;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShowCommand extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons){
        for (Dragon o : dragons){
            System.out.println(o.getName());
        }
        String answ = "show.txt " + dragons.size()  +"\n";
        return answ;
    }
}
