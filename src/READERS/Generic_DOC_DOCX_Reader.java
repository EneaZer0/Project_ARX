package READERS;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;


public class Generic_DOC_DOCX_Reader {

    private Path path;
    private ArrayList<String> dataArray;
    private ArrayList<Double> numberArray;

    public Generic_DOC_DOCX_Reader(Path path) {
        this.path = path;
        dataArray = new ArrayList<>();

        reader();
    }

    private void reader() {

        String FilePath = String.valueOf(path);
        FileInputStream fis;

        if(FilePath.substring(FilePath.length() -1).equals("x")){ //is a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                XWPFDocument doc = new XWPFDocument(fis);
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);

                // System.out.println(extract.getText());

                docxExtractor(extract);


            } catch (IOException e) {

                e.printStackTrace();
            }
        } else { //is not a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor extractor = new WordExtractor(doc);

                // System.out.println(extractor.getText());

                docExtractor(extractor);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void docxExtractor(XWPFWordExtractor wordExtractor) {

        String[] lines = wordExtractor.getText().split(" ");

        information_extractor(lines);

    }

    private void docExtractor(WordExtractor wordExtractor) {

        String[] lines = wordExtractor.getParagraphText();

        information_extractor(lines);

    }

    private void information_extractor(String[] lines) {
        for (String line : lines) {
            line = line.replaceAll("\\u0007", "");
            if (!line.isEmpty() && !line.isBlank()) {
                dataArray.add(line.strip());
            }

        }

        Generic_Number_Extractor extractor = new Generic_Number_Extractor(dataArray);
        numberArray = new ArrayList<>();
        numberArray = extractor.getNumberArray();

        /* TODO WHEN WORKING THIS PRINTS NUMBERS AND ALL THE TEXT (RECOMMENDABLE TO UN COMMENT IT TO WORK)
        System.out.println(dataArray.toString());
        System.out.println("\n");
        System.out.println(numberArray.toString());
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("nº: " + numberArray.size());
        */


    }

    public ArrayList<String> getDataArray() {
        return dataArray;
    }

    public ArrayList<Double> getNumberArray() {
        return numberArray;
    }
}
