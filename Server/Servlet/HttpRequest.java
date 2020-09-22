package Server.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private Map<String, String> headerFields;
    private Map<String, String> parameters;

    public HttpRequest(BufferedReader in) throws IOException {
        this.headerFields = new HashMap<>();
        this.parameters = new HashMap<>();
        parseRequest(in);
    }

    public void parseRequest(BufferedReader in) throws IOException {
        String line = in.readLine();

        // Parse the Request Line
        String[] requestLine = line.split(" ");
        headerFields.put("method", requestLine[0]);
        headerFields.put("protocol", requestLine[2]);

        // Parse the URI
        String[] uri = requestLine[1].split("\\?");
        headerFields.put("uri", uri[0]);

        // Parse the parameters
        if (uri.length > 1) {
            String[] allParas = uri[1].split("&");
            for (String para : allParas) {
                String[] s = para.split("=");
                if (s.length > 1)
                    parameters.put(s[0], s[1]);
            }
        }
        // Parse the Request Header Fields
        while ((line = in.readLine()) != null && !line.equals("")) {
            String[] headerField = line.split(": ", 2);
            headerFields.put(headerField[0], headerField[1]);
        }
    }

    public String getHeaderField(String field) {
        return headerFields.get(field);
    }

    public String getParameter(String parameter) {
        return parameters.get(parameter);
    }
}
