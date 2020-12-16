package work;

import dragon.*;
import work.commands.*;

import java.util.ArrayList;

public class CommandSelector {

    public void start(String command, ArrayList<Dragon> dragons, String filePath) {
        String[] parts = command.split(" ");
        switch (parts[0].trim()) {
            case "help":
                HelpCommand.execute();
                break;
            case "info":
                InfoCommand.execute(filePath, dragons);
                break;
            case "show":
                ShowCommand.execute(dragons);
                break;
            case "clear":
                ClearCommand.execute(dragons);
                break;
            case "save":
                SaveCommand.execute(dragons, filePath);
                break;
            case "reorder":
                ReorderCommand.execute(dragons);
                break;
            case "sum_of_age":
                SumofageCommand.execute(dragons);
                break;
            case "add":
                AddCommand.execute(dragons);
                break;
            case "update":
                UpdateCommand.execute(dragons,parts[1].trim());
                break;
            case "remove_by_id":
                RemovebyIdCommand.execute(dragons,parts[1].trim());
                break;
            case "execute_script":
                ExecuteCommand.execute(dragons,filePath,parts[1].trim());
                break;
            case "remove_at":
                RemoveatCommand.execute(dragons,parts[1].trim());
                break;
            case "add_if_max":
                Addifmax.execute(dragons);
                break;
            case "filter_contains_name":
                FiltercontainnameCommand.execute(dragons,parts[1].trim());
                break;
            case "print_field_descending_type":
                PrintFieldDescendingtypeCommand.execute(dragons);
                break;
            default:
                System.out.println("Некорректный ввод! Воспользуйтесь командой help");
        }
    }

}