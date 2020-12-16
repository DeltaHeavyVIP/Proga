package work.commands;

import Server.DataBaseWorker;
import dragon.Dragon;
import work.Commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class UpdateCommand extends Commands {

    public static String execute(CopyOnWriteArrayList<Dragon> dragons, String idaaa, Dragon dragon){
        String answ = "update1.txt";
        int id = Integer.parseInt(idaaa);
        Connection connection = DataBaseWorker.getConnection();
        try {
            Statement statement = connection.createStatement();
            if( statement.executeUpdate("DELETE from dragons WHERE id = '" + id + "' AND log ='"+DataBaseWorker.user_name+"'") == 1)
            {
                AddCommand.execute(dragons,dragon);

            }else {
                answ = "update2.txt"  +"\n";
            }
        }catch (SQLException e){
            System.out.println("Error in UpdateCommand");
            e.getErrorCode();
        }

        return answ;
    }

}