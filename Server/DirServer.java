package Server;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class DirServer {

    public static final int MAX_THREAD = 5;
    public static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD);

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.err.println("Error Creating Socket\n");
            System.exit(-1);
        }
        while (listening) {
            Socket clientSocket = serverSocket.accept();
            threadPool.execute(new DirServerThread(clientSocket));
        }

        threadPool.shutdown();
        serverSocket.close();
    }
}
