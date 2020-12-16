package work.commands;

import work.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CommandDeserializer {

    private Output output = null;

    public Output deserializer(byte[] bytes){
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Object object = inputStream.readObject();
            output = (Output)object;
            inputStream.close();
            System.out.println("объект продессериализировался");

        } catch (IOException e) {
            System.out.println("Ошибка в методе deserializer");
        }catch (ClassNotFoundException e){
            System.out.println("+f");
        }

        return output;

    }
}