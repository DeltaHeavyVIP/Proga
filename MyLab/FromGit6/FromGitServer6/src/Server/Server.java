package Server;

import work.Output;
import work.commands.CommandDeserializer;
import java.io.IOException;
import java.nio.channels.Selector;

public class Server {

    private final ConnectionBuilder connectionBuilder;
    private final ConnectionWorker connectionWorker;
    private Output output;

    public Server(int port, CommandDeserializer deserializer) throws IOException {
        connectionBuilder = new ConnectionBuilder(port);
        connectionWorker = new ConnectionWorker(deserializer);
    }

    public Output start() throws IOException {

            Selector selector = connectionBuilder.accept();  //Connection with client accepted
            output = connectionWorker.inputStarter(selector);

        return output;
    }
}