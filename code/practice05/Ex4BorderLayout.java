package practice05;

/**
 * Ex4BorderLayout
 */
import javax.swing.*;
import java.awt.*;
public class Ex4BorderLayout extends JFrame {
    JButton b1=new JButton("Red"),
        b2=new JButton("Green"),b3=new JButton("Blue"),
        b4=new JButton("Yellow"),b5=new JButton("Pink");
    public Ex4BorderLayout() {
        setTitle("BorderLayout Test");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(b1,"North"); 
        pane.add(b2,"South");	
        pane.add(b3,"East");
        pane.add(b4,"West"); 
        pane.add(b5,"Center");
        setBounds(0,0,400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        JFrame f = new Ex4BorderLayout();
            f.setVisible(true);
    }
}
