import GUITEST.GUI;
import MAINGUI.MainGUI;
import READERS.AnaCap.AnaCap_CCN_DOC;
import READERS.AnaCap.AnaCap_Paths;
import READERS.BTC_TREA.BTC_Paths;
import READERS.BTC_TREA.BTC_TREA_CAS_DOC;
import READERS.BTC_TREA.BTC_TREA_Capital_Call_Notice_DOC;
import READERS.Khronos.Khronos_Capital_Call;
import READERS.Khronos.Khronos_Paths;
import READERS.Khronos.Khronos_Statement;


public class Main {





    public static void main(String[] args) {

        GUI gui = new GUI();
        MainGUI mainGUI = new MainGUI();

        BTC_print_all_info();
        AnaCap_print_all_info();
        Khronos_print_all_info();

    }

    private static void BTC_print_all_info() {

        BTC_Paths paths_document = new BTC_Paths();
        BTC_TREA_CAS_DOC btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_09_30_CYGNUS_ALTERNATIVE_MASTER);
        System.out.print("\n");
        btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_12_31_CYGNUS_ALTERNATIVE_MASTER);
        System.out.print("\n");
        btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2020_03_31_CYGNUS_ALTERNATIVE_MASTER);
        System.out.print("\n");
        BTC_TREA_Capital_Call_Notice_DOC btc_trea_cnn_doc = new BTC_TREA_Capital_Call_Notice_DOC(paths_document.BTC_TREA_SCA_SICAR_CCN_2019_07_26_CYGNUS_ALTERNATIVE_MASTER);

    }

    private static void AnaCap_print_all_info() {
        AnaCap_Paths paths_document = new AnaCap_Paths();
        AnaCap_CCN_DOC anaCap_ccn_doc;

        anaCap_ccn_doc = new AnaCap_CCN_DOC(paths_document.AnaCap_III_Statement_2018_12);
        System.out.print("\n");
        anaCap_ccn_doc = new AnaCap_CCN_DOC(paths_document.AnaCap_III_Statement_2019_03);
        System.out.print("\n");
        anaCap_ccn_doc = new AnaCap_CCN_DOC(paths_document.AnaCap_III_Statement_2019_06);
        System.out.print("\n");
        anaCap_ccn_doc = new AnaCap_CCN_DOC(paths_document.AnaCap_III_Statement_2019_12);
    }

    private static void Khronos_print_all_info() {

        Khronos_Paths khronos_paths = new Khronos_Paths();

        Khronos_Statement khronos_statement = new Khronos_Statement(khronos_paths.Khronos_Statement_2018_06_SubFund_1504_01_Series_2);
        System.out.print("\n");
        Khronos_Capital_Call khronos_capital_call = new Khronos_Capital_Call(khronos_paths.Khronos_Capital_Call_2018_11_SubFund_1504_01);




    }

}
