package MAINGUI;

import GUITEST.StringListener;

import java.util.EventObject;

public class TypeDocEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private String path;
    private String fond;
    private String typeFond;


    public TypeDocEvent(Object source) {
        super(source);
    }

    public TypeDocEvent(Object source, String path) {
        super(source);

        this.path = path;
    }

    public TypeDocEvent(Object source, String path, String fond, String typeFond) {
        super(source);

        this.path = path;
        this.fond = fond;
        this.typeFond = typeFond;

    }

    public String getPath() {
        return path;
    }

    public String getFond() {
        return fond;
    }

    public String getTypeFond() {
        return typeFond;
    }
}
