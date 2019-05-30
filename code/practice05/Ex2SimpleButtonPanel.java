package practice05;

/**
 * Ex2SimpleButton
 */
import javax.swing.*;
public class Ex2SimpleButtonPanel {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        JPanel panel = new JPanel();
        //frame.getContentPane().add(button);
        // Add button into panel
        panel.add(button);
        // Add the panel to pane of frame
        frame.getContentPane().add(panel);
        // Set frame
        frame.setSize(300,300);     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Turn on display
        frame.setVisible(true); 
    }
}