package READERS;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class Generic_Process_DOC {

    ArrayList<Double> numbersArray;

    public Generic_Process_DOC() {
        numbersArray = new ArrayList<>();
    }

    public void generalProcess(Path path) {
        Objects.requireNonNull(path);

        Generic_DOC_DOCX_Reader read_BTC_TREA_CAS_DOC = new Generic_DOC_DOCX_Reader(path);
        numbersArray = read_BTC_TREA_CAS_DOC.getNumberArray();
        value_Assigner(numbersArray);
        print_all_info(numbersArray);

    }

    public void value_Assigner(ArrayList<Double> numbersArray) {
    }

    public void print_all_info(ArrayList<Double> numbersArray){
    }
}
