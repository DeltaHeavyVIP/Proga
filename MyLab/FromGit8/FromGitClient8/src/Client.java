
import account.ExistQuestion;
import swing.Anime;
import swing.CommandsFromConsol;
import swing.GUIApplication;
import swing.InformationFromConsol;
import work.Output;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private ForOutput forOutput;
    private Socket socket;
    private boolean flag = true;
    private ExistQuestion existQuestion;
    private int port = 5575;
    private String answ ="";

    Client(ForOutput forOutput) {
        this.forOutput = forOutput;
        existQuestion = new ExistQuestion(port);
    }

    public void start() {

        while(existQuestion.getAuthorization()) {
            InformationFromConsol.write();
            existQuestion.check();
        }

        GUIApplication guiApplication = new GUIApplication();
        guiApplication.createGUI();


        while (flag) {
            Anime.setDragons(forOutput.getdragonsFromServer());
            Output output = new Output();
            try {
                String command =new CommandsFromConsol().getCommand();
                if (command == null) {
                    break;
                }
                socket = new Socket("localhost",port);
                answ = forOutput.out(command,socket,this,output,guiApplication);
                JFrame jFrame = InformationFromConsol.getFrame("Ответ сервера");
                JPanel panel = new JPanel();
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                int y = 3;
                String[] text = answ.split("\n");
                for (int i = 0; i < text.length; i++){
                    y = y + 25;
                    JLabel label = new JLabel(text[i]);
                    label.setBounds(3,y,700,20);
                    panel.add(label);
                }
                jFrame.add(panel);


                if(answ.equals("")){
                    socket.close();
                    continue;
                }
                System.out.println(answ);
                socket.close();
            } catch (IOException e) {
                System.out.println("Прошел разрыв соединения");
            } catch (NullPointerException e){
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Ну тут вообще анриал ошибку словить, но я в себя верю");
                }
                flag = false;
                break;
            } catch (InterruptedException e) {
                System.out.println("Поток не хочет спать, потому что не покушал на ночь");
            }
        }
        guiApplication.getApp().dispose();
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

}