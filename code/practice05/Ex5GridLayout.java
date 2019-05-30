package practice05;

/**
 * Ex5GridLayout
 */
import javax.swing.*;
import java.awt.*;
public class Ex5GridLayout extends JFrame{
    JButton b1=new JButton("Button 1"),
        b2=new JButton("Button 2"),b3=new JButton("Button 3"),
        b4=new JButton("Button 4"),b5=new JButton("Button 5");
    public Ex5GridLayout() {
        setTitle("GridLayout Test");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,3));
        pane.add(b1); pane.add(b2); pane.add(b3);
        pane.add(b4); pane.add(b5);
        setBounds(0,0,300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        JFrame f = new Ex5GridLayout();
        f.setVisible(true);
    }
}
