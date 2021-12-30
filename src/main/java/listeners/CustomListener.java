/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import calculator.Field;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Rahmouni Youssra
 */
abstract class CustomListener implements ActionListener {
    private Field field;
    
    @Override
    public abstract void actionPerformed(ActionEvent e);
    
}
