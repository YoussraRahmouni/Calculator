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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import views.Layout;

/**
 *
 * @author Rahmouni Youssra
 */
public class EqualsListener implements ActionListener {

    private Field field;
    private JTextField operationTxt;
    private JTextField resultTxt;
    private Layout layout;

    /**
     * Constructor of equalsListener
     * @param button
     * @param field
     * @param operationTxt
     * @param resultTxt
     * @param layout 
     */
    public EqualsListener(JButton button, Field field, JTextField operationTxt, JTextField resultTxt, Layout layout) {
        this.field = field;
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        this.layout = layout;
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the only operation that is preformed is a scientific operation
        if (field.isSCIENTIFIC_FLAG()) {
            Calculation.calculateScientificField(field);
        }
        /**
        * A field is added after user preforms action on an operation button
        * If last action preformed is a digit the number will be stored in field instance 
        * But won't be added to fields list
        * This condition checks if Field instance is not empty
        * And adds last field entered by the user to fields list 
        */
        if (!"".equals(field.getField()) && (field.isSCIENTIFIC_FLAG() == false)) {
            Calculation.fields.add(field.getField());
        }
        // Reset field
        field.emptyField();
        Calculation.setOPERATION_FLAG(false);
        //System.out.println(Calculation.fields);
        //System.out.println(Calculation.operations);
        /**
         * Display a syntax error if the the user only enters an operation without a number
         * */
        if (Calculation.fields.size() == Calculation.operations.size()) {
            JOptionPane.showMessageDialog(layout,
                    "Invalid format, operation can not end with operand",
                    "Syntax error",
                    JOptionPane.ERROR_MESSAGE);
        } 
        /**
         * Calculate the operation if syntax is correct and all conditions are met
         */
        else {
            String result = Calculation.calculate();
            Double res = Double.parseDouble(Calculation.calculate());
            System.out.println(res);
            // Check if the user entered a division by zero
            if (res == Double.POSITIVE_INFINITY || res.isNaN()) {
                JOptionPane.showMessageDialog(layout,
                        "Invalid format, division by zero is not allowed",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                resultTxt.setText(Calculation.calculate());
                operationTxt.setText(Calculation.calculate());
            }
        }
    }
}
