package account;

import Commands.CommandSerializer;
import work.Output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ExistQuestion {
    public Scanner scanner = new Scanner(System.in);
    public Output output;
    public Socket socket;
    public static String log = null;
    private byte[] outBytes;
    public boolean authorization = false;

    public void check(int port) {
        authorization = false;
        try {

            System.out.println("Есть ли у вас учетная запись?(Yes or No)");
            System.out.print("Ваш ответ:");
            String answFromClient = scanner.nextLine().trim();

            while(!answFromClient.equals("Yes") && !answFromClient.equals("No")) {
                System.out.println("Введи \"Yes\" или \"No\"");
                System.out.print("Ваш ответ:");
                answFromClient = scanner.nextLine().trim();
            }

            if (answFromClient.equals("No")) {
                Registration registration = new Registration(this);
                registration.startRegistration(port);
            }else{
                output = new Output();
                System.out.println("- Начнем авторизацию - ");
                output.setCommand("authorization");
                output.setLog(this.checklog());
                output.setPassword(this.SHA(this.checkpas()));
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
                System.out.println(answerFromServer);
                if (!answerFromServer.equals("- Авторизация прошла успешно, приступайте к вводу команд -")){
                    this.check(port);
                }
            }
        }catch (NoSuchAlgorithmException e ){
            System.out.println("ошибка 1");
            this.check(port);
        } catch ( ConnectException e){
            System.out.println("Соединение потеряно, дождитесь включения сервира...");
            this.check(port);
        } catch (IOException e) {
            System.out.println("ошибка 2");
            this.check(port);
        } catch (InterruptedException e) {
            System.out.println("ошибка 3");
            this.check(port);
        }
    }

    public byte[] SHA(String password) throws NoSuchAlgorithmException {
        byte[] data1 = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha256 = MessageDigest.getInstance("SHA-512");
        sha256.update(data1);
        byte[] digest = sha256.digest(data1);
        return digest;
    }

    public String checklog() {
        System.out.print("Введите логин: ");
        //  String log;
        while (true) {
            log = scanner.nextLine().trim();
            String logcheck = log.replaceAll("[^A-Za-z0-9]", "");
            if ((logcheck.length() != log.length()) || log.isEmpty()) {
                System.out.println("Введен косячный логин,попробуйте еще раз.");
                System.out.print("Введите логин еще раз: ");
            } else {
                break;
            }
        }
        return log;
    }

    public String checkpas() {
        System.out.print("Введите пароль: ");
        String pas;
        while (true) {
            pas = scanner.nextLine().trim();
            String pascheck = pas.replaceAll("[^A-Za-z0-9]", "");
            if ((pascheck.length() != pas.length()) || pas.isEmpty()) {
                System.out.println("Введён косячный пароль, не используйте символы '[]/.;<>,'");
                System.out.print("Введите пароль еще раз: ");
            } else {
                break;
            }
        }
        return pas;
    }

}