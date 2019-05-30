package practice09;

import java.io.*;
/**
 * Ex02_PrintWrite
 */
public class Ex02_PrintWrite {
    public static void main(String[] args) {
String fn = "./ex02.txt";
try {
    FileWriter fileWriter = new FileWriter(fn);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    printWriter.print("Some String\n");
    printWriter.printf("Product name is %s and its price is $%d\n", "iPhone", 1000);
    printWriter.close();                    
} catch (IOException e) {
    //TODO: handle exception
}
    }
}