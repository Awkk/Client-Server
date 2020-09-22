### Start server
```java -javaagent:aspectj/lib/aspectjweaver.jar Server/DirServer```

### Start client
```java Client/Activity```

### Compile all files
```javac -g -cp "aspectj/*":. Server/Logging.java Server/DirServer.java Server/Servlet/DirServlet/*.java Client/*.java```