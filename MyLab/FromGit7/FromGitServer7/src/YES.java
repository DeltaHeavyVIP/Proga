import Server.*;
import Server.ConnectionWorker;
import dragon.*;

import work.CommandSelector;
import work.Commands;
import work.JsonWorker;
import work.Output;
import work.commands.CommandDeserializer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;


public class YES {
    private static int port = 5565 ;

    public static void main(String [] args){
        try {
            Server server = new Server(port, new CommandDeserializer());
            DataBaseWorker dbw = new DataBaseWorker();
            DataBaseWorker.start();
            while (true) {
                server.start();
                Output output = ConnectionWorker.getOutput();

                JsonWorker work = new JsonWorker();
                CopyOnWriteArrayList<Dragon> dragonsSave = new CopyOnWriteArrayList<>(work.start());
                CommandSelector commandSelector = new CommandSelector();
                String command = output.getCommand();

                String answ = commandSelector.start(command, dragonsSave, output);
                ConnectionWorker.outputStarter(answ);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Не ломайте нашу прогу плез в Main");
        } catch (IOException e) {
            System.out.println("Ошибка в Main классе");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}