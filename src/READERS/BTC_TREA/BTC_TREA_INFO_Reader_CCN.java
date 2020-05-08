package READERS.BTC_TREA;


import READERS.Extractor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


public class BTC_TREA_INFO_Reader_CCN {

    private Double BTC_TREA_Capital_Call;
    private ArrayList<String> dataArray;
    private ArrayList<Double> numberArray;
    private BTC_TREA_INFO_Reader_CAS reader_cas;



    public void All_Process_Extractor(Path path) {

        Objects.requireNonNull(path);

        reader_cas = new BTC_TREA_INFO_Reader_CAS();
        dataArray = reader_cas.reader(path);

        CC_extractor();

    }

    private void CC_extractor() {
        numberArray = new ArrayList<>();
        Extractor extractor = new Extractor(dataArray);
        numberArray = extractor.getNumberArray();
        BTC_TREA_Capital_Call = numberArray.get(10);
        System.out.println("Capital Call due amount: " + BTC_TREA_Capital_Call);

    }

    /* _____________ GETTER ___________________*/
    public Double getBTC_TREA_Capital_Call() {
        return BTC_TREA_Capital_Call;
    }
}
