package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;

    public GUI() {

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
