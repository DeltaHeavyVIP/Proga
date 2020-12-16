package work.commands;

import dragon.Dragon;
import dragon.DragonBuilder;
import work.Commands;

import java.util.ArrayList;

public class UpdateCommand extends Commands {

    public static String execute(ArrayList<Dragon> dragons, String idaaa,Dragon dragon){
        int id = Integer.parseInt(idaaa);
        for (int i=0 ; i< dragons.size();++i) {
            if (dragons.get(i).getId().equals(id)) {
                dragons.set(i,dragon);
            }
        }
        return "обновил";
    }

}
