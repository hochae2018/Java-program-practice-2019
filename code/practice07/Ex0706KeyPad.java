package practice07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ex0706KeyPad
 */
public class Ex0706KeyPad implements ActionListener {

    public static void main(String[] args) {
		new Ex0706KeyPad();
    }

    JFrame frame = new JFrame("Calculator");
	JPanel panel = new JPanel();
    JTextField jfield = new JTextField(1);
	// constructor of mycalcul
	public Ex0706KeyPad(){
        
        //Container c = frame.getContentPane();
        panel.setLayout(new GridLayout(3,3));

        JButton b1, b2, b3, b4, b5, b6, b7, b8, b9; 
        // create number buttons 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9");
        //add actionlistener
        b9.addActionListener(this); 
        b8.addActionListener(this); 
        b7.addActionListener(this); 
        b6.addActionListener(this); 
        b5.addActionListener(this); 
        b4.addActionListener(this); 
        b3.addActionListener(this); 
        b2.addActionListener(this); 
        b1.addActionListener(this);

        panel.add(b1); 
        panel.add(b2); 
        panel.add(b3);  
        panel.add(b4); 
        panel.add(b5); 
        panel.add(b6);  
        panel.add(b7); 
        panel.add(b8); 
        panel.add(b9);
        //panel.add(jfield);
        frame. getContentPane().add(jfield, "North");
		// set size of frame
		frame.setSize(500, 500);
		//exit when click x button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add label
		frame.getContentPane().add(panel);
		//Center alignment of Label in the Frame
		//frame.setLayout(new FlowLayout());
		
		frame.setVisible(true);
		

	}

    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        
        jfield.setText(s);}
}