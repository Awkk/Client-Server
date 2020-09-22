package Server;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class Logging {

    @After("call(java.net.ServerSocket.new(..))")
    public void afterServerSocket() {
        System.out.println("Server listening on port " + DirServer.PORT);
    }

    @Before("execution(* Server.DirServerThread.run(..))")
    public void beforeDirServerThreadRun() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start DirServerThread.run().");
    }

    @After("execution(* Server.DirServerThread.run(..))")
    public void afterDirServerThreadRun() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish DirServerThread.run().");
    }

    @Before("call(void Server.Servlet.Servlet.doGet(..))")
    public void beforeDoGetCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start DirServlet.doGet().");
    }

    @After("call(void Server.Servlet.Servlet.doGet(..))")
    public void afterDoGetCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish DirServlet.doGet().");
    }

    @Before("call(void Server.Servlet.HttpRequest.parseRequest(..))")
    public void beforeParseRequestCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start HttpRequest.parseRequest().");
    }

    @After("call(void Server.Servlet.HttpRequest.parseRequest(..))")
    public void afterParseRequestCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish HttpRequest.parseRequest().");
    }

    @Before("call(String Server.Servlet.HttpResponse.getComposedHttpResponse())")
    public void beforeComposeHttpResponseCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start HttpResponse.getComposedHttpResponse().");
    }

    @After("call(String Server.Servlet.HttpResponse.getComposedHttpResponse())")
    public void afterComposeHttpResponseCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish HttpResponse.getComposedHttpResponse().");
    }

    @Before("call(* Server.Servlet.HttpResponse.getBodyWriter())")
    public void beforeGetBodyWriterCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start HttpResponse.getBodyWriter().");
    }

    @After("call(* Server.Servlet.HttpResponse.getBodyWriter())")
    public void afterGetBodyWriterCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish HttpResponse.getBodyWriter().");
    }
}
