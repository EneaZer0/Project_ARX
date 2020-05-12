package MAINGUI;

import MAINGUI.PANEL_CONSOLE.Panel_Console;
import MAINGUI.PANEL_LOWER.Panel_Lower;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //////// Declaration of Elements Used ////////
    /**
     * JTextArea used to display the information that has been extracted from the file, also used as a console to output information
     */
    private Panel_Console consolePanel;


    private Panel_Lower lowerPanel;

    public MainFrame() {
        super("Alternative Ratings");

        consolePanel = new Panel_Console();


        setLayout(new BorderLayout());

        lowerPanel = new Panel_Lower();
        lowerPanel.setTypeDocEventListener(new TypeDocEventListener() {
            @Override
            public void typeDocEventOccurred(TypeDocEvent event) {
                String path = event.getPath();
                String fond = event.getFond();
                String fondType = event.getTypeFond();
                consolePanel.appendText("Path: " + path + "\nFond: " + fond + "\nType of Document: " + fondType);
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
