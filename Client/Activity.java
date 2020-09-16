package Client;

import java.io.*;

public class Activity {
    private String dirName = null;

    public Activity(String dirName) {
        this.dirName = dirName;
    }

    public void onCreate() {
        System.out.println(new DirClient(this.dirName).getListing());
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Activity <dirName>");
            System.exit(1);
        }
        new Activity(args[0]).onCreate();
    }
}