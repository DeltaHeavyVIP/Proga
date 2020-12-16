package work;

import dragon.*;
import work.commands.*;

import java.util.ArrayList;

public class CommandSelector {
    private String answ = "";

    public String start(String command, ArrayList<Dragon> dragons, String filePath,Output output) {
        switch (output.getCommand().trim()) {
            case "help":
                answ = HelpCommand.execute();
                break;
            case "info":
                answ = InfoCommand.execute(filePath, dragons);
                break;
            case "show":
                answ = ShowCommand.execute(dragons);
                break;
            case "clear":
                answ = ClearCommand.execute(dragons);
                break;
            case "save":
                SaveCommand.execute(dragons, filePath);
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
                answ = RemovebyIdCommand.execute(dragons,output.getArgs().trim());
                break;
            case "execute_script":
                answ = ExecuteCommand.execute(dragons,filePath,output);
                break;
            case "remove_at":
                answ = RemoveatCommand.execute(dragons,output.getArgs().trim());
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
            default:
                answ = "Некорректный ввод! Воспользуйтесь командой help";
        }
        return answ;
    }

}