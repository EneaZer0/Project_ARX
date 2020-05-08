package READERS.BTC_TREA;

import java.nio.file.Path;

public class BTC_MAIN {

        private BTC_TREA_INFO_Reader_CAS extractor_CAS;
        private BTC_TREA_INFO_Reader_CCN extractor_CCN;
        private String data;

        public String new_research_CAS(Path path) {

                extractor_CAS = new BTC_TREA_INFO_Reader_CAS();
                data = extractor_CAS.All_Process_Extractor(path);
                return data;
        }

        public void new_research_CCN(Path path) {

                extractor_CCN = new BTC_TREA_INFO_Reader_CCN();
                extractor_CCN.All_Process_Extractor(path);

        }


}
