package Server;

import work.Output;
import work.commands.CommandDeserializer;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Set;


public class ConnectionWorker {
    private static Output output;
    private CommandDeserializer deserializer;
    private static ByteBuffer buffer;
    private static SocketChannel channel;
    private static Selector selector;

    public ConnectionWorker(CommandDeserializer deserializer) {
        this.deserializer = deserializer;
    }

    public void inputStarter(Selector selector) throws IOException {
        this.selector = selector;
        buffer = ByteBuffer.allocate(8192);
        channel = null;
        while (channel == null) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            for (SelectionKey key : selectedKeys) {
                if (key.isReadable()) {
                    channel = (SocketChannel) key.channel();
                    try {
                        channel.read(buffer);
                    }catch (IOException e){
                    }
                    buffer.flip();
                    channel.register(selector, SelectionKey.OP_WRITE);

                    break;
                }
            }
        }

        byte[] bytes = buffer.array();
        System.out.println(bytes);
        output = deserializer.deserializer(bytes);
        buffer.clear();

    }

    public static void outputStarter(String answ) throws IOException {
        try {
            buffer.clear();
            if (answ.isEmpty()) {
                System.out.println("Пустой ответ");
            }
            byte[] answBytes = answ.getBytes(StandardCharsets.UTF_8);
            buffer = ByteBuffer.wrap(answBytes);

            channel = null;
            while (channel == null) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                for (SelectionKey key : selectedKeys) {
                    if (key.isWritable()) {
                        channel = (SocketChannel) key.channel();
                        while (buffer.hasRemaining()) {
                            channel.write(buffer);
                        }
                        break;
                    }
                }
            }

            Thread.sleep(1000);
        }catch(IOException e){
            System.out.println("Проблемы с записью");
        }catch (InterruptedException e){
            System.out.println("Thread не спит");
        }finally {
            channel.socket().close();
            channel.close();
            selector.close();
        }
    }
    public static Output getOutput(){return output;}
}