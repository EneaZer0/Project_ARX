package MAINGUI;

import javax.swing.*;
import java.awt.*;

public class MainGUI {

    public MainGUI() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MainFrame();

            }
        });


    }

}
