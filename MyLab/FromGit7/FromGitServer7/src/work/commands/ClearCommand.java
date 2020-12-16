package work.commands;

import Server.DataBaseWorker;
import dragon.Dragon;
import work.Commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClearCommand extends Commands {
    private static Connection connection = null;

    public static String execute(CopyOnWriteArrayList<Dragon> dragons) {

        connection = DataBaseWorker.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE from  dragons where studs.s284730.dragons.log = '"+DataBaseWorker.user_name+"'");
            statement.close();
            dragons.clear();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Почистил";
    }

}