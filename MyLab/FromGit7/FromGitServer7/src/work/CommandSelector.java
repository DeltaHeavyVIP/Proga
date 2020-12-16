package work;

import dragon.*;
import work.commands.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandSelector {
    private String answ = "";

    public String start(String command, CopyOnWriteArrayList<Dragon> dragons, Output output) {
        switch (output.getCommand().trim()) {
            case "help":
                answ = HelpCommand.execute();
                break;
            case "info":
                answ = InfoCommand.execute(dragons);
                break;
            case "show":
                answ = ShowCommand.execute(dragons);
                break;
            case "clear":
                answ = ClearCommand.execute(dragons);
                break;
            case "save":
                answ = SaveCommand.execute();
                break;
            case "reorder":
                answ =ReorderCommand.execute(dragons);
                break;
            case "sum_of_age":
                answ = SumofageCommand.execute(dragons);
                break;
            case "add":
                answ = AddCommand.execute(dragons,output.getDragon());
                break;
            case "update":
                answ = UpdateCommand.execute(dragons,output.getArgs().trim(),output.getDragon());
                break;
            case "remove_by_id":
                answ = RemovebyIdCommand.execute(output.getArgs().trim(),output);
                break;
            case "execute_script":
                answ = ExecuteCommand.execute(dragons,output);
                break;
            case "add_if_max":
                answ = Addifmax.execute(dragons,output.getDragon());
                break;
            case "filter_contains_name":
                answ = FiltercontainnameCommand.execute(dragons,output.getArgs().trim());
                break;
            case "print_field_descending_type":
                answ = PrintFieldDescendingtypeCommand.execute(dragons);
                break;
            case "exit":
                answ = ExitCommand.execute();
                break;
            case "registration":
                answ = CommandRegistration.execute(output);
                break;
            case "authorization":
                answ = CommandAuthorization.execute(output);
                break;
            default:
                answ = "Некорректный ввод! Воспользуйтесь командой help";
        }
        return answ;
    }

}