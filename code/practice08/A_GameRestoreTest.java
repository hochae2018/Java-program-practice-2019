package practice08;

import java.io.*;
public class A_GameRestoreTest {
    public static void main(String[] args) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One’s type: " + oneRestore.getType()); 
            System.out.println("Two’s type: " + twoRestore.getType()); 
            System.out.println("Three’s type: " + threeRestore.getType());
        } catch(Exception ex) { 
            ex.printStackTrace();
        } 
    }
}
