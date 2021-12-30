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
public class ClearListener implements ActionListener {

    private JTextField operationTxt;
    private JTextField resultTxt;
    private Field field;

    public ClearListener(JButton button, JTextField operationTxt, JTextField resultTxt, Field field) {
        this.operationTxt = operationTxt;
        this.resultTxt = resultTxt;
        this.field=field;
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculation.fields.clear();
        Calculation.operations.clear();
        field.setField("");
        operationTxt.setText("");
        resultTxt.setText("");
        System.out.println(Calculation.fields);
        System.out.println(Calculation.operations);
    }
}
