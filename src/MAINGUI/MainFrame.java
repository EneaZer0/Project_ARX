package MAINGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //////// Declaration of Elements Used ////////
    /**
     * JTextArea used to display the information that has been extracted from the file, also used as a console to output information
     */
    private ConsolePanel consolePanel;


    private LowerPanel lowerPanel;

    public MainFrame() {
        super("Alternative Ratings");

        consolePanel = new ConsolePanel();


        setLayout(new BorderLayout());

        lowerPanel = new LowerPanel();

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
