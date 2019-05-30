package practice07;

/**
 * Ex0703TextField
 */
import javax.swing.*;
import java.awt.*;
public class Ex0703TextField {

    public static void main(String[] args) {
        new Ex0703TextField();
    }

    public Ex0703TextField() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); 

        panel.setBackground(Color.darkGray); // set background color
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Text field components
        JTextField field = new JTextField(20);
        JTextField tfield = new JTextField(20);
        JTextField tfield1 = new JTextField("Your name");
        panel.add(tfield); 
        panel.add(tfield1);

        JPanel bpanel = new JPanel(); 
        bpanel.setBackground(Color.GRAY); // set background color
        JButton button = new JButton("Set"); 
        JButton button2 = new JButton("Clear");
        bpanel.add(button); 
        bpanel.add(button2);

        frame.getContentPane().add(BorderLayout.NORTH, panel); 
        frame.getContentPane().add(BorderLayout.SOUTH, bpanel); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}