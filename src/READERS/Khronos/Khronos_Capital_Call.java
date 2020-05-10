package READERS.Khronos;

import READERS.Generic_Process_DOC;

import java.nio.file.Path;
import java.util.ArrayList;

public class Khronos_Capital_Call extends Generic_Process_DOC {

    private Double Khronos_CC;

    public Khronos_Capital_Call(Path path) {
        super();
        generalProcess(path);
    }

    @Override
    public void value_Assigner(ArrayList<Double> numbersArray) {
        Khronos_CC = numbersArray.get(5);
    }

    @Override
    public void print_all_info(ArrayList<Double> numbersArray) {
        System.out.println("Capital Call due amount: " + Khronos_CC);
    }
}
