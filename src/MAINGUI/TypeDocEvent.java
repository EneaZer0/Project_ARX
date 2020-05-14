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

    private int fondId;
    private String fond;

    private int typeFondId;
    private String typeFond;


    public TypeDocEvent(Object source) {
        super(source);
    }

    public TypeDocEvent(Object source, String path, String fond, String typeFond, int fondId, int typeFondId) {
        super(source);

        this.path = path;

        this.fond = fond;
        this.fondId = fondId;

        this.typeFond = typeFond;
        this.typeFondId = typeFondId;

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

    public int getFondId() {return fondId;}

    public int getTypeFondId() {
        return typeFondId;
    }

}
