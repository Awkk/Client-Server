package Server.Servlet;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private PrintWriter out;
    private String[] statusLine;
    private Map<String, String> header;

    public HttpResponse(PrintWriter out) {
        this.out = out;
        header = new HashMap<>();
        statusLine = new String[3];
        statusLine[0] = "HTTP/1.0";
        statusLine[1] = "200";
        statusLine[2] = "OK";
    }

    public void setHTTPVersion(String version) {
        statusLine[0] = version;
    }

    public void setStatusCode(int code) {
        statusLine[1] = String.valueOf(code);
    }

    public void setReasonPhrase(String reason) {
        statusLine[2] = reason;
    }

    public void setHeaderField(String name, String value) {
        header.put(name, value);
    }

    public void setContentType(String type) {
        header.put("Content-Type", type);
    }

    public PrintWriter getBodyWriter() {
        return out;
    }

    public String getComposedHttpResponse() {
        StringBuilder response = new StringBuilder();
        // Compose status line e.g.(HTTP/1.0 200 OK)
        response.append(statusLine[0] + " " + statusLine[1] + " " + statusLine[2] + "\r\n");
        // Compose response header fields
        header.forEach((name, value) -> {
            response.append(name + ": " + value + "\r\n");
        });
        response.append("\r\n");

        return response.toString();
    }
}