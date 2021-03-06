package MAINGUI;

import MAINGUI.CONSTANTS.FOND_ID;
import MAINGUI.FILECHECKER.FileChecker;
import MAINGUI.CONSTANTS.Commands;
import MAINGUI.CONSTANTS.String_Constants;
import MAINGUI.PANEL_CONSOLE.Panel_Console;
import MAINGUI.PANEL_CONSOLE.Panel_Console_Input;
import MAINGUI.PANEL_LOWER.Panel_Lower;
import READERS.AnaCap.AnaCap_CCN_DOC;
import READERS.BTC_TREA.BTC_TREA_CAS_DOC;
import READERS.BTC_TREA.BTC_TREA_Capital_Call_Notice_DOC;
import READERS.Khronos.Khronos_Capital_Call;
import READERS.Khronos.Khronos_Statement;
import WRITER.Generic_Writer;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;


public class MainFrame extends JFrame {

    //////// Declaration of Elements Used ////////
    /**
     * It creates an object where all the information is displayed
     */
    private Panel_Console consolePanel;
    /**
     * It creates the terminal part where the user can type in commands
     */
    private Panel_Console_Input consoleInput;
    /**
     * creates the variable that contains all the string information of the program
     */
    private String_Constants string;
    /**
     * Creates the JPanel placed in the bottom of the GUI
     */
    private Panel_Lower lowerPanel;
    /**
     * Variable used to store the input path
     */
    private Path path;
    /**
     * Variable to check if the input file is valid
     */
    private FileChecker fileChecker;
    /**
     * Variable to differentiate the types of documents
     */
    private TypeDocEvent typeDocEvent;
    /**
     * Creates the object necessary to save and write all the information
     */
    private Generic_Writer generic_writer;

    /**
     * Constructor of the Frame, it set the communication between all the Panels of the program
     *      ** Will set the language
     *      Set the console Panel
     *      Sets the lower Panel
     *      Sets the general configuration of the frame
     */
    public MainFrame() {
        super("Alternative Ratings");
        string = new String_Constants(Commands.ENGLISH);

        consolePanel = new Panel_Console();

        consoleInput = new Panel_Console_Input();
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
        consoleInput.setStringListenerMain(new StringListenerMain() {
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
                typeDocEvent = event;
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
            fileChecker = new FileChecker(consolePanel, file, path, string, typeDocEvent);

            fileChecker.emptyFile();

            fileChecker.fileExists();

            fileChecker.fileEndingPath();

            readFile();

            fileChecker.fileTypeDocConfiguration();



        } catch (NullPointerException e) {
            consolePanel.appendToPane(consolePanel.console,string.ntab + string.null_error + e.getMessage(), Color.RED );
            newBlackLine();

        } catch (IllegalArgumentException e) {
            consolePanel.appendToPane(consolePanel.console, string.ntab + string.illegal_error + e.getMessage(), Color.RED);
            newBlackLine();
        }

    }




    /**
     * Function to organize all the adding process to the frame
     */
    private void addFunction() {

        JPanel Console = new JPanel();
        Console.setLayout(new BorderLayout());

        Console.add(consolePanel, BorderLayout.CENTER);
        Console.add(consoleInput, BorderLayout.SOUTH);

        add(Console, BorderLayout.CENTER);
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

    /**
     * Function where all commands are defined. Check if the input of the Terminal and executes the command if it is
     * @param text is the input from the terminal
     */
    private void commandChecker(String text) {

        switch (text) {
            case Commands.HELP:
                consolePanel.appendToPane(consolePanel.console,  string.ntab + Commands.HELP_OUTPUT, Color.BLUE);
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
                consolePanel.appendToPane(consolePanel.console,  string.ntab + Commands.HELP_CLEAR, Color.BLUE);
                newBlackLine();
                break;

            case Commands.LANGUAGE + " " + Commands.ENGLISH:
                string = new String_Constants(Commands.ENGLISH);
                consolePanel.appendToPane(consolePanel.console,   string.ntab + "Language set to English.", Color.BLUE);
                newBlackLine();
                break;

            case Commands.LANGUAGE + " " + Commands.SPANISH:
                string = new String_Constants(Commands.SPANISH);
                consolePanel.appendToPane(consolePanel.console,  string.ntab + "Idioma cambiado a Español.", Color.BLUE);
                newBlackLine();
                break;

            default:
                if (!text.isEmpty() || !text.isBlank()){
                    consolePanel.appendToPane(consolePanel.console,  string.ntab + string.commandNotFound+ text, Color.RED);
                }
                newBlackLine();
                break;
        }

    }

    /**
     * Function used after any kind of output to create a new blank line
     */
    private void newBlackLine() {
        consolePanel.appendToPane(consolePanel.console, "\n" , Color.BLACK);
    }

    /**
     * This is the function which reads the files depending on the file and type
     */
    public void readFile() {
        switch (typeDocEvent.getFondId()) {

            case FOND_ID.AnaCap:

                switch (typeDocEvent.getTypeFondId()) {

                    case FOND_ID.Statement:

                        AnaCap_CCN_DOC anaCap_ccn_doc = new AnaCap_CCN_DOC(path, string);
                        consolePanel.appendToPane(consolePanel.console, anaCap_ccn_doc.getString_all_info(), Color.BLUE);
                        newBlackLine();
                        informationSender(anaCap_ccn_doc.getString_all_info());
                        break;

                    case FOND_ID.Capital_Call:
                        consolePanel.appendToPane(consolePanel.console, string.ntab+ "There is not AnaCap model for Capital Calls", Color.RED);
                        newBlackLine();
                        // TODO IMPLEMENT THE INFORMATION SAVER FOR CAPITAL CALL FOR ANACAP
                        informationSender(null);
                        break;
                }
                break;

            case FOND_ID.BTC_TREA:

                switch (typeDocEvent.getTypeFondId()) {

                    case FOND_ID.Capital_Call:

                        BTC_TREA_Capital_Call_Notice_DOC btc_trea_capital_call_notice_doc = new BTC_TREA_Capital_Call_Notice_DOC(path, string);
                        consolePanel.appendToPane(consolePanel.console, btc_trea_capital_call_notice_doc.getString_all_info(), Color.BLUE);
                        informationSender(btc_trea_capital_call_notice_doc.getString_all_info());
                        break;

                    case FOND_ID.Statement:
                        BTC_TREA_CAS_DOC btc_trea_cas_doc = new BTC_TREA_CAS_DOC(path, string);
                        consolePanel.appendToPane(consolePanel.console, btc_trea_cas_doc.getString_all_info(), Color.BLUE);
                        informationSender(btc_trea_cas_doc.getString_all_info());
                        break;
                }
                break;

            case FOND_ID.Headway:
                consolePanel.appendToPane(consolePanel.console, string.ntab+ "The is not Headways models yet", Color.RED);
                // TODO IMPLEMENT THE INFORMATION SAVER FOR HEADWAY
                informationSender(null);
                break;

            case FOND_ID.Khronos:

                switch (typeDocEvent.getTypeFondId()) {

                    case FOND_ID.Capital_Call:
                        Khronos_Capital_Call khronos_capital_call = new Khronos_Capital_Call(path, string);
                        consolePanel.appendToPane(consolePanel.console, khronos_capital_call.getString_all_info(), Color.BLUE);
                        informationSender(khronos_capital_call.getString_all_info());
                        break;

                    case FOND_ID.Statement:
                        Khronos_Statement khronos_statement = new Khronos_Statement(path, string);
                        consolePanel.appendToPane(consolePanel.console, khronos_statement.getString_all_info(), Color.BLUE);
                        informationSender(khronos_statement.getString_all_info());
                        break;
                }
                break;

            default:
                consolePanel.appendToPane(consolePanel.console, "ERROR: THE FOND SELECTED DOES NOT EXIST", Color.RED);
        }
    }

    /**
     * This is a function which is in charge of starting the process of saving the information
     * @param information
     */
    private void informationSender(String information) {
        generic_writer = new Generic_Writer(information);
    }
}
