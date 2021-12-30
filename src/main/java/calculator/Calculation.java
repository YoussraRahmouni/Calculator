/*
 * All members and methods of this class are static 
 * Because they are independent of other classes
 * And do not need an instance creation each time
 * @field operations stores operations given by the user 
 * @field fields stores numbers given by the user
 * @method calculate returns the result of calculations 
 * @return of the method is stored as the first element of fields 
 * To be reused in future operations
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
            Double d;
            switch (operations.get(i)) {
                case "x":
                    d = Double.parseDouble(fields.get(i)) * Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
                case "/":

                    d = Double.parseDouble(fields.get(i)) / Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;

            }
        }
        for (int i = 0; i < operations.size(); i++) {
            Double d;
            switch (operations.get(i)) {
                case "+":
                    d = Double.parseDouble(fields.get(i)) + Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
                case "-":

                    d = Double.parseDouble(fields.get(i)) - Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;

            }
        }
        return fields.get(0);
    }

    public static String calculate() {
        for (int i = 0; i < operations.size(); i++) {
            Double d;
            switch (operations.get(i)) {
                case "x":
                    d = Double.parseDouble(fields.get(i)) * Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
                case "/":

                    d = Double.parseDouble(fields.get(i)) / Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;

            }
        }
        for (int i = 0; i < operations.size(); i++) {
            Double d;
            switch (operations.get(i)) {
                case "+":
                    d = Double.parseDouble(fields.get(i)) + Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
                case "-":

                    d = Double.parseDouble(fields.get(i)) - Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;

            }
        }
        return fields.get(0);
    }

    public static void resetCalculation() {
        operations.clear();
        fields.clear();
    }
}
