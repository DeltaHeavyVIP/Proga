package account;

import Commands.CommandSerializer;
import work.Output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Registration {
    private Output output =  new Output();
    private String answerFromServer = "";
    private Socket socket;
    private byte[] outBytes;
    private ExistQuestion existQuestion;

    public Registration(ExistQuestion existQuestion){
        this.existQuestion = existQuestion;
    }

    public void startRegistration(int port) throws IOException, NoSuchAlgorithmException, InterruptedException {
        while (!answerFromServer.equals("- Регистрация завершена, спасибо за сотрудничество! -")) {
            output = new Output();
            System.out.println(" - Начнем регистрацию сначала - ");
            output.setCommand("registration");
            socket = new Socket("localhost", port);
            output.setLog(existQuestion.checklog());
            output.setPassword(existQuestion.SHA(existQuestion.checkpas()));

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            outBytes = CommandSerializer.serializable(output);

            dataOutputStream.write(outBytes);
            dataOutputStream.flush();
            Thread.sleep(3000);

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[dataInputStream.available()];
            inputStream.read(bytes, 0, dataInputStream.available());
            answerFromServer = new String(bytes, StandardCharsets.UTF_8);
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            System.out.println(answerFromServer);
        }
        existQuestion.check(port);
    }

}