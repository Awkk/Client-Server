package Server.Servlet;

import java.io.IOException;

public interface Servlet {
    void doGet(HttpRequest request, HttpResponse response) throws IOException;

    void doPost(HttpRequest request, HttpResponse response) throws IOException;
}
