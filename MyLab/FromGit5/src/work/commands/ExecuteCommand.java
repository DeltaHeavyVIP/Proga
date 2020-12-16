package work.commands;

import dragon.Dragon;
import work.CommandSelector;
import work.Commands;

import java.io.*;
import java.util.ArrayList;

public class ExecuteCommand extends Commands {

    public static void execute(ArrayList<Dragon> dragons, String filePath, String filePathForCommand) {
        try {
            String line;
            File file = new File(filePathForCommand);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            CommandSelector commandSelector = new CommandSelector();

            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(" ");
                if (lines[0].trim().equals("execute_script")) {
                    throw new StackOverflowError();
                } else {
                    commandSelector.start(line.trim(), dragons, filePath);
                    SaveCommand.execute(dragons, filePath);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("ЫЫЫЫЫЫ, откуда тут эта ошибка? Ну я обработаю ее на всякий случай.");
        } catch (StackOverflowError e) {
            System.out.println("В файле команды находится рекурсия, т.е execute_script в execute_script ");
        }
    }
}
//execute_script C:\Users\Vova\IdeaProjects\FromGit\commands.txt