import dragon.Dragon;
import dragon.DragonBuilder;
import work.Output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CommandExecute {
    private String linenow;
    private int i = 0;
    private static String execute_script = "";

    public int check(String filePathForCommand) {

        try {
            File file = new File(filePathForCommand);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((linenow = bufferedReader.readLine()) != null) {
                execute_script = execute_script + linenow + " ^";
                String[] lines = linenow.split(" ");
                switch (lines[0].trim()) {
                    case "add":
                        i = i+1;
                        break;
                    case "add_if_max":
                        i = i+1;
                        break;
                    case "update":
                        i = i+1;
                        break;
                    case "execute_script":
                        throw new StackOverflowError();
                }
            }
        } catch (IOException e) {
            System.out.println("ЫЫЫЫЫЫ, откуда тут эта ошибка? Ну я обработаю ее на всякий случай.");
        } catch (StackOverflowError e) {
            System.out.println("В файле команды находится рекурсия, т.е execute_script в execute_script ");
        }
        return i;
    }

    public void forExecute(int k, Output output){
        if(k == 0){
            System.out.println("Слишком адекватный файл был передан в execute, мое уважение");
        }else if(k == 1){
            System.out.println("В файле исполнения команд была найдена команда, которая нуждается в вас, пожалуйста, создайте дракона");
            Dragon dragon = new DragonBuilder().plusDragon();
            output.setDragon(dragon);
        } else{
            System.out.println("В файле исполнения команд были найдены команды от Письмака, тревога, создавайте драконов для защиты");
            Dragon[] dragons = new Dragon[k];
            for(int i=0; i<k ;i++){
                Dragon dragon = new DragonBuilder().plusDragon();
                dragons[i] = dragon;
            }
            output.setDragon_execute(dragons);
        }
        output.setExecute_commands(execute_script);
    }
}