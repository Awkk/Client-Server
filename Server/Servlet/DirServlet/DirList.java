package Server.Servlet.DirServlet;

import java.io.File;

public class DirList {
    public static String getHtmlListing(String path) {
        StringBuilder dirList = new StringBuilder();
        File dir = new File(path);
        String[] chld = dir.list();
        for (String s : chld) {
            if ((new File(path + s)).isDirectory())
                dirList.append("<li><button type=\"button\">" + s + "</button></li>");
            else
                dirList.append("<li>" + s + "</li>");
        }

        return dirList.toString();
    }

    public static String getJsonListing(String path) {
        StringBuilder dirList = new StringBuilder("[");
        File dir = new File(path);
        String[] chld = dir.list();
        for (String s : chld) {
            dirList.append("\"" + s + "\", ");
        }
        dirList.setLength(dirList.length() - 2);
        dirList.append("]");

        return dirList.toString();
    }
}
