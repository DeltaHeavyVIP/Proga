package work;

import Server.DataBaseConnector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import dragon.Dragon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class JsonWorker {

    private static DataBaseConnector dbc = new DataBaseConnector();
    private static Connection connection = null;

    public ArrayList<Dragon> start() {
        ArrayList<Dragon> dragons = new ArrayList<Dragon>();
        try {
            connection = dbc.getCon();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dragons");
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            while (resultSet.next()) {
                String line = resultSet.getString(1);
                Dragon dragon = gson.fromJson(line, Dragon.class);
                dragon.setId(resultSet.getInt(2));
                dragons.add(dragon);
            }
            resultSet.close();
            statement.close();
        } catch (JsonSyntaxException e) {
            System.out.println("Файл битый");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dragons;
    }



    public String transformDragon(Dragon dragon){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(dragon);
        return json;
    }

    public Dragon transformString(String str){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Dragon dragon = gson.fromJson(str, Dragon.class);
        dragon.setId(Math.toIntExact((UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE)));
        return dragon;
    }
}
