package Commands.SpecificCommands;

import Commands.Command;
import Client.Receiver;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Add extends Command implements Serializable {
    transient private Receiver receiver;
    private static final long serialVersionUID = 32L;


    public Add(Receiver receiver) {
        this.receiver = receiver;
    }

    public Add() {

    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m add\u001B[0m: в коллекцию добавляется новый элемент.");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            Scanner sc = new Scanner(System.in);
            receiver.add(sc);
        }
    }
    @Override
    public void executeForScript(String[] args, Scanner sc){
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            try {
                receiver.add(sc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
