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
    private int port;
    private String login;
    private String password;
    private boolean flagONormal;

    public Registration(ExistQuestion existQuestion,int port,String login,String password){
        this.existQuestion = existQuestion;
        this.port = port;
        this.login=login;
        this.password = password;
        flagONormal = false;
    }

    public void doItIfNo() throws IOException, NoSuchAlgorithmException, InterruptedException {

        output = new Output();
        output.setCommand("registration");
        socket = new Socket("localhost", port);

        if (existQuestion.checkpas(password)) {
            flagONormal = true;
            output.setPassword(existQuestion.SHA(password));
        }

        if (existQuestion.checklog(login)) {
            flagONormal = true;
            output.setLog(login);
        }

        if (existQuestion.checklog(login) && existQuestion.checkpas(password)) {

            if (flagONormal) {
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

                String[] answerFromServerfull = answerFromServer.split("&");
                answerFromServer = answerFromServerfull[0];

                if (answerFromServer.equals("- Этот логин существует -")) {
                    existQuestion.setText(answerFromServer);
                }
            }
        }
    }
}