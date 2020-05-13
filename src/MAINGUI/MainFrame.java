package MAINGUI;

import MAINGUI.LanguagePack.Commands;
import MAINGUI.LanguagePack.Strings_eng;
import MAINGUI.PANEL_CONSOLE.Panel_Console;
import MAINGUI.PANEL_LOWER.Panel_Lower;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;


public class MainFrame extends JFrame {

    //////// Declaration of Elements Used ////////
    /**
     * JTextPane used to display the information that has been extracted from the file, also used as a console to output information
     */
    private Panel_Console consolePanel;
    /**
     * creates the variable that contains all the string information of the program
     */
    private Strings_eng string;
    /**
     * Creates the JPanel placed in the bottom of the GUI
     */
    private Panel_Lower lowerPanel;
    /**
     * Variable used to store the input path
     */
    private Path path;

    /**
     * Constructor of the Frame, it set the communication between all the Panels of the program
     *      ** Will set the language
     *      Set the console Panel
     *      Sets the lower Panel
     *      Sets the general configuration of the frame
     */
    public MainFrame() {
        super("Alternative Ratings");
        string = new Strings_eng();

        consolePanel = new Panel_Console();
        consolePanelConfiguration();

        setLayout(new BorderLayout());

        lowerPanel = new Panel_Lower();
        lowerPanelConfiguration();

        addFunction();

        endFrame();
    }

    /**
     * Function which set the Configuration of the Console Panel
     *      Listener of information when input is entered in the Terminal
     */
    private void consolePanelConfiguration() {
        consolePanel.setStringListenerMain(new StringListenerMain() {
            @Override
            public void textEmitted(String text) {
                commandChecker(text);

            }
        });
    }

    /**
     * Function which set the Configuration of the Lower Panel
     *      Listener of the Path, Fond and Type of fond are set here
     *      listener of to Clean the terminal is also here
     */
    private void lowerPanelConfiguration(){
        lowerPanel.setTypeDocEventListener(new TypeDocEventListener() {
            @Override
            public void typeDocEventOccurred(TypeDocEvent event) {
                String str_path = event.getPath();
                String fond = event.getFond();
                String fondType = event.getTypeFond();
                consolePanel.appendText(string.ntab + string.path_str + str_path + string.ntab + string.fond_str + fond + string.ntab + string.fond_typed_doc_str + fondType + "\n");

                path = Path.of(str_path.trim());
                pathChecker();

                /*
                BTC_Paths paths_document = new BTC_Paths();
                BTC_TREA_CAS_DOC btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_09_30_CYGNUS_ALTERNATIVE_MASTER);
                consolePanel.appendText(btc_trea_cas_doc.getString_all_info());
                */

            }
        });

        lowerPanel.setCleanTerminalButtonListener(new CleanTerminalListener() {
            @Override
            public void cleanTerminalButtonPressed() {
                consolePanel.cleanText();
            }
        });
    }

    /**
     * Function in charge of the hole process of checking if the path input is valid for the data extraction
     */
    private void pathChecker() {

        try {
            File file = new File(String.valueOf(path));

            emptyFile();

            if (file.exists()) {

                consolePanel.appendToPane(consolePanel.console, string.ntab + string.file_exists, Color.GREEN);
                newBlackLine();

            } else  {
                throw new NullPointerException(string.not_existing_file);
            }

            if (path.toString().endsWith(string.good_ending_format)) {
                consolePanel.appendToPane(consolePanel.console, string.ntab + string.correct_format, Color.GREEN);
                newBlackLine();

            } else {
                badFormatPath();
            }

        } catch (NullPointerException e) {
            consolePanel.appendToPane(consolePanel.console,string.ntab + string.null_error + e.getMessage(), Color.RED );
            newBlackLine();

        } catch (IllegalArgumentException e) {
            consolePanel.appendToPane(consolePanel.console, string.ntab + string.illegal_error + e.getMessage(), Color.RED);
            newBlackLine();
        }

    }

    /**
     * Function which checks if the input text path is empty
     */
    private void emptyFile() {
        if (path.toString().isEmpty()) {
            throw new NullPointerException(string.not_path_input + "\n");
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
     * Function to organize all the adding process to the frame
     */
    private void addFunction() {

        add(consolePanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);

    }

    /**
     * Function to set the size and display the frame
     */
    private void endFrame() {
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void commandChecker(String text) {

        switch (text) {
            case Commands.HELP:
                consolePanel.appendToPane(consolePanel.console, "\n" + string.ntab + Commands.HELP_OUTPUT, Color.BLUE);
                newBlackLine();

                break;

            case  Commands.CLEAR:
                consolePanel.cleanText();

                break;

            case Commands.AR_GAME:
                consolePanel.appendToPane(consolePanel.console, string.coolAR, Color.BLUE);
                consolePanel.appendToPane(consolePanel.console, string.game, Color.RED);
                newBlackLine();

                break;

            case Commands.HELP + " " + Commands.CLEAR:
                consolePanel.appendToPane(consolePanel.console, "\n" + string.ntab + Commands.HELP_CLEAR, Color.BLUE);
                newBlackLine();
                break;

            default:
                newBlackLine();
                break;
        }

    }

    private void newBlackLine() {
        consolePanel.appendToPane(consolePanel.console, "\n" , Color.BLACK);
    }

}
