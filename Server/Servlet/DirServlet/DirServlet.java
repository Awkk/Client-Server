package Server.Servlet.DirServlet;

import java.io.*;
import Server.Servlet.*;

public class DirServlet implements Servlet {

    @Override
    public void doGet(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getParameter("path");

        if (request.getHeaderField("User-Agent").equals("DirClient")) {
            // Reponse for Native Client App
            response.setContentType("application/json");
            PrintWriter out = response.getBodyWriter();
            out.println(path == null ? "" : DirList.getJsonListing(path));
        } else {
            // Response for Broswer
            response.setContentType("text/html");
            PrintWriter out = response.getBodyWriter();
            out.println(response.getComposedHttpResponse());
            String htmlTop = "<!DOCTYPE html><html><body><ul>";
            String htmlBottom = "</ul></body></html>";
            out.println(htmlTop + (path == null ? "" : DirList.getHtmlListing(path)) + htmlBottom);
        }
    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {

    }
}
