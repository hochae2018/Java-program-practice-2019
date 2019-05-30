package practice05;

/**
 * Ex6TwoButtons
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex6TwoButtons {
    private static String labelPrefix = "Clicks: ";
    int clickCounter = 0;
    JFrame frame;
    JLabel label;
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelButtonListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorButtonListener());

        label = new JLabel(labelPrefix+clickCounter);       
        MyDrawPanel drawPanel = new MyDrawPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(420,300);
        frame.setVisible(true);
    }
    // inner class for button 1 
    class LabelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            clickCounter ++;
            label.setText(labelPrefix + clickCounter);
        }
    } // close inner class
    // inner class for button 2
    class ColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }  // close inner class
    // inner class for draw
    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g) {
            g.fillRect(0,0,this.getWidth(), this.getHeight());
    
            // make random colors to fill with
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
    
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(70,70,100,100);
        }
    }

    public static void main (String[] args) {
        Ex6TwoButtons gui = new Ex6TwoButtons();
        gui.go();
    }

}