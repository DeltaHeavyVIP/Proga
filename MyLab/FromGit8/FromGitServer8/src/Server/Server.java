
package Server;

import work.Output;
import work.commands.CommandDeserializer;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ConnectionBuilder connectionBuilder;
    private final ConnectionWorker connectionWorker;
    private Output output;

    public Server(int port, CommandDeserializer deserializer) throws IOException {
        connectionBuilder = new ConnectionBuilder(port);
        connectionWorker = new ConnectionWorker(deserializer);
    }

    static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public void start() throws IOException {

        Selector selector = connectionBuilder.accept();//Connection with client accepted
        connectionWorker.inputStarter(selector);

    }
}