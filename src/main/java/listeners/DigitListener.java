/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public DigitListener(String value, JButton button, Field field, JTextField operationTxt, JTextField resultTxt) {
        this.value = value;
        this.field = field;
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Calculation.fields.size() == 1 && !Calculation.isOPERATION_FLAG() && Calculation.operations.isEmpty()) {
            Calculation.fields.clear();
            Calculation.operations.clear();
            operationTxt.setText(value);
            resultTxt.setText("");
            field.setField(value);
        }
        else{
        operationTxt.setText(operationTxt.getText() + value);
        field.setField(field.getField() + value);
        Calculation.setOPERATION_FLAG(false);
        System.out.println("test");
        System.out.println(Calculation.fields);
        }
    }

}
