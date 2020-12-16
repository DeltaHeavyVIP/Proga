package work.commands;

import dragon.Dragon;
import work.Commands;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReorderCommand  extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons){
        Collections.reverse(dragons);
        return "Я сделал";
    }
}
