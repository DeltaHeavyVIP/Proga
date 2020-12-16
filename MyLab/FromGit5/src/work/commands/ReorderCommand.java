package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;
import java.util.Collections;

public class ReorderCommand  extends Commands {

    public static void execute( ArrayList<Dragon> dragons){
        Collections.reverse(dragons);
    }
}
