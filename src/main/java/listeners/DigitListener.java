/*
 * This class defines a listener for digit buttons
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
public class DigitListener implements ActionListener {

    private String value;
    private Field field;
    private JTextField operationTxt;
    private JTextField resultTxt;
    /**
     * Constructor of digit listener
     * @param value
     * @param button
     * @param field
     * @param operationTxt
     * @param resultTxt 
     */

    public DigitListener(String value, JButton button, Field field, JTextField operationTxt, JTextField resultTxt) {
        this.value = value;
        this.field = field;
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If first button clicked after enter is a digit, the stored result won't be used
        if (Calculation.fields.size() == 1 && !Calculation.isOPERATION_FLAG() && Calculation.operations.isEmpty()) {
            Calculation.resetCalculation();
            operationTxt.setText(value);
            resultTxt.setText("");
            field.setField(value);
        } 
        // If an operation is clicked the stored result is used as first field of fields
        else {
            operationTxt.setText(operationTxt.getText() + value);
            field.setField(field.getField() + value);
            Calculation.setOPERATION_FLAG(false);
            //System.out.println(Calculation.fields);
        }
    }

}
