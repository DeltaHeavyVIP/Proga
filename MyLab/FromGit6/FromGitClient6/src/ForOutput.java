import dragon.Dragon;
import dragon.DragonBuilder;
import work.Output;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ForOutput {
    private DragonBuilder dragonBuilder;
    private String log = null;
    private byte[] pass = null;
    private byte[] outBytes;

    ForOutput(DragonBuilder dragonBuilder) {
        this.dragonBuilder = dragonBuilder;
    }

    public String out(String command, Socket socket, Client client, Output output) throws IOException, InterruptedException {

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        String[] splinter = command.split(" ",2);
        output.setCommand(splinter[0].trim());
        if( splinter[0].equals("update") || splinter[0].equals("remove_by_id")
                || splinter[0].equals("execute_script") || splinter[0].equals("remove_at")
                || splinter[0].equals("filter_contains_name") || splinter[0].equals("print_field_descending_type") ){
            output.setArgs(splinter[1].trim());
        }

        if (!splinter[0].trim().equals("")) {

            if (splinter[0].equals("add") || splinter[0].equals("add_if_max") || splinter[0].equals("update")) {

                Dragon dragon = new DragonBuilder().plusDragon();
                output.setDragon(dragon);

            } else if (splinter[0].equals("exit")) {

                client.stopesta();

            } else if (splinter[0].trim().equals("execute_script")) {

                CommandExecute commandExecute = new CommandExecute();
                commandExecute.forExecute(commandExecute.check(splinter[1].trim()), output);

            }
        }
        outBytes = CommandSerializer.serializable(output);
        dataOutputStream.write(outBytes);
        dataOutputStream.flush();
        Thread.sleep(2000);


        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[dataInputStream.available()];
        inputStream.read(bytes,0,dataInputStream.available());
        String answ = new String(bytes, StandardCharsets.UTF_8);

        for(String s: answ.split("\n")){
            if(s.trim().equals("Ня,пока!")){
                client.stopesta();
                return answ;
            }
        }
            return answ;
    }
}