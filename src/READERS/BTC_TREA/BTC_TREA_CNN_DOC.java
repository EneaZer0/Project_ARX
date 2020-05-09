package READERS.BTC_TREA;

import READERS.Generic_Process_DOC;

import java.nio.file.Path;
import java.util.ArrayList;

public class BTC_TREA_CNN_DOC extends Generic_Process_DOC {

    private Double BTC_TREA_Capital_Call;

    public BTC_TREA_CNN_DOC(Path path) {
        super();
        generalProcess(path);

    }

    @Override
    public void generalProcess(Path path) {
        super.generalProcess(path);
    }

    @Override
    public void value_Assigner(ArrayList<Double> numbersArray) {

        BTC_TREA_Capital_Call = numbersArray.get(10);
    }

    @Override
    public void print_all_info(ArrayList<Double> numbersArray) {

        System.out.println("Capital Call due amount: " + BTC_TREA_Capital_Call);
    }

}
