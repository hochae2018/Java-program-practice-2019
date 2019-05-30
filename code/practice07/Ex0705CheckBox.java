package practice07;

/**
 * Ex0705CheckBox
 */
import javax.swing.*;
import java.awt.*;
public class Ex0705CheckBox {

    public static void main (String[] args) { 
        Ex0705CheckBox gui = new Ex0705CheckBox();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); 

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.darkGray); // set background color
        // set button on the panel
        JButton button = new JButton("shock me"); 
        JButton buttonTwo = new JButton("bliss");
        panel.add(button); 
        panel.add(buttonTwo);

        JCheckBox cbox = new JCheckBox("set to 11");
        panel.add(cbox);

        frame.getContentPane().add(BorderLayout.EAST, panel); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    } 

}