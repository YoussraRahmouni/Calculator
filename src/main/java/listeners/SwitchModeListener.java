/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import views.Layout;

/**
 *
 * @author Rahmouni Youssra
 */
public class SwitchModeListener implements ActionListener {

    private Layout layout;

    /**
     * SwitchModeListener Constructor
     * @param button
     * @param layout 
     */
    public SwitchModeListener(JToggleButton button, Layout layout) {
        this.layout = layout;
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        /**
         * return state of the toggle button
         */
        boolean selected = abstractButton.getModel().isSelected();
        if(selected){
            layout.getjPanel4().setVisible(true);
        }
        else{
            layout.getjPanel4().setVisible(false);
        }
    }
}
