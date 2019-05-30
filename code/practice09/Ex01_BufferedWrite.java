package practice09;

import java.lang.Exception;
import java.io.*;

/**
 * Ex01_BufferedWrite
 */
public class Ex01_BufferedWrite {

    public static void main(String[] args) {
    File dir = new File("./example");
    dir.mkdir();
    File fn = new File(dir+"/ex01.txt");
        // Write
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fn));
            writer.write("Hello");
            writer.close();

            BufferedWriter writer1 = new BufferedWriter(new FileWriter(fn, true));
            writer1.append(' ');
            writer1.append("world !!\n");
            
            writer1.close();
            } catch (Exception e) {
            //TODO: handle exception
        }
        // Read
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fn));
            String currentLine = reader.readLine();
            reader.close();
            System.out.println(currentLine);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}