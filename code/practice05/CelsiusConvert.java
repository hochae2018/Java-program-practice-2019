package practice05;

/**
 * CelsiusConvert
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CelsiusConvert implements ActionListener{
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField tempCelsius;
    JLabel celsiusLabel, fahrenheitLabel;
    JButton convertTemp;
    // set up frame
    public CelsiusConvert() {
        converterFrame = new JFrame("Convert Celsius to Fahrenheit");
        converterPanel = new JPanel();
        converterPanel.setLayout(new GridLayout(2, 2));
        addWidgets();
        converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterFrame.pack();
        converterFrame.setVisible(true);
    }
    // set up panel
    private void addWidgets() {
        tempCelsius = new JTextField(2);
        celsiusLabel = new JLabel("Celsius", SwingConstants.LEFT);
        convertTemp = new JButton("Convert...");
        fahrenheitLabel = new JLabel("Fahrenheit", SwingConstants.LEFT);
        convertTemp.addActionListener(this);    // event lestener
        converterPanel.add(tempCelsius);
        converterPanel.add(celsiusLabel);
        converterPanel.add(convertTemp);
        converterPanel.add(fahrenheitLabel);
    }
    // event method
    public void actionPerformed(ActionEvent event) {
        int tempFahr = (int)((Double.parseDouble(tempCelsius.getText())) * 1.8 + 32);
        fahrenheitLabel.setText(tempFahr + " Fahrenheit");
    }
    
    public static void main(String[] args) {
        /*
        try {
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch(Exception e) {}
        */
        //CelsiusConvert converter 
        new CelsiusConvert();
    }
}