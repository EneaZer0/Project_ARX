package BTC_TREA;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;


public class BTC_TREA_INFO_Reader_CCN {

    private Double BTC_TREA_Capital_Call;
    private ArrayList<String> dataArray;
    private ArrayList<Double> numberArray;
    private BTC_TREA_INFO_Reader_CAS reader_cas;

    private Pattern pattern = Pattern.compile("-?\\d*([.,]\\d*)*?(\\d*)?");

    public void All_Process_Extractor(Path path) {

        Objects.requireNonNull(path);

        reader_cas = new BTC_TREA_INFO_Reader_CAS();
        dataArray = reader_cas.reader(path);

        CC_extractor();

    }

    private void CC_extractor() {
        numberArray = new ArrayList<>();
        extractor(dataArray, pattern, numberArray);
        BTC_TREA_Capital_Call = numberArray.get(7);
        System.out.println("Capital Call due amount: " + BTC_TREA_Capital_Call);

    }

    static void extractor(ArrayList<String> dataArray, Pattern pattern, ArrayList<Double> numberArray) {
        for (String str : dataArray) {
            String[] words = str.split(" ");

            for (String word : words) {
                Double number;
                if (pattern.matcher(word).matches() && !word.equals("-")) {
                    if (word.contains(",")) {
                        word = word.replaceAll("\\,", "");
                        if (word.endsWith(".")) {
                            word = word.substring(0, word.length()-1);
                        }
                        number = Double.parseDouble(word);

                    } else {
                        number = Double.parseDouble(word);
                    }
                    numberArray.add(number);
                }
            }
        }
    }

    /* _____________ GETTER ___________________*/
    public Double getBTC_TREA_Capital_Call() {
        return BTC_TREA_Capital_Call;
    }
}
