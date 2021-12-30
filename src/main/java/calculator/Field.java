/*
 * Field builds numbers from digits given by the user
 * One instance of this class is created 
 * And reused for each number construction
 * It is passed as a parameter to all the methods that use it 
 */
package calculator;

/**
 *
 * @author Rahmouni Youssra
 */
public class Field {
    private String field;

    public Field() {
        field = "";
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
