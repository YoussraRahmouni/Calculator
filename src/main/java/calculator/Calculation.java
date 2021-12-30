/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;

/**
 *
 * @author Rahmouni Youssra
 */
public class Calculation {

    private static boolean OPERATION_FLAG = false;
    public static ArrayList<String> operations = new ArrayList<String>();
    public static ArrayList<String> fields = new ArrayList<String>();

    public static boolean isOPERATION_FLAG() {
        return OPERATION_FLAG;
    }

    public static void setOPERATION_FLAG(boolean OPERATION_FLAG) {
        Calculation.OPERATION_FLAG = OPERATION_FLAG;
    }

    public static String calculate(ArrayList<String> fields, ArrayList<String> operations) {
        for (int i = 0; i < operations.size(); i++) {
            Float f;
            switch (operations.get(i)) {
                case "x":
                    f = Float.parseFloat(fields.get(i)) * Float.parseFloat(fields.get(i + 1));
                    fields.set(i, String.valueOf(f));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
                case "/":

                    f = Float.parseFloat(fields.get(i)) / Float.parseFloat(fields.get(i + 1));
                    fields.set(i, String.valueOf(f));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;

            }
        }
        for (int i = 0; i < operations.size(); i++) {
            if ("+".equals(operations.get(i))) {
                Float f = Float.parseFloat(fields.get(i)) + Float.parseFloat(fields.get(i + 1));
                fields.set(i, String.valueOf(f));
                fields.remove(i + 1);
                operations.remove(i);
            }
            if (!operations.isEmpty() && "-".equals(operations.get(i))) {
                Float f = Float.parseFloat(fields.get(i)) - Float.parseFloat(fields.get(i + 1));
                fields.set(i, String.valueOf(f));
                fields.remove(i + 1);
                operations.remove(i);
            }
        }

        return fields.get(0);
    }

}
