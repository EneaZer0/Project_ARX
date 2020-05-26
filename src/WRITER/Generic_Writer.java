package WRITER;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class Generic_Writer {

    /**
     * This JOptionPane creates the POPUP
     */
    private JOptionPane optionPane;
    /**
     * This is the JFrame to set the POPUP
     */
    private JFrame parent;
    /**
     * JFileChooser to open an existing file, this sets the file where information will be saved
     */
    private JFileChooser fileChooser;
    /**
     * This variable contains the file that has been chosen if it exists
     */
    private File file;
    /**
     * This variable stores the path of the file where the information will be written
     */
    private Path path;
    /**
     * This is the file that contains the excel file
     */
    private XSSFWorkbook workbook;
    /**
     * This is the constant that saves the page in an excel file where information will be stored
     */
    private XSSFSheet sheet;
    /**
     * This is the pattern to determine if its a double
     */
    private Pattern pattern;
    /**
     * This is all the information concentrated in a String
     */
    private String information;
    /**
     * This is the array with all the information that will be saved
     */
    private ArrayList<ArrayList<String>> arrayInformation;
    /**
     * Constant used in the POPUP and corresponds to the button to save the information in a new file
     */
    private final int SAVE_AS_NEW_FILE = 0;
    /**
     * Constant used in the POPUP and corresponds to the button to save the information in an existing file
     */
    private final int SAVE_AS_EXISTING_FILE= 1;
    /**
     * Constant used in the POPUP and corresponds to the button to cancel the saving process
     */
    private final int CANCEL = 2;


    public Generic_Writer(String information) {
        this.information = information;

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Java Books");

        pattern = Pattern.compile("\\$?\\(?-?\\d*([.,]\\d*)*?(\\d*)?\\)?[x%]?");

        arrayInformation = new ArrayList<>();

        informationSplitter();

        POPUP();
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

    private void POPUP() {
        optionPane = new JOptionPane();
        parent = new JFrame();

        Object[] options = {"Save as New File",
                "Save in Existing File",
                "Cancel"};
        int n = optionPane.showOptionDialog(parent,
                "How would you like to save the information? ",
                "Saving options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        if (n == SAVE_AS_NEW_FILE) {
            saveNewProcess();
        } else if (n == SAVE_AS_EXISTING_FILE) {
            System.out.println("Starting Saving Process in Existing File");
            saveExistingFile();
        } else if (n == CANCEL) {
            System.out.println("Process Cancelled");
        }
    }

    /**
     * Function which does the process of saving the information in a new file.
     */
    private void saveNewProcess() {

        creatingSheetEmptyFile();

        JFileChooser saver = new JFileChooser("C:\\Users\\migue\\OneDrive - University of Edinburgh\\EDINBURGH\\Alternative Ratings\\Project_ARX\\src\\Files_Resource\\Savings");
        saver.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = saver.showSaveDialog(saver);

        File path = saver.getSelectedFile();
        if (!path.getPath().endsWith(".xlsx")) {
            path = new File(saver.getSelectedFile() + ".xlsx");
        }

        try  {
            FileOutputStream outputStream = new FileOutputStream(path.getPath());
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatingSheetEmptyFile() {

        int rowCount = 0;

        Row initialRow = sheet.createRow(0);
        addCell(initialRow, -1, "Variable");
        addCell(initialRow, 0, "Value");


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

    }

    /**
     * Function which does the process of saving the information in an existing file.
     * It reads the documents and decide where and how to save it.
     */
    private void saveExistingFile() {
        chooseExistingFile();

        /** TODO COMPLETE THE READING PROCESS,
         *  DONE first read completely the file
         *  DONE    check if the number of variables input are the same to the number of rows
         *  DONE    check if all the rows have the same number of columns occupied
         *  DONE    return the number of columns if they are the same
         *      add only the numbers to the next column
         *
         */
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        //int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println("Iterator working");

        while (sheetIterator.hasNext()){
            sheet = (XSSFSheet) sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());

            int NumberOfRows = rowGetter(sheet);

            System.out.println("Rows: " + NumberOfRows);
            System.out.println(arrayInformation.size());

            if((sameNumberOfColumns(sheet)) && (NumberOfRows == arrayInformation.size() + 1)) {
                // TODO getThe number of columns
                int numberOfColumns = getNumberInitialColumns();
                System.out.println("There are " + numberOfColumns + " columns");

                addData(numberOfColumns);

            } else {
                System.err.println("The number of columns is not the same for all the rows");
            }
        }

    }
    /**
     * Function which is in charge of selecting the file where information will be written
     */
    private void chooseExistingFile()  {
        fileChooser = new JFileChooser("C:\\Users\\migue\\OneDrive - University of Edinburgh\\EDINBURGH\\Alternative Ratings\\Project_ARX\\src\\Files_Resource");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(fileChooser);


        file = fileChooser.getSelectedFile();



        if ((file == null) || (file.getName().equals(""))) {
            JOptionPane.showMessageDialog(fileChooser, "The name of the file is invalid", "The name of the file is invalid", JOptionPane.ERROR_MESSAGE);
        }

        assert file != null;
        path = Paths.get(file.getAbsolutePath());

        try {
            // TODO CHECK IF THIS WORKS
            // Workbook workbook = WorkbookFactory.create(file);
            workbook = (XSSFWorkbook) WorkbookFactory.create(file);
            System.out.println("Workbook correctly created!");


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    /**
     * Function in charge of extracting the information from an excel
     */
    private void informationSheetExtractor() {
        DataFormatter dataFormatter = new DataFormatter();
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

        Iterator<Row> rowIterator = sheet.rowIterator();
        int rowCount = 0;
        while (rowIterator.hasNext()) {
            rowCount ++;
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            int cellCount = 0;
            while (cellIterator.hasNext()) {
                cellCount++;
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }

            System.out.println();
            System.out.println("Number of cells: " + cellCount);
        }
        System.out.println("Number of rows: "+ rowCount);
    }
    /**
     * Function which reads the number of rows in a sheet of excel
     * @param sheet takes a sheet which will read
     * @return number of rows in a sheet
     */
    private int rowGetter(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        int rowCount = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            rowCount ++;
        }
        return rowCount;
    }
    /**
     * Function which returns the number of columns in a row
     * @param row takes the row that will read
     * @return the number of occupied cells in the row
     */
    private int columnGetter(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        int cellCount = 0;
        while (cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            cellCount++;
        }
        return cellCount;
    }
    /**
     * Function which checks if there are rows with different number of columns
     * @param sheet takes the sheet that wants to be checked
     * @return a boolean value being true if all the rows have the same number of columns
     */
    private boolean sameNumberOfColumns(Sheet sheet) {
        boolean isTrue = true;

        Iterator<Row> rowIterator = sheet.rowIterator();

        Row initialRow = sheet.getRow(0);
        int columnReference = columnGetter(initialRow);

        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (columnReference != columnGetter(row)) {
                isTrue = false;
            }
        }

        return isTrue;
    }
    /**
     * This is a function to add cells and content to the sheet
     * @param row it takes the row where the information will be written
     * @param columnCount takes the position where the information will be written in the row
     * @param element takes the String with the information that finally will be written
     */
    private void addCell(Row row, int columnCount, String element) {
        Cell cell = row.createCell(++columnCount);
        if (pattern.matcher(element.strip()).matches()) {
            double number = Double.parseDouble(element.strip());
            cell.setCellValue((Double) number);
        }
        else if (element instanceof String) {
            cell.setCellValue((String) element);
        }

    }
    /**
     * Function which returns the value of columns just in the first row of the sheet
     * @return the number of columns
     */
    private int getNumberInitialColumns() {
        Iterator<Row> rowIterator = sheet.rowIterator();

        Row initialRow = rowIterator.next();
        return columnGetter(initialRow);
    }

    private void addData(int numberOfColumns) {
        Row initialRow = sheet.getRow(0);
        System.out.println(sheet.getSheetName());
        Cell cell = initialRow.createCell(numberOfColumns);
        String element = "2";
        if (pattern.matcher(element.strip()).matches()) {
            double number = Double.parseDouble(element.strip());
            cell.setCellValue((Double) number);
        }
        else if (element instanceof String) {
            cell.setCellValue((String) element);
        }
        /**
        Iterator<Row> rowIterator = sheet.rowIterator();
        int counter = 0;
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            addCell(row, numberOfColumns, arrayInformation.get(counter).get(1));
            counter++;
        }*/
    }

}
