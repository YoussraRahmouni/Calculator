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

    /**
     * concatenates digits entered by the user
     */
    private String field;
    /**
     * Scientefic operations are calculated immediately after the user enters
     * them The flag is used to determine wether or not the scientific operation
     * is to be calculated Hence defined in field class
     */
    private boolean SCIENTIFIC_FLAG = false;
    /**
     * Stores the value of the scientific method to be applied to the stored
     * field
     */
    private String scientificMethod;

    /**
     * Class constructor, sets field to an empty string
     */
    public Field() {
        field = "";
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void emptyField() {
        this.field = "";
    }

    public boolean isSCIENTIFIC_FLAG() {
        return SCIENTIFIC_FLAG;
    }

    public void setSCIENTIFIC_FLAG(boolean SCIENTIFIC_FLAG) {
        this.SCIENTIFIC_FLAG = SCIENTIFIC_FLAG;
    }

    public String getScientificMethod() {
        return scientificMethod;
    }

    public void setScientificMethod(String scientificMethod) {
        this.scientificMethod = scientificMethod;
    }
}
