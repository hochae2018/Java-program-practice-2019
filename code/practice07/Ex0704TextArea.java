package practice07;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
public class Ex0704TextArea implements ActionListener { JTextArea text;
    public static void main (String[] args) { 
        Ex0704TextArea gui = new Ex0704TextArea(); 
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just Click It"); 
        button.addActionListener(this);

        // Line: 10, Column: 30
        text = new JTextArea(10,30);

        text.setLineWrap(true);
        //text.setBackground(Color.DARK_GRAY);

        JScrollPane scroller = new JScrollPane(text); 
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scroller);
        frame.getContentPane().add(BorderLayout.CENTER, panel); 
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true); 
    }

    public void actionPerformed(ActionEvent ev) { 
        text.append("button clicked \n ");
    } 
}