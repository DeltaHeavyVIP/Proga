package work;

import dragon.Dragon;

import java.util.Comparator;

public class DragonComparator implements Comparator<Dragon> {

    @Override
    public int compare(Dragon dragon1, Dragon dragon){
        return (dragon1.getName().compareTo(dragon.getName()));
    }
}