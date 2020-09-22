package Server.Servlet;

public class ServletException extends Exception {
    private String message;

    public ServletException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
