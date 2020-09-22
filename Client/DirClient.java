package Client;

import java.io.*;
import java.net.*;

public class DirClient {
    public static final String HOST = "localhost";
    public static final int PORT = 8888;
    private String dirName;

    public DirClient(String dirName) {
        this.dirName = dirName;
    }

    public String getListing() {
        StringBuilder listing = new StringBuilder();
        try (Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            // Send GET request
            out.print("GET " + "/?path=" + dirName + " HTTP/1.0\r\n");
            out.println("User-Agent: DirClient\r\n\r\n");

            // Get the response
            String line = in.readLine();
            String[] listingArray = line.replace("[", "").replace("]", "").replace("\"", "").split(", ");
            for (String file : listingArray)
                listing.append(file + "\n");

        } catch (Exception e) {
            System.err.println("Error\n");
        }
        return listing.toString();
    }
}
