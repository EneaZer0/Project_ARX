package MAINGUI;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel {

    public JTextArea console;

    public ConsolePanel() {

        console = new JTextArea();
        console.setEditable(false);

        setLayout(new BorderLayout());

        add(new JScrollPane(console), BorderLayout.CENTER);
    }
}
