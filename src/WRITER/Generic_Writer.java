package WRITER;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Pattern;

import READERS.Generic_Number_Extractor;
import org.apache.commons.collections4.ListValuedMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Generic_Writer {

    private String information;
    private ArrayList<ArrayList<String>> arrayInformation;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Pattern pattern;


    public Generic_Writer(String information) {
        this.information = information;

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Java Books");

        pattern = Pattern.compile("\\$?\\(?-?\\d*([.,]\\d*)*?(\\d*)?\\)?[x%]?");

        arrayInformation = new ArrayList<>();

        informationSplitter();

        informationSaver();
    }

    private void informationSplitter() {
        String[] lineSeparator = information.split("\n");
        for (int i = 0; i < lineSeparator.length; i++) {
            if (!lineSeparator[i].isBlank() && !lineSeparator[i].isEmpty()) {
                String line = lineSeparator[i].strip();
                String[] lineInfo = line.split(":");

                ArrayList<String> infoPair = new ArrayList<>();

                infoPair.add(lineInfo[0]);
                //System.out.println("variable: " + lineInfo[0]);
                infoPair.add(lineInfo[1]);
                //System.out.println("value: " + lineInfo[1]);

                arrayInformation.add(infoPair);
            }


        }

        // printInformation();


    }

    private void printInformation() {

        for(int i = 0; i < arrayInformation.size(); i++) {

            for (int j = 0; j < arrayInformation.get(i).size(); j++) {
                System.out.print(arrayInformation.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private void informationSaver() {


        int rowCount = -1;

        for (ArrayList<String> rowArray : arrayInformation) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = -1;

            for (String element : rowArray) {
                Cell cell = row.createCell(++columnCount);
                if (pattern.matcher(element.strip()).matches()) {
                    double number = Double.parseDouble(element.strip());
                    cell.setCellValue((Double) number);
                }
                else if (element instanceof String) {
                    cell.setCellValue((String) element);
                }
            }
        }

        SavingOptionsPopUp popUp = new SavingOptionsPopUp(workbook, sheet);



    }

}
