package WRITER;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class SavingOptionsPopUp {

    private JOptionPane optionPane;
    private JFrame parent;

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private final int SAVE_AS_NEW_FILE = 0;
    private final int SAVE_AS_EXISTING_FILE= 1;
    private final int CANCEL = 2;

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

    private void saveExistingFile() {

    }
}
