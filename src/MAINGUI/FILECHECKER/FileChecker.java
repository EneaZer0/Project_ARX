package MAINGUI.FILECHECKER;

import MAINGUI.CONSTANTS.FOND_ID;
import MAINGUI.CONSTANTS.String_Constants;
import MAINGUI.PANEL_CONSOLE.Panel_Console;
import MAINGUI.StringListenerMain;
import MAINGUI.TypeDocEvent;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileChecker {

    private Panel_Console consolePanel;
    private File file;
    private String_Constants string;
    private Path path;

    private TypeDocEvent event;

    private int fondId;
    private int typeFondId;

    private StringListenerMain stringListenerMain;



    public FileChecker(Panel_Console consolePanel, File file, Path path, String_Constants string, TypeDocEvent event) {

        this.consolePanel = consolePanel;
        this.file = file;
        this.string = string;
        this.path = path;
        this.event = event;

        this.fondId = this.event.getFondId();
        this.typeFondId = this.event.getTypeFondId();

    }

    /**
     * Function which checks if the input text path is empty
     */
    public void emptyFile() {
        if (path.toString().isEmpty()) {
            throw new NullPointerException(string.not_path_input + "\n");
        }
    }

    public void fileExists() {
        if (file.exists()) {

            consolePanel.appendToPane(consolePanel.console, string.ntab + string.file_exists, Color.GREEN);
            newBlackLine();

        } else  {
            throw new NullPointerException(string.not_existing_file);
        }
    }


    public void fileEndingPath() {
        if (path.toString().endsWith(string.good_ending_format)) {
            consolePanel.appendToPane(consolePanel.console, string.ntab + string.correct_format, Color.GREEN);
            newBlackLine();

        } else {
            badFormatPath();
        }
    }

    /**
     * Function which checks if the ending format of the path is correct
     */
    private void badFormatPath() {
        String stringPath = path.toString();
        String[] array = stringPath.split("\\.");
        throw new IllegalArgumentException(string.input_file_format + array[array.length - 1] + string.ntab + string.expected_format);
    }

    /**
     * Function used after any kind of output to create a new blank line
     */
    private void newBlackLine() {
        consolePanel.appendToPane(consolePanel.console, "\n" , Color.BLACK);
    }




    public void fileTypeDocConfiguration() {
        ArrayList<Integer> numOfNumbers = setSwitchNumberOfNumber();


    }

    private ArrayList<Integer> setSwitchNumberOfNumber(){
        ArrayList<Integer> numOfNumbers;
        switch (fondId) {

            case FOND_ID.AnaCap:
                numOfNumbers  = new ArrayList<>();
                numOfNumbers.add(FOND_ID.AnaCap_Number);
                return numOfNumbers;

            case FOND_ID.BTC_TREA:
                numOfNumbers = new ArrayList<>();
                numOfNumbers.add(FOND_ID.BBC_TREA_Number_2_column);
                numOfNumbers.add(FOND_ID.BBC_TREA_Number_3_column);
                return numOfNumbers;

            case FOND_ID.Headway:
                numOfNumbers = new ArrayList<>();
                numOfNumbers.add(FOND_ID.Headway_Number);
                return numOfNumbers;

            case FOND_ID.Khronos:
                numOfNumbers = new ArrayList<>();
                numOfNumbers.add(FOND_ID.Khronos_Number);
                return numOfNumbers;

            default:
                System.err.println("Fond index error");
                return null;
        }
    }

}
