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
public class OperatorListener implements ActionListener {

    private String value;
    private Field field;
    private JTextField operationTxt;
    private Layout layout;

    /**
     * OperatorListener Constructor
     *
     * @param value
     * @param button
     * @param field
     * @param operationTxt
     * @param layout
     */
    public OperatorListener(String value, JButton button, Field field, JTextField operationTxt, Layout layout) {
        this.value = value;
        this.field = field;
        this.layout = layout;
        this.operationTxt = operationTxt;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * Check if there is a stored result
         */
        if (!"".equals(field.getField()) && (field.isSCIENTIFIC_FLAG() == false)) {
            Calculation.fields.add(field.getField());
        }
        
        if (!Calculation.isOPERATION_FLAG()) {
            /**
             * Result is empty and first clicked button is an operation
             * Display syntax eroor to the user
             */
            if ("".equals(field.getField()) && Calculation.fields.isEmpty()) {
                JOptionPane.showMessageDialog(layout,
                        "Invalid format, insert number first",
                        "Syntax error",
                        JOptionPane.ERROR_MESSAGE);
            }
            /**
             * If a scientific operation has been clicked before
             */
            else {
                if (field.isSCIENTIFIC_FLAG()) {
                    /**
                     * method that calculates last clicked scientific operations
                     */
                    Calculation.calculateScientificField(field);
                }
                operationTxt.setText(operationTxt.getText() + value);
                Calculation.operations.add(value);
                field.emptyField();
                Calculation.setOPERATION_FLAG(true);
            }
        } 
        /**
         * Update display if multiple operations are clicked sequentially
         */
        else {
            Calculation.operations.set(Calculation.operations.size() - 1, value);
            operationTxt.setText("");
            for (int i = 0; i < Calculation.fields.size(); i++) {
                // new text value
                operationTxt.setText(operationTxt.getText() + Calculation.fields.get(i) + Calculation.operations.get(i));
                Calculation.setOPERATION_FLAG(true);

            }
        }
        //System.out.println(Calculation.operations);
        //System.out.println(Calculation.fields);
    }
}
