package work.commands;

import Server.DataBaseWorker;
import work.Commands;
import work.Output;
import java.sql.SQLException;

public class CommandAuthorization extends Commands {
    private static String answ = "";

    public static String execute(Output output){
        try {
            if(DataBaseWorker.checkUser(output)) {
                if (DataBaseWorker.checkPass(output)) {
                    answ = "- Авторизация прошла успешно, приступайте к вводу команд -";
                    DataBaseWorker.user_name = output.getLog();
                } else {
                    answ = "- Пароль введен неправильно -";
                }
            }else{
                answ = "- Такого аккаунта не сущетсвует -";
            }
        }catch (SQLException e){
            answ ="It's bad in authorization, stop program";
        }
        return answ;
    }
}