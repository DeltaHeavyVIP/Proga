package work.commands;

import dragon.Dragon;
import work.CommandSelector;
import work.Commands;
import work.Output;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExecuteCommand extends Commands {
    private static int qo= -1;
    private static String answer = "";
    private static int numberOfCommand = 0;

    public static String execute(CopyOnWriteArrayList<Dragon> dragons, Output output) {
        try {
            answer = "";
            String answ ="";
            String commands = output.getExecute_commands();
            String[] commands_from_package = commands.split(" \\^");
            Dragon[] dragons_from = output.getDragon_execute();
            Dragon dragon_for_save = output.getDragon();

            CommandSelector commandSelector = new CommandSelector();

            for(int i=0; i<commands_from_package.length;i++){
                String[] commandNumber = commands_from_package[i].trim().split(" ");
                if(commandNumber[0].trim().equals("add") ||
                        commandNumber[0].trim().equals("add_if_max") ||
                        commandNumber[0].trim().equals("update")){
                    numberOfCommand = numberOfCommand+1;
                }
            }

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
                    if (!(numberOfCommand==1)) {
                        qo++;
                        Dragon dragon_from_output = dragons_from[qo];
                        output.setDragon(dragon_from_output);
                        answ = commandSelector.start(commandI[0].trim(), dragons, output);
                    }else {
                        Dragon oneDragonfromOutput = dragon_for_save;
                        dragon_for_save = null;
                        numberOfCommand = 0;
                        output.setDragon(oneDragonfromOutput);
                        answ = commandSelector.start(commandI[0].trim(), dragons, output);
                    }
                }else{
                    answ = commandSelector.start(commandI[0].trim(),dragons,output);
                }
                answer = answer + "\n" + answ;
            }
            qo=-1;
            output.setDragon(dragon_for_save);
        } catch (StackOverflowError e) {
            System.out.println("execute.txt");
        }
        return answer;
    }
}