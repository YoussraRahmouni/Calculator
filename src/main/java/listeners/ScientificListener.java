/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

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
public class ScientificListener implements ActionListener {

    private String value;
    private Field field;
    private JTextField operationTxt;
    private Layout layout;

    /**
     * ScientificListener constructor
     * @param value
     * @param button
     * @param field
     * @param operationTxt
     * @param layout 
     */
    public ScientificListener(String value, JButton button, Field field, JTextField operationTxt, Layout layout) {
        this.value = value;
        this.field = field;
        this.operationTxt = operationTxt;
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Restricting the user from entering two scientific operations without an intermediate arithmetic operation
         */
        if (field.isSCIENTIFIC_FLAG()) {
            JOptionPane.showMessageDialog(layout,
                    "Invalid format, first enter an operand",
                    "Syntax error",
                    JOptionPane.ERROR_MESSAGE);
        } 
        /**
         * Soring information about the clicked scientific operation in field instance to be used 
         */
        else {
            operationTxt.setText(operationTxt.getText() + value);
            field.setSCIENTIFIC_FLAG(true);
            field.setScientificMethod(value);
        }
    }
}
