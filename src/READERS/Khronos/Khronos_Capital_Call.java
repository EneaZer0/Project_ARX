package READERS.Khronos;

import MAINGUI.CONSTANTS.String_Constants;
import READERS.Generic_Process_DOC;

import java.nio.file.Path;
import java.util.ArrayList;

public class Khronos_Capital_Call extends Generic_Process_DOC {

    private Double Khronos_CC;
    private String_Constants string;

    public Khronos_Capital_Call(Path path, String_Constants string) {
        super();
        generalProcess(path);
        this.string = string;
    }

    @Override
    public void value_Assigner(ArrayList<Double> numbersArray) {
        if (numbersArray.size() == 12){

            Khronos_CC = numbersArray.get(5);

        } else {

            throw new IllegalArgumentException("ERROR: The amount of numbers does not coincide with the supposed model. Revise the document. Probably a new model must be made.");

        }

    }

    @Override
    public void print_all_info(ArrayList<Double> numbersArray) {
        System.out.println("Capital Call due amount: " + Khronos_CC);
    }

    @Override
    public String getString_all_info() {
        return string.ntab + "Capital Call due amount: " + Khronos_CC + string.ntab;
    }
}
