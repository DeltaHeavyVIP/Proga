package Server;

import dragon.Dragon;
import org.postgresql.util.PSQLException;
import work.JsonWorker;
import work.Output;

import java.sql.*;

public class DataBaseWorker {
    public static String user_name = null;
    private static Connection connection = null;
    private static  DataBaseConnector dbc = new DataBaseConnector();


    public static synchronized void start() throws SQLException{
        dbc.connect();
        connection = dbc.getCon();

        Statement statement = connection.createStatement();
        try {
            statement.executeQuery("CREATE TABLE users(login text NOT NULL , password text, primary key (login, password))");
        } catch (PSQLException exist){

        }
        try {
            statement = connection.createStatement();
            statement.executeQuery("CREATE TABLE Dragons(dragons text, id SERIAL, log text)");

        } catch (SQLException e){

        }
        statement.close();
        System.out.println("Table for clients and dragons(no) exists");
    }

    public static synchronized boolean checkUser(Output output) throws SQLException{
        String login = output.getLog();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE login ='"+login+"'");
        boolean inf = resultSet.next() ;
        resultSet.close();
        statement.close();
        return inf;
    }


    public static synchronized String getPass(Output output){
        byte[] pass = output.getPassword();//in sha512
        String password;
        StringBuilder sb = new StringBuilder();
        if (!(pass == null)){
            for (int i = 0; i < pass.length; i++) {
                sb.append(Integer.toString((pass[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        return password = sb.toString();
    }

    public static synchronized boolean checkPass(Output output) throws SQLException {
        String login = output.getLog();
        String pass = DataBaseWorker.getPass(output);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE login ='" + login + "'AND password ='" + pass + "'");
        boolean inf = resultSet.next() ;
        resultSet.close();
        statement.close();
        return inf;
    }


    public static synchronized void putclient(Output output) throws SQLException{
        String log = output.getLog();
        String password = getPass(output);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO users (login, password) VALUES ('"+log+"', '"+password+"')");
        statement.close();
    }
    public static synchronized void putDragon(Dragon dragon) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Dragons(dragons, log) VALUES(?,?) ");
        JsonWorker jsonWorker = new JsonWorker();
        String strDragon = jsonWorker.transformDragon(dragon);
        preparedStatement.setString(1,strDragon);
        preparedStatement.setString(2, user_name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static synchronized Connection getConnection(){
        return connection;
    }
}