package work.commands;

import dragon.Dragon;
import work.CommandSelector;
import work.Commands;
import work.Output;

import java.io.*;
import java.util.ArrayList;

public class ExecuteCommand extends Commands {
    private static int qo= -1;
    private static String answer = "";

    public static String execute(ArrayList<Dragon> dragons, String filePath, Output output) {
        try {
            answer = "";
            String answ = "";
            String commands = output.getExecute_commands();
            String[] commands_from_package = commands.split(" \\^");
            Dragon[] dragons_from = output.getDragon_execute();
            Dragon dragon_for_save = output.getDragon();

            CommandSelector commandSelector = new CommandSelector();

            for(int i=0; i<commands_from_package.length;i++){
                String[] commandI = commands_from_package[i].trim().split(" ");
                output.setCommand(commandI[0].trim());
                if( commandI[0].trim().equals("update") || commandI[0].trim().equals("remove_by_id")
                        || commandI[0].trim().equals("execute_script") || commandI[0].trim().equals("remove_at")
                        || commandI[0].trim().equals("filter_contains_name") || commandI[0].trim().equals("print_field_descending_type") ){
                output.setArgs(commandI[1].trim());
                }
                if (commandI[0].trim().equals("execute_script")) {
                    throw new StackOverflowError();
                }else if(commandI[0].trim().equals("add") ||
                            commandI[0].trim().equals("add_if_max") ||
                                commandI[0].trim().equals("update")){
                    qo++;
                    Dragon dragon_from_output = dragons_from[qo];
                    output.setDragon(dragon_from_output);
                    answ = commandSelector.start(commandI[0].trim(),dragons,filePath,output);
                }else{
                    answ = commandSelector.start(commandI[0].trim(),dragons,filePath,output);
                }
                answer = answer + "\n" + answ;
            }
            qo=-1;
            output.setDragon(dragon_for_save);
        } catch (StackOverflowError e) {
            System.out.println("В файле команды находится рекурсия, т.е execute_script в execute_script ");
        }
        return answer;
    }
}