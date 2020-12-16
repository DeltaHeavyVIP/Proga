package work;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import dragon.Dragon;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class JsonWorker {

    public ArrayList<Dragon> start(String filepath) {
        ArrayList<Dragon> dragons = new ArrayList<Dragon>();
        try {

            File file = new File(filepath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Dragon dragon = gson.fromJson(line, Dragon.class);
                dragon.setId(Math.toIntExact((UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE)));
                dragons.add(dragon);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Пропишите дополнительные права доступа,Алексей Евгеньевич");
        } catch (JsonSyntaxException e){
            System.out.println("Файл битый");
        }
        return dragons;
    }

    public void end(ArrayList<Dragon> dragons,String filePath){
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Dragon dragon : dragons) {
                String json = gson.toJson(dragon);
                bufferedWriter.write(json + "\n");
            }

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Пропишите дополнительные права доступа,Алексей Евгеньевич");
        }
    }
}
