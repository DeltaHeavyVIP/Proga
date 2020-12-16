package work.commands;

import dragon.Dragon;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Files;

import java.util.ArrayList;

public class InfoCommand {

    public static void execute(String filepath, ArrayList<Dragon> dragons){
        Path path =  Paths.get(filepath);
        try {
            System.out.println("Количество элементов: " + dragons.size());
            System.out.println("Тип коллекции: " + dragons.getClass().toString().split("\\.")[2]);
            System.out.println("Имя файла: " + path.toString());
            System.out.println(Files.getLastModifiedTime(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
