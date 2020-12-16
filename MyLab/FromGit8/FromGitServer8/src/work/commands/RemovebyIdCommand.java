package work.commands;

import Server.DataBaseWorker;
import dragon.Dragon;
import work.Commands;
import work.Output;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RemovebyIdCommand extends Commands {

    //private static DataBaseConnector dbc = new DataBaseConnector();
    private static Connection connection = null;

    public static synchronized String execute(String ida, Output output) {

        int id = Integer.parseInt(ida);
        connection = DataBaseWorker.getConnection();
        String answ = null;
        try {
            DataBaseWorker.user_name = output.getLog();
            System.out.println(output.getLog());
            Statement statement = connection.createStatement();
            if(statement.executeUpdate("DELETE FROM dragons WHERE id = '"+id+"' AND log = '"+DataBaseWorker.user_name+"'" ) == 1){
                answ = "remove_by_id1.txt" +"\n";

            }else {answ = "remove_by_id2.txt" +"\n";}
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answ;
    }
}