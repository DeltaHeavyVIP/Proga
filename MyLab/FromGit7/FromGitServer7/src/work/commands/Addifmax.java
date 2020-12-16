package work.commands;

import Server.DataBaseWorker;
import dragon.Dragon;
import work.Commands;
import work.DragonComparator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Addifmax extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons, Dragon dragon) {
        String answ = "добавлено";
        Comparator comparator = new DragonComparator();
        Dragon dragonplus = dragon;
        if (dragonplus != null && !dragonplus.equals("null"))
            System.out.println(dragons);
        dragons.add(dragonplus);
        dragons.sort(comparator);
        System.out.println(dragons);
        if(!dragonplus.getName().equals(dragons.get(0).getName())){
            dragons.remove(dragonplus);
            answ = "не добавлено";
        }else {
            try {
                DataBaseWorker.putDragon(dragon);
            }catch (SQLException e){
                System.out.println("Bad in add_if_max");
            }


        }
        return answ;
    }

}