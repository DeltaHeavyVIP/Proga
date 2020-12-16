package work.commands;

import dragon.Dragon;
import work.Commands;

import java.util.ArrayList;

public class SumofageCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons) {
        long age = 0;
        for (int i = 0; i < dragons.size(); ++i) {
            age = age + dragons.get(i).getAge();
        }
        System.out.println(age);
    }
}
