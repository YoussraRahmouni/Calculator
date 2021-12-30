/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Rahmouni Youssra
 */
public class Field {

    private static Field INSTANCE;
    private String field;

    private Field() {
        field = "";
    }

    public static Field getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Field();
        }

        return INSTANCE;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
