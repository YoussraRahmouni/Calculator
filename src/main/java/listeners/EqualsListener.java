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

    public EqualsListener(JButton button, Field field, JTextField operationTxt, JTextField resultTxt, Layout layout) {
        this.field = field;
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        this.layout = layout;
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!"".equals(field.getField())) {
            Calculation.fields.add(field.getField());
        }
        field.setField("");
        Calculation.setOPERATION_FLAG(false);
        System.out.println(Calculation.fields);
        System.out.println(Calculation.operations);
        if (Calculation.fields.size() == Calculation.operations.size()) {
            JOptionPane.showMessageDialog(layout,
                    "Invalid format, operation can not end with operand",
                    "Syntax error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String result = Calculation.calculate(Calculation.fields, Calculation.operations);
            resultTxt.setText(Calculation.calculate(Calculation.fields, Calculation.operations));
            operationTxt.setText(Calculation.calculate(Calculation.fields, Calculation.operations));
        }
    }
}
