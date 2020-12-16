import Server.Server;
import Server.ConnectionWorker;
import dragon.*;
import work.CommandSelector;
import work.Commands;
import work.JsonWorker;
import work.Output;
import work.commands.CommandDeserializer;
import work.commands.ExitCommand;
import work.commands.SaveCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class YES extends Commands {
    public static String filePath = null;
    private static int port = 5559 ;


    public static void main(String[] args) {
        try {

            Server server = new Server(port,new CommandDeserializer());
            while (true){
                Output output = server.start();

                filePath = args[0];
                /*filePath = "C:\\Users\\Vova\\IdeaProjects\\FromGitServer\\YES.json";*/
                String[] json = filePath.trim().split("\\.");
                if (json[1].equals("json")) {

                    JsonWorker work = new JsonWorker();
                    ArrayList<Dragon> dragons = work.start(filePath);
                    CommandSelector commandSelector = new CommandSelector();
                    String command = output.getCommand();

                    String answ = commandSelector.start(command, dragons, filePath, output);
                    SaveCommand.execute(dragons, filePath);
                    ConnectionWorker.outputStarter(answ);

                } else {
                    System.out.println("Скорее всего вы ввели неправильно путь, попробуйте снова с правильным расширением(json)");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Не ломайте нашу прогу плез в Main");
        } catch (IOException e){
            System.out.println("Ошибка в Main классе");
        }
    }
}