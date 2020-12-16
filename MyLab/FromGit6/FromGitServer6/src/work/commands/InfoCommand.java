package work.commands;

import dragon.Dragon;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Files;

import java.util.ArrayList;

public class InfoCommand {
    private static String answ;


    public static String execute(String filepath, ArrayList<Dragon> dragons){
        Path path =  Paths.get(filepath);
        try {
            answ = "Количество элементов: " + dragons.size() + "\n"
                    +"Тип коллекции: " + dragons.getClass().toString().split("\\.")[2] +"\n"
                    +"Имя файла: " + path.toString()+"\n"
                    +Files.getLastModifiedTime(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answ;
    }

}
