package work.commands;

import Server.DataBaseWorker;
import dragon.Dragon;
import work.Commands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddCommand extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons, Dragon dragon){
        Dragon dragonplus = dragon;
        if (dragonplus != null && !dragonplus.equals("null"))
        {
            if (dragons.add(dragonplus)){
                try {
                    DataBaseWorker.putDragon(dragonplus);
                }catch (SQLException e){
                    System.out.println("Все пошло в пизду в BDWorker & AddCommand");
                    e.printStackTrace();
                }
            }
        }
        return "add.txt" +"\n";
    }
}