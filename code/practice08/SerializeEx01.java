package practice08;

/**
 * SerializeEx01
 */
import java.io.*;

public class SerializeEx01 implements Serializable {
    // Class doesn't implement Serializable 
    transient private DuckNoSerialize duck = new DuckNoSerialize();
    private DuckSerialize duck1 = new DuckSerialize();
    public static void main (String[] args) { 
        SerializeEx01 myPond = new SerializeEx01();
        try {
        FileOutputStream fs = new FileOutputStream("SerializeEx01.ser"); 
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(myPond); 
        os.close();
        } catch(Exception ex) { 
            ex.printStackTrace();
        } 
    }
}

class DuckNoSerialize {

    public DuckNoSerialize() {
        System.out.println("this is not Serialized class");
    }
}
class DuckSerialize implements Serializable {
    
    public  DuckSerialize() {
         System.out.println("this is Serialized class");
     }
 } 