/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import views.Layout;

/**
 *
 * @author Rahmouni Youssra
 */
public class SwitchModeListener implements ActionListener {

    private Layout layout;

    public SwitchModeListener(JButton button, Layout layout) {
        this.layout = layout;
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        layout.getjPanel4().setVisible(true);
    }
}
