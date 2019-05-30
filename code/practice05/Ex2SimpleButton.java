package practice05;

/**
 * Ex2SimpleButton
 */
import javax.swing.*;
public class Ex2SimpleButton {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.pack();
        //frame.setSize(300,300);     
        frame.setVisible(true); 
    }
}