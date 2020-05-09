import GUI.GUI;
import READERS.BTC_TREA.BTC_Paths;
import READERS.BTC_TREA.BTC_TREA_CAS_DOC;
import READERS.BTC_TREA.BTC_TREA_CNN_DOC;


public class Main {





    public static void main(String[] args) {

        GUI gui = new GUI();

        print_all_info();

    }

    private static void print_all_info() {

        BTC_Paths paths_document = new BTC_Paths();
        BTC_TREA_CAS_DOC btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_09_30_CYGNUS_ALTERNATIVE_MASTER);
        System.out.print("\n");
        BTC_TREA_CNN_DOC btc_trea_cnn_doc = new BTC_TREA_CNN_DOC(paths_document.BTC_TREA_SCA_SICAR_CCN_2019_07_26_CYGNUS_ALTERNATIVE_MASTER);

    }

}
