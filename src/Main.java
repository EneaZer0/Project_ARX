import GUI.GUI;
import READERS.BTC_TREA.BTC_MAIN;
import READERS.BTC_TREA.BTC_Paths;
import READERS.DOC_Reader;

import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();

        //print_all_info();

        new DOC_Reader(Paths.get("C:\\Users\\migue\\OneDrive - University of Edinburgh\\EDINBURGH\\Alternative Ratings\\Project_ARX\\src\\Files_Resource\\DOC\\BTC_TREA\\GOOD_BTC_TREA_SCA_SICAR_CAS_2019.09.30_CYGNUS_ALTERNATIVE_MASTER.doc"));

    }

    private static void print_all_info() {



        BTC_MAIN BTC_Info_Getter = new BTC_MAIN();
        BTC_Paths paths_document = new BTC_Paths();

        BTC_Info_Getter.new_research_CAS(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_09_30_CYGNUS_ALTERNATIVE_MASTER);
        System.out.println("\n\n");
        BTC_Info_Getter.new_research_CAS(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_12_31_CYGNUS_ALTERNATIVE_MASTER);
        System.out.println("\n\n");
        BTC_Info_Getter.new_research_CAS(paths_document.BTC_TREA_SCA_SICAR_CAS_2020_03_31_CYGNUS_ALTERNATIVE_MASTER);
        System.out.println("\n\n");

        BTC_Info_Getter.new_research_CCN(paths_document.BTC_TREA_SCA_SICAR_CCN_2019_07_26_CYGNUS_ALTERNATIVE_MASTER);



    }

}
