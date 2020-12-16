package work.commands;

import dragon.Dragon;
import work.Commands;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SumofageCommand extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons) {
        long age = 0;
        for (int i = 0; i < dragons.size(); ++i) {
            age = age + dragons.get(i).getAge();
        }
        return "общий возраст:" + Long.toString(age);
    }
}
