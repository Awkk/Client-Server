package Server;

import java.net.*;
import java.io.*;
import Server.Servlet.*;

public class DirServerThread extends Thread {
    private Socket socket = null;

    public DirServerThread(Socket socket) {
        super("DirServerThread");
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            String dirServlet = "Server.Servlet.DirServlet.DirServlet";
            try {
                Servlet servlet = (Servlet) Class.forName(dirServlet).getDeclaredConstructor().newInstance();
                HttpRequest request = new HttpRequest(in);
                HttpResponse response = new HttpResponse(out);
                String method = request.getHeaderField("method");

                if (method.equals("GET"))
                    servlet.doGet(request, response);
                else if (method.equals("POST"))
                    servlet.doPost(request, response);

            } catch (ClassNotFoundException e) {
                throw new ServletException("Cannot load " + dirServlet);
            }

            socket.close();
        } catch (Exception e) {
            System.out.println(
                    "Exception in thread: " + Thread.currentThread().getId() + "\nMessage: " + e.getMessage() + "\n");
        }
    }
}
