package com.slurpslurp;

import java.io.File;

public class FileSystem {
    static void  moveToFolder(String string){

        File folder = new File(string);
        if (!folder.exists())
            folder.mkdir();

        String home = System.getProperty("user.home");
        File file = new File(home+"/Downloads" );

        File[] content = file.listFiles();

        for(int i = 0; i < content.length; i++) {
            File newF = new File(string + content[i].getName());
            content[i].renameTo(newF);
        }
    }

}
