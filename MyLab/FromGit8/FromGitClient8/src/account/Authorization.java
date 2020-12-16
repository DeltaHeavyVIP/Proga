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

public class Authorization {
    public Output output;
    public Socket socket;
    private byte[] outBytes;
    private ExistQuestion existQuestion;
    private int port;
    private String login;
    private String password;
    private static String drugs = new String();

    public Authorization(ExistQuestion existQuestion, int port,String login,String password){
        this.existQuestion =existQuestion;
        this.port = port;
        this.login=login;
        this.password =password;
    }


    public void doItIfYes() throws NoSuchAlgorithmException, IOException, InterruptedException {

            output = new Output();
            output.setCommand("authorization");
            if(existQuestion.checkpas(password)){ output.setPassword(existQuestion.SHA(password));}
            if(existQuestion.checklog(login)){ output.setLog(login);}
            if(existQuestion.checklog(login) && existQuestion.checkpas(password)){
            output.setLog(login);
            output.setPassword(existQuestion.SHA(password));
            socket = new Socket("localhost", port);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            outBytes = CommandSerializer.serializable(output);

            dataOutputStream.write(outBytes);
            dataOutputStream.flush();
            Thread.sleep(3000);

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[dataInputStream.available()];
            inputStream.read(bytes, 0, dataInputStream.available());
            String answerFromServer = new String(bytes, StandardCharsets.UTF_8);
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

            String[] answerFromServerfull = answerFromServer.split("&");
            if (answerFromServerfull.length == 2) {
                drugs = answerFromServerfull[1];
            }
            answerFromServer = answerFromServerfull[0];

            System.out.println(answerFromServer);
            boolean fuckingflag = true;
            fuckingflag = answerFromServer.trim().equals("- Авторизация прошла успешно, приступайте к вводу команд -");
            if (fuckingflag) {
                existQuestion.setAuthorization(false);
            }
    }
    }

    public static String getDrugs(){
        return drugs;
    }
}