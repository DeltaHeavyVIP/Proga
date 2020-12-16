import dragon.*;
import work.CommandSelector;
import work.Commands;
import work.JsonWorker;
import work.commands.SaveCommand;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class YES extends Commands {
    public static String filePath = null;

    public static void main(String[] args) {
        try {

            /*filePath = args[0];*/
            filePath = "C:\\Users\\Vova\\IdeaProjects\\FromGit\\YES.json";
            String[] json = filePath.trim().split("\\.");
            if (json[1].equals("json")) {

                JsonWorker work = new JsonWorker();
                ArrayList<Dragon> dragons = work.start(filePath);
                CommandSelector commandSelector = new CommandSelector();
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();

                while (!command.equals("exit")) {
                    commandSelector.start(command, dragons, filePath);
                    SaveCommand.execute(dragons, filePath);
                    command = scanner.nextLine();
                }
            } else {
                System.out.println("Скорее всего вы ввели неправильно путь, попробуйте снова с правильным расширением(json)");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Не ломайте нашу прогу плез");
        }
    }
}