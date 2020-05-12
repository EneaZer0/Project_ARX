package GUITEST;

import java.util.EventObject;

public class FromEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private String name;
    private String occupation;
    private int ageCategory;
    private String employmentCat;

    public FromEvent(Object source) {
        super(source);
    }

    public FromEvent(Object source, String name, String occupation, int ageCategory, String employmentCat){
        super(source);

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employmentCat = employmentCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getEmploymentCat() {
        return employmentCat;
    }
}
