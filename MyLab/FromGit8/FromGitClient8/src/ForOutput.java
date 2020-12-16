import Commands.CommandExecute;
import Commands.CommandSerializer;
import account.ExistQuestion;
import dragon.*;
import person.Location;
import person.Person;
import swing.GUIApplication;
import swing.Localization;
import swing.TableWorker;
import work.Output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.MissingResourceException;

public class ForOutput {
    private DragonBuilder dragonBuilder;
    private byte[] outBytes;
    private static String answ;
    private String dragonsFromServer;
    private ArrayList<Dragon> dragons = new ArrayList<>();
    private Color colorplus;
    private DragonType dragonTypeplus;
    private DragonCharacter dragonCharacterplus;

    ForOutput(DragonBuilder dragonBuilder) {
        this.dragonBuilder = dragonBuilder;
    }

    public String out(String command, Socket socket, Client client, Output output, GUIApplication guiApplication) throws IOException, InterruptedException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String[] splinter = command.split(" ",2);
            output.setCommand(splinter[0].trim());
            if( splinter[0].equals("update") || splinter[0].equals("remove_by_id")
                    || splinter[0].equals("execute_script") || splinter[0].equals("remove_at")
                    || splinter[0].equals("filter_contains_name")){
                output.setArgs(splinter[1].trim());
                output.setLog(ExistQuestion.log);
            }

            if (!splinter[0].trim().equals("")) {

                if (splinter[0].equals("add") || splinter[0].equals("add_if_max") || splinter[0].equals("update")) {

                    Dragon dragon = new DragonBuilder().plusDragon();
                    output.setDragon(dragon);

                } else if (splinter[0].equals("exit")) {

                    client.setFlag(false);

                } else if (splinter[0].trim().equals("execute_script")) {

                    CommandExecute commandExecute = new CommandExecute();
                    commandExecute.forExecute(commandExecute.check(splinter[1].trim()), output);

                }
            }
            outBytes = CommandSerializer.serializable(output);
            System.out.println(outBytes);
            dataOutputStream.write(outBytes);
            dataOutputStream.flush();
            Thread.sleep(2000);


            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[dataInputStream.available()];
            inputStream.read(bytes,0,dataInputStream.available());
            answ = new String(bytes, StandardCharsets.UTF_8);

            String[] splite = answ.trim().split("\\&");
            ArrayList<Dragon> dragons = doArrayList(splite[1]);
            if(splite.length == 2) {
                dragonsFromServer = splite[1];
                TableWorker.updateTable(dragonsFromServer);
            }else {
                if(command.equals("clear")){
                    TableWorker.removeTable();
                }
            }

            answ ="";
            String[] splitPoN = splite[0].trim().split("\n");
            for(int i=0;i<splitPoN.length;i++) {
                String[] splitLine = splitPoN[i].trim().split(" ");
                for (int j = 0; j < splitLine.length; j++) {
                    answ = answ + "\n";
                    try {
                        answ = answ + Localization.resourceBundle.getString(splitLine[j]).trim() + " ";
                    } catch (MissingResourceException e) {
                        answ = answ + splitLine[j].trim() + " ";
                    }
                }
            }

            for(String s: answ.split("\n")){
                if(s.trim().equals("Ня,пока!")){
                    client.setFlag(false);
                    return answ;
                }
            }

        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            command = "help";
            this.out(command,socket,client,output,guiApplication);
        }
        return answ;
    }

    public ArrayList<Dragon> getdragonsFromServer(){
        return dragons;
    }

    public ArrayList<Dragon> doArrayList(String dragonsFromServer){
        dragons.clear();
        this.dragonsFromServer = dragonsFromServer;
        String[] stringDragons = dragonsFromServer.split("\\|");
        for(int i=0;i<stringDragons.length;i++){
            String stringDragon = stringDragons[i];
            String[] segmentsDragon = stringDragon.split("\\+");
            switch (segmentsDragon[5]) {
                case "RED":
                    colorplus = Color.RED;
                    break;
                case "GREEN":
                    colorplus = Color.GREEN;
                    break;
                case "ORANGE":
                    colorplus = Color.ORANGE;
                    break;
                case "BROWN":
                    colorplus = Color.BROWN;
                    break;
            }
            switch (segmentsDragon[6]) {
                case "WATER":
                    dragonTypeplus = DragonType.WATER;
                    break;
                case "UNDERGROUND":
                    dragonTypeplus = DragonType.UNDERGROUND;
                    break;
                case "AIR":
                    dragonTypeplus = DragonType.AIR;
                    break;
                case "FIRE":
                    dragonTypeplus = DragonType.FIRE;
                    break;
            }
            switch (segmentsDragon[7]) {
                case "WISE":
                    dragonCharacterplus = DragonCharacter.WISE;
                    break;
                case "GOOD":
                    dragonCharacterplus = DragonCharacter.GOOD;
                    break;
                case "CHAOTIC_EVIL":
                    dragonCharacterplus = DragonCharacter.CHAOTIC_EVIL;
                    break;
                case "FICKLE":
                    dragonCharacterplus = DragonCharacter.FICKLE;
                    break;
            }
            Dragon dragon = new Dragon(segmentsDragon[1],new Coordinates(Integer.parseInt(segmentsDragon[2]),Float.parseFloat(segmentsDragon[3])),
                    Long.parseLong(segmentsDragon[4]),colorplus,dragonTypeplus,dragonCharacterplus,
                    new Person(segmentsDragon[8], LocalDate.of(Integer.parseInt(segmentsDragon[9]),Integer.parseInt(segmentsDragon[10]),Integer.parseInt(segmentsDragon[11])),Float.parseFloat(segmentsDragon[12]),segmentsDragon[13],
                            new Location(Double.parseDouble(segmentsDragon[14]),Float.parseFloat(segmentsDragon[15]),Integer.parseInt(segmentsDragon[16]),segmentsDragon[17])));
            dragon.setId(Integer.parseInt(segmentsDragon[0]));
            dragons.add(dragon);
        }
        return dragons;
    }



}