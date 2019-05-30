package practice09;

import java.io.*;
import java.util.Scanner;

/**
 * Ex00_FileWriter
 */
public class Ex00_FileWriter {

    public static void main (String[] args) {
        String fn = "./ex00.txt";
        // Write
        try {
            FileWriter writer = new FileWriter(fn);
            FileWriter append = new FileWriter(fn, true);
            writer.write("hello foo!\n");
            writer.close();
            append.write("hello bar!\n");
            append.close();
        } catch(IOException e) { 
            e.printStackTrace();
        } 
        // Read
        try {
            Scanner sc = new Scanner(new File(fn));
            while (sc.hasNext() == true) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}