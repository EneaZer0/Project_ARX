package READERS.BTC_TREA;

import READERS.Generic_DOC_DOCX_Reader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class BTC_TREA_CNN_DOC {

    private ArrayList<Double> numbersArray;

    private Double BTC_TREA_Capital_Call;

    public BTC_TREA_CNN_DOC(Path path) {

        Objects.requireNonNull(path);
        numbersArray = new ArrayList<>();

        Generic_DOC_DOCX_Reader read_BTC_TREA_CAS_DOC = new Generic_DOC_DOCX_Reader(path);
        numbersArray = read_BTC_TREA_CAS_DOC.getNumberArray();

        value_Assigner();
        print_all_info();

    }

    private void value_Assigner() {
        BTC_TREA_Capital_Call = numbersArray.get(10);
    }

    private void print_all_info() {
        System.out.println("Capital Call due amount: " + BTC_TREA_Capital_Call);
    }

}
