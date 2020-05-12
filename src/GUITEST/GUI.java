package GUITEST;

import javax.swing.*;

public class GUI {

    public GUI() {

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
