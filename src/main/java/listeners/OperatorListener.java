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

    public OperatorListener(String value, JButton button, Field field, JTextField operationTxt, Layout layout) {
        this.value = value;
        this.field = field;
        this.layout = layout;
        this.operationTxt = operationTxt;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // pour pouvoir enchainer les operations mm aprs egale 
        if (!"".equals(field.getField())) {
            Calculation.fields.add(field.getField());
        }
        if (!Calculation.isOPERATION_FLAG()) {
            if ("".equals(field.getField()) && Calculation.fields.isEmpty()) {
                JOptionPane.showMessageDialog(layout,
                        "Invalid format, insert number first",
                        "Syntax error",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println("teeeeeest");
            } else {
                operationTxt.setText(operationTxt.getText() + value);
                Calculation.operations.add(value);
                field.setField("");
                Calculation.setOPERATION_FLAG(true);
            }
        } else {
            Calculation.operations.set(Calculation.operations.size() - 1, value);
            // seeting old text value to ""
            operationTxt.setText("");
            for (int i = 0; i < Calculation.fields.size(); i++) {
                // new text value
                operationTxt.setText(operationTxt.getText() + Calculation.fields.get(i) + Calculation.operations.get(i));
                Calculation.setOPERATION_FLAG(true);

            }
        }
        //Calculation.setOPERATION_FLAG(true);
        System.out.println("added operation");
        System.out.println(Calculation.operations);
        System.out.println(Calculation.fields);
    }
}
