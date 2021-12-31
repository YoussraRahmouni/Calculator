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
    
    // Preforms basic operations and adds result them as a field in fields list
    public static String calculate() {
        for (int i = 0; i < operations.size(); i++) {
            Double d;
            switch (operations.get(i)) {
                case "%":
                    d = Double.parseDouble(fields.get(i)) % Double.parseDouble(fields.get(i + 1));
                    fields.set(i, String.valueOf(d));
                    fields.remove(i + 1);
                    operations.remove(i);
                    break;
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

    // Clears list of operations and fields 
    public static void resetCalculation() {
        operations.clear();
        fields.clear();
    }

    // Preforms scientific operations and adds result them as a field in fields list
    // Parenthesis and multiple operations are not supported, eg cos(2x3+5) 
    // Scientific operations only support a number as a parameter not an operation
    public static void calculateScientificField(Field field) {
        double f;
        switch (field.getScientificMethod()) {
            case "cos":
                f = Math.toRadians(Double.parseDouble(field.getField()));
                fields.add(Double.toString(Math.cos(f)));
                field.setSCIENTIFIC_FLAG(false);
                field.emptyField();
                break;
            case "sin":
                f = Math.toRadians(Double.parseDouble(field.getField()));
                fields.add(Double.toString(Math.sin(f)));
                field.setSCIENTIFIC_FLAG(false);
                field.emptyField();
                break;
            case "tan":
                f = Math.toRadians(Double.parseDouble(field.getField()));
                fields.add(Double.toString(Math.tan(f)));
                field.setSCIENTIFIC_FLAG(false);
                field.emptyField();
                break;
            case "fact":
                int d = Calculation.factorial(Integer.parseInt(field.getField()));
                fields.add(Double.toString(d));
                field.setSCIENTIFIC_FLAG(false);
                field.emptyField();
                break;
        }
    }

    // Recursive function that returns factorial of an integer
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
