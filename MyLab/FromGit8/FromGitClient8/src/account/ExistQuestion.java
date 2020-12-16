package account;

import swing.InformationFromConsol;
import java.io.IOException;
import java.net.ConnectException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ExistQuestion {
    public Scanner scanner = new Scanner(System.in);
    public static String log = null;
    private boolean authorization=true;
    private int port;
    private static String text;

    public ExistQuestion(int port) {
        this.port = port;
    }

    public void check() {

        text = "";
        authorization = true;

        try {
            String login = InformationFromConsol.getLog();
            String password = InformationFromConsol.getPassword();
            if (InformationFromConsol.getButtonAccount()) {
                Authorization authorization = new Authorization(this, port,login,password);
                authorization.doItIfYes();
            }else{
                Registration registration = new Registration(this, port,login,password);
                registration.doItIfNo();
            }

        } catch (NoSuchAlgorithmException e) {
            text = "ошибка 1";
            this.check();
        } catch (ConnectException e) {
            text = "Соединение потеряно, дождитесь включения сервира...";
            this.check();
        } catch (IOException e) {
            text = "ошибка 2";
            this.check();
        } catch (InterruptedException e) {
            text = "ошибка 3";
            this.check();
        }

    }

    public byte[] SHA(String password) throws NoSuchAlgorithmException {
        byte[] data1 = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha256 = MessageDigest.getInstance("SHA-512");
        sha256.update(data1);
        byte[] digest = sha256.digest(data1);
        return digest;
    }

    public boolean checklog(String login) {
        boolean isNormalLog = true;
        log = login;
        String logcheck = log.replaceAll("[^A-Za-z0-9]", "");
        if ((logcheck.length() != log.length()) || log.isEmpty()) {
            isNormalLog = false;
            text = "Введен косячный логин";
        }
        return isNormalLog;
    }

    public boolean checkpas(String password) {
        text ="";
        boolean isNormalPass = true;
        String pas = password;
        String pascheck = pas.replaceAll("[^A-Za-z0-9]", "");
        if ((pascheck.length() != pas.length()) || pas.isEmpty()) {
            isNormalPass = false;
            text = "Введён косячный пароль";
        }
        return isNormalPass;
    }

    public boolean getAuthorization(){return authorization;}
    public void setAuthorization(boolean authorization){ this.authorization = authorization; }
    public static String getLog(){return log;}
    public static String getText(){return text;}
    public void setText(String text){this.text =text;}

}