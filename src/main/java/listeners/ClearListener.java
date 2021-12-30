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

    public ClearListener(JButton button, JTextField operationTxt, JTextField resultTxt, Field field) {
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        this.field = field;
        button.addActionListener(this);
    }

    //Override the default actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Resets the fields arraylist
        // Resets the operations arraylist
        Calculation.resetCalculation();
        // clears the istance of field
        field.emptyField();
        // clears textFields
        operationTxt.setText("");
        resultTxt.setText("");
        System.out.println(Calculation.fields);
        System.out.println(Calculation.operations);
    }
}
