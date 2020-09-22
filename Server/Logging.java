package Server;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Logging {
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

    @Before("call(String Server.Servlet.HttpResponse.composeHttpResponse(..))")
    public void beforeComposeHttpResponseCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start HttpResponse.composeHttpResponse().");
    }

    @After("call(String Server.Servlet.HttpResponse.composeHttpResponse(..))")
    public void afterComposeHttpResponseCall() {
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish HttpResponse.composeHttpResponse().");
    }

}
