package READERS;

import java.io.FileInputStream;
import java.nio.file.Path;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class DOC_Reader {

    private Path path;

    public DOC_Reader(Path path) {

        this.path = path;
        reader();

    }

    private void reader() {

        try {

            XWPFDocument document = new XWPFDocument(new FileInputStream(String.valueOf(path)));
            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
            System.out.println(wordExtractor.getText());

        } catch (Exception e){

            System.out.println(e.getMessage());
        }
    }
}
