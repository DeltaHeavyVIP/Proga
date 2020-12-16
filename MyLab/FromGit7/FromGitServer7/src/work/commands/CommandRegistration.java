
package work.commands;

import Server.DataBaseWorker;
import work.Commands;
import work.Output;

import java.sql.SQLException;

public class CommandRegistration extends Commands {
    private static String answ = "";

    public static String execute(Output output){
        try {
            if(!DataBaseWorker.checkUser(output)){
                DataBaseWorker.putclient(output);
                System.out.println("Появился");
                answ = "- Регистрация завершена, спасибо за сотрудничество! -";
            }else {
                answ = "- Этот логин существует -";
            }
        } catch (SQLException e){
            answ = "- Такой аккаунт уже существует -";
        }
        return answ;
    }


}