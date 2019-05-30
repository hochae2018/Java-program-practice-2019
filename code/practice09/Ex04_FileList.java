package practice09;

import java.io.*;
/**
 * Ex04_FileList
 */
public class Ex04_FileList {

    public static void main(String[] args) {
        File dir = new File("./example");
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]); 
            }
        }

        System.out.println(dir.getAbsolutePath());
        
        //boolean isDeleted = dir.delete();
        System.out.println((dir.delete() == true) ? "OK" : "NG");

    }
}