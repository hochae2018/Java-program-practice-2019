package practice09;

import java.io.*;
/**
 * Ex03_FileOutputStream
 */
public class Ex03_FileOutputStream {

    public static void main(String[] args) {
        String str = "FileOUtputStream test!!\n";
        try {
            FileOutputStream outputStream = new FileOutputStream("./ex03.txt");
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}