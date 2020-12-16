import work.Output;

import java.io.*;
import java.net.Socket;

public class Client {
    private ForOutput forOutput;
    private Socket socket;
    private boolean flag = true;

    Client(ForOutput forOutput) {
        this.forOutput = forOutput;
    }

    public void start() {
        while (flag) {
            Output output = new Output();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String command = bufferedReader.readLine();
                if (command == null) {
                    break;
                }
                socket = new Socket("localhost",5559);
                String answ = forOutput.out(command,socket,this,output);
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
    }

    public void stopesta(){
        flag = false;
    }
}
