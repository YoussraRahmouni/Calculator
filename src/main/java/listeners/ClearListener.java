/*
 * This class defines a custom listener for the clear button 
 */
package listeners;

import calculator.Calculation;
import calculator.Field;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Rahmouni Youssra
 */
public class ClearListener implements ActionListener {

    private JTextField operationTxt;
    private JTextField resultTxt;
    private Field field;

    /**
     * 
     * @param button
     * @param operationTxt
     * @param resultTxt
     * @param field 
     */
    public ClearListener(JButton button, JTextField operationTxt, JTextField resultTxt, Field field) {
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        this.field = field;
        // Add a listener to the button instance 
        button.addActionListener(this);
    }

    /**
     * define the custom actionPerformed method
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Resets the fields arraylist
         * Resets the operations arraylist
         */
        Calculation.resetCalculation();
        /**
         * Clears the istance of field
         */
        field.emptyField();
        /**
         * clearing textFields for new operations
         */
        operationTxt.setText("");
        resultTxt.setText("");
        //System.out.println(Calculation.fields);
        //System.out.println(Calculation.operations);
    }
}
