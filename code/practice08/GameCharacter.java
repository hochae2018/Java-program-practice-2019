package practice08;

/**
 * GameCharacter
 */
import java.io.*;

public class GameCharacter implements Serializable {

    static final long serialVersionUID = -6849794470754667710L;
    
    int power;
    int test;
    String type; 
    String[] weapons;
    public GameCharacter(int p, String t, String[] w) { 
        power = p;
        type = t;
        weapons = w; 
    }
    public GameCharacter(){

    }
    public int getPower() { 
        return power;
    }
    public String getType() { 
        return type;
    }
    public String getWeapons() { 
        String weaponList = "";
        for (int i = 0; i < weapons.length; i++) { 
            weaponList += weapons[i] + " ";
        }
    return weaponList; 
    }
}