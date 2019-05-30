package practice06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
/**
 * KeyPad
 */
public class KeyPad extends JPanel implements ActionListener {
 
   // Document display by the text field
    
   private Document display = null;
    
   /**
    * Creates a key pad panel containing a button for each digit (0 - 9)
    * And a text field for displaying what's pressed
    */
    
   public KeyPad() {
      super(new BorderLayout());
       
      // Create a panel for the buttons
      // We'll use a GridLayout to display the buttons in a grid
       
      JPanel buttons = new JPanel(new GridLayout(3, 4));
      for (int i=0; i<10; i++) {
         JButton button = new JButton(Integer.toString(i));
          
         // By adding an ActionListener to our button we
         // can get notified when the button has been pressed 
          
         button.addActionListener(this);
         buttons.add(button);
      }
       
      // Create a text field to display the numbers entered
       
      JTextField displayField = new JTextField();
      display = displayField.getDocument();
      add(BorderLayout.CENTER, buttons);
      add(BorderLayout.SOUTH, displayField);
   }
    
   /**
    * Create and setup the main window
    */
    
   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Keypad");
       
      // We want the application to exit when the window is closed
       
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
      // Add the key pad to window
       
      frame.getContentPane().add(new KeyPad());
       
      // Display the window.
       
      frame.pack();
      frame.setVisible(true);
   }
    
   /**
    * Called when a button is pressed
    */
    
   @Override
   public void actionPerformed(ActionEvent event) {
       
      // Determine which key was pressed
       
      String key = event.getActionCommand();
       
      // Insert the pressed key into our text fields Document
       
      try {
         display.insertString(display.getLength(), key, null);
      } catch (BadLocationException e) {
         e.printStackTrace();
      }
   }
    
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}