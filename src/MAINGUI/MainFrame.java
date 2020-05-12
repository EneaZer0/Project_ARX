package MAINGUI;

import MAINGUI.PANEL_CONSOLE.Panel_Console;
import MAINGUI.PANEL_LOWER.Panel_Lower;
import READERS.BTC_TREA.BTC_Paths;
import READERS.BTC_TREA.BTC_TREA_CAS_DOC;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class MainFrame extends JFrame {

    //////// Declaration of Elements Used ////////
    /**
     * JTextArea used to display the information that has been extracted from the file, also used as a console to output information
     */
    private Panel_Console consolePanel;

    private String tab;

    private Panel_Lower lowerPanel;

    private Path path;

    public MainFrame() {
        super("Alternative Ratings");

        consolePanel = new Panel_Console();

        tab = "     ";


        setLayout(new BorderLayout());

        lowerPanel = new Panel_Lower();
        lowerPanel.setTypeDocEventListener(new TypeDocEventListener() {
            @Override
            public void typeDocEventOccurred(TypeDocEvent event) {
                String strpath = event.getPath();
                String fond = event.getFond();
                String fondType = event.getTypeFond();
                consolePanel.appendText("\n" + tab + "Path: " + strpath + "\n" + tab + "Fond: " + fond + "\n" + tab + "Type of Document: " + fondType + "\n");

                BTC_Paths paths_document = new BTC_Paths();
                BTC_TREA_CAS_DOC btc_trea_cas_doc = new BTC_TREA_CAS_DOC(paths_document.BTC_TREA_SCA_SICAR_CAS_2019_09_30_CYGNUS_ALTERNATIVE_MASTER);
                consolePanel.appendText(btc_trea_cas_doc.getString_all_info());


            }
        });

        lowerPanel.setCleanTerminalButtonListner(new CleanTerminalListener() {
            @Override
            public void cleanTerminalButtonPressed() {
                consolePanel.cleanText();
            }
        });



        addFunction();

        endFrame();
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


}
