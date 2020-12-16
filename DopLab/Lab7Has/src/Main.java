import Client.ConsoleManager;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        try {
            ConsoleManager consoleManager = new ConsoleManager();
            consoleManager.interactive(args[0], args[1]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Аргументы введены некорректно.");
        }
    }

}
// register 25 25 patutin.vsa@mail.ru