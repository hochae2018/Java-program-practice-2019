package practice06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class KeypadText extends JFrame{
    private JButton[] btnNumbers;  // Array of 10 numeric Buttons
    private JButton btnAC, btnClear;
    private JButton btnAdd, btnSub, btnMult, btnDiv, btnEqu;
    private JTextField tfDisplay = new JTextField("", 20);

    private int result = 0;
    private int preVal = 0;
    private String keyOp = "";

    // The entry main() method
    public static void main(String[] args) {
        KeypadText kpad = new KeypadText();  // Let the constructor do the job
        kpad.go();
    }
    
    JPanel panelKey = new JPanel(new GridLayout(4,4));
    // Constructor to setup GUI components and event handlers
    public void go () {
        // Set up display panel
        JPanel panelDisplay = new JPanel(new GridLayout());
        panelDisplay.add(tfDisplay);
    
        // Set up button panel
        btnAdd = new BtnCalc("+");
        btnSub = new BtnCalc("-");
        btnMult = new BtnCalc("X");
        btnDiv = new BtnCalc("/");        
        
        btnNumbers = new JButton[10];  // Construct an array of 10 numeric Buttons
        for (int i=1; i<btnNumbers.length; i++){
            btnNumbers[i] = new Mybutton(Integer.toString(i));
        }
        btnNumbers[0] = new Mybutton(Integer.toString(0));
        btnClear = new BtnClear("C");
        btnEqu = new BtnCalc("=");

        setLayout(new BorderLayout());  // "super" Frame sets to BorderLayout
        add(panelDisplay, BorderLayout.NORTH);
        add(panelKey, BorderLayout.CENTER);
        //add(panelOpKey, BorderLayout.SOUTH);
    
        setTitle("BorderLayout Demo"); // "super" Frame sets title
        setSize(200, 300);             // "super" Frame sets initial size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);              // "super" Frame shows

    }
    // class for number key
    class Mybutton extends JButton implements ActionListener {
        // constructor
        public Mybutton (String l) {
            setLabel(l);
            panelKey.add(this);
            addActionListener(this);    // Action listener
        }
        // Action
        void doAction() {
            // Determine which key was pressed
            String key = this.getLabel();
            //System.out.println(key);
            // Insert the pressed key into our text fields Document
            try {
                int temp = Integer.parseInt(tfDisplay.getText());
                if (temp == result) {
                    tfDisplay.setText("");
                }
                    
            } catch (Exception e) {
                //TODO: handle exception
            }

            key = tfDisplay.getText() + key;
            tfDisplay.setText(key);
            //setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            doAction();
        }
    }
    // class for clear key
    class BtnClear extends Mybutton {
        public BtnClear(String l) {
            super(l);
        }

        @Override
        void doAction() {
            // clear disply
            tfDisplay.setText("");
            // clear input buffer
            result = preVal = 0;
        }
    }
// class for operation
class BtnCalc extends Mybutton {
    public BtnCalc(String l) {
        super(l);
    }
    @Override
    void doAction() {
        // Get display
        int temp = Integer.parseInt(tfDisplay.getText());
        boolean fDisplay = true;
        // Calculate
        switch (keyOp) {
            case "+":
                result = preVal += temp;
                break;
            case "-":
                result = preVal -= temp;
                break;
            case "X":
                result = preVal *= temp;
                break;
            case "/":
                result = preVal /= temp;
                break;
            case "=":
                result = preVal = temp; 
                //preVal = 0; 
                break;
            default:
                preVal = temp; 
                fDisplay=false;
                break;
        }
        // update disply
        if(fDisplay == true) {
            tfDisplay.setText(Integer.toString(result));
        } else {
            tfDisplay.setText("");
        }
        // save Operator for next time
        keyOp = this.getLabel();
    }
}
}