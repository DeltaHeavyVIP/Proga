package work;

import dragon.Dragon;

import java.io.Serializable;
import java.util.Scanner;

public class Output implements Serializable {

    private String log = null;

    private byte[] password = null;

    private String command = null;

    private Scanner scanner = null;

    private String args = null;

    private Dragon dragon = null;

    private String execute_commands = null;

    private Dragon[] dragon_execute = null;

    public void setCommand(String command){
        this.command = command;
    }

    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }

    public void setArgs(String args){ this.args = args; }

    public void setDragon(Dragon dragon){ this.dragon = dragon; }

    public void setDragon_execute(Dragon[] dragon){
        this.dragon_execute = dragon;
    }

    public void setExecute_commands(String execute_commands){ this.execute_commands=execute_commands; }

    public void setLog(String log){this.log=log;}

    public void setPassword(byte[] password){this.password=password;}

    public String getCommand(){
        return command;
    }

    public Scanner getScanner(){
        return scanner;
    }

    public String getArgs(){
        return args;
    }

    public Dragon getDragon(){
        return dragon;
    }

    public Dragon[] getDragon_execute(){
        return dragon_execute;
    }

    public String getExecute_commands(){
        return execute_commands;
    }

    public String getLog(){return log;}

    public byte[] getPassword(){return password;}
}