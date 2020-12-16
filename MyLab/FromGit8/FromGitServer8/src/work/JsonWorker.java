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
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class JsonWorker {

    private static DataBaseConnector dbc = new DataBaseConnector();
    private static Connection connection = null;

    public synchronized ArrayList<Dragon> start() {
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



    public synchronized String transformDragon(Dragon dragon){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(dragon);
        return json;
    }

    public synchronized void setIdFromPSQL(CopyOnWriteArrayList<Dragon> dragons){
        try {
            if(dragons.size() != 0) {
                connection = dbc.getCon();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM dragons");
                int j = 0;
                while (resultSet.next()) {
                    int idFromPSQL = resultSet.getInt(2);
                    Dragon dragonNumberDontKnow = dragons.get(j);
                    dragonNumberDontKnow.setId(idFromPSQL);
                    j++;
                }
                resultSet.close();
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public synchronized String transformAll(String command,CopyOnWriteArrayList<Dragon> dragons){
        String line = "";
        try {
            String dragonFromSQL = "";
            connection = dbc.getCon();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dragons");
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            if (!command.equals("reorder")) {
                while (resultSet.next()) {
                    dragonFromSQL = resultSet.getString(1);
                    Dragon dragon = gson.fromJson(dragonFromSQL, Dragon.class);
                    dragon.setId(resultSet.getInt(2));
                    String[] birthday = dragon.getKiller().getBirthday().toString().split("-");
                    line = line + dragon.getId() + "+" + dragon.getName() + "+" + dragon.getCoordinates().getX() + "+" +
                            dragon.getCoordinates().getY() + "+" + dragon.getAge() + "+" + dragon.getColor() + "+" + dragon.getType() + "+" + dragon.getCharacter() + "+" +
                            dragon.getKiller().getName() + "+" + birthday[0] + "+" + birthday[1] + "+" + birthday[2] + "+" + dragon.getKiller().getHeight() + "+" +
                            dragon.getKiller().getPassportID() + "+" + dragon.getKiller().getLocation().getX() + "+" + dragon.getKiller().getLocation().getY() + "+" +
                            dragon.getKiller().getLocation().getZ() + "+" + dragon.getKiller().getLocation().getName() + "|";
                }
            }else {
                Collections.reverse(dragons);
                for(int i=0;i<dragons.size();i++) {
                    String[] birthday = dragons.get(i).getKiller().getBirthday().toString().split("-");
                    line = line + dragons.get(i).getId() + "+" + dragons.get(i).getName() + "+" + dragons.get(i).getCoordinates().getX() + "+" +
                            dragons.get(i).getCoordinates().getY() + "+" + dragons.get(i).getAge() + "+" + dragons.get(i).getColor() + "+" + dragons.get(i).getType() + "+" + dragons.get(i).getCharacter() + "+" +
                            dragons.get(i).getKiller().getName() + "+" + birthday[0] + "+" + birthday[1] + "+" + birthday[2] + "+" + dragons.get(i).getKiller().getHeight() + "+" +
                            dragons.get(i).getKiller().getPassportID() + "+" + dragons.get(i).getKiller().getLocation().getX() + "+" + dragons.get(i).getKiller().getLocation().getY() + "+" +
                            dragons.get(i).getKiller().getLocation().getZ() + "+" + dragons.get(i).getKiller().getLocation().getName() + "|";
                }
                System.out.println("1");
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            System.out.println("Ошибка в где то там");
        }
        return line;
    }

}
