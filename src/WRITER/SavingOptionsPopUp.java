package WRITER;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SavingOptionsPopUp {

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

    /**
     * Constructor of SavingOptionsPopUp, this sets the POPUP options
     * @param workbook is the temporal excel file which will be saved later in a new or existing file
     * @param sheet is the page where in the excel file where the information will be written
     */
    public SavingOptionsPopUp(XSSFWorkbook workbook, XSSFSheet sheet) {
        optionPane = new JOptionPane();
        parent = new JFrame();

        this.workbook = workbook;
        this.sheet = sheet;


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

    /**
     * Function which does the process of saving the information in an existing file.
     * It reads the documents and decide where and how to save it.
     */
    private void saveExistingFile() {
        chooseExistingFile();


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
}
