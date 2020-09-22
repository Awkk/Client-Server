package Server;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;

@Aspect
public class Logging {

    @After("call(java.net.ServerSocket.new(..))")
    public void afterServerSocket() {
        System.out.println("Server listening on port " + DirServer.PORT);
    }

    @Before("execution(* Server..*(..))&& !within(DirServer)")
    public void beforeMethodExecute(JoinPoint joinPoint){
        System.out.println("Thread " + Thread.currentThread().getId() + ": Start " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* Server..*(..))&& !within(DirServer)")
    public void afterMethodExecute(JoinPoint joinPoint){
        System.out.println("Thread " + Thread.currentThread().getId() + ": Finish " + joinPoint.getSignature().toShortString());
    }
}
