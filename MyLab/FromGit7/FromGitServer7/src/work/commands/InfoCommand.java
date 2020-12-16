package work.commands;

import dragon.Dragon;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class InfoCommand {
    private static String answ;


    public static String execute( CopyOnWriteArrayList<Dragon> dragons){
        answ = "Количество элементов: " + dragons.size() + "\n"
                +"Тип коллекции: " + dragons.getClass().toString().split("\\.")[2] +"\n";
        return answ;
    }

}
