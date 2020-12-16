import dragon.DragonBuilder;

public class Main {

    public static void main(String [] args){

        ForOutput forOutput = new ForOutput(new DragonBuilder());
        Client client = new Client(forOutput);
        client.start();

    }
}
//execute_script C:\Users\Vova\IdeaProjects\FromGitClient\commands.txt