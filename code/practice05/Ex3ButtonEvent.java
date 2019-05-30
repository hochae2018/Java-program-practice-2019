package practice05;

import javax.swing.*;
import java.awt.event.*;

public class Ex3ButtonEvent extends JFrame implements ActionListener{
    private static String labelPrefix = "Number of button clicks: ";
    private int numClicks = 0;
    JLabel label = new JLabel(labelPrefix + "0    ");
    public Ex3ButtonEvent (String title) {
        super(title);
        JButton button = new JButton("Swing button!");
        // add action listener to the button
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
    // implement actionPerformed()
    public void actionPerformed(ActionEvent event) { 
        label.setText(labelPrefix + ++numClicks);
    }

    public static void main(String[] args) {
      new Ex3ButtonEvent("SwingApplication");  
    }
}
  