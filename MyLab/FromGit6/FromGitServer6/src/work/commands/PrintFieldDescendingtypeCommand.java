package work.commands;

import dragon.Dragon;
import dragon.DragonType;
import work.Commands;

import java.util.ArrayList;
import java.util.Comparator;

public class PrintFieldDescendingtypeCommand extends Commands {
    private static String answ = "";

    public static String execute(ArrayList<Dragon> dragons){
        ArrayList<DragonType> types = new ArrayList<DragonType>();
        for ( Dragon dragon : dragons)
        {
            dragon.getType();
            types.add(dragon.getType());
        }

        class TypeComparator implements Comparator<DragonType> {
            @Override
            public int compare(DragonType t1, DragonType t2){
                return t1.compareTo(t2);
            }
        }
        Comparator comparator = new TypeComparator();
        types.sort(comparator);
        for (DragonType dragonType :types){
            answ = answ + dragonType + "\n";
        }
        return answ;
    }
}
