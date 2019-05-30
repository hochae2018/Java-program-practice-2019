package practice07;

import javax.swing.*; 
import java.awt.*;
public class Ex0701FlowLayout {

    public static void main (String[] args) { 
        Ex0701FlowLayout gui = new Ex0701FlowLayout();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); 

        panel.setBackground(Color.darkGray); // set background color
        // set button on the panel
        JButton button = new JButton("Button one"); 
        JButton buttonTwo = new JButton("Button 2");
        panel.add(button); 
        panel.add(buttonTwo);

        frame.getContentPane().add(BorderLayout.EAST, panel); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
    } 
}