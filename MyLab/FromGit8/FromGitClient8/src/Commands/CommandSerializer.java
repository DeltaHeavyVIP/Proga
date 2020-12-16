package Commands;

import work.Output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandSerializer {
    private static ByteArrayOutputStream byteArrayOutputStream;

    public static byte[] serializable(Output output)  {
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(output);
            objectOutputStream.flush();
        } catch (IOException e){
            System.out.println("траблы в сериализаци ");
        }

        return byteArrayOutputStream.toByteArray();
    }
}