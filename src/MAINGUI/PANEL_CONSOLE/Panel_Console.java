package MAINGUI.PANEL_CONSOLE;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel_Console extends JPanel {

    public JTextArea console;

    public Panel_Console() {

        console = new JTextArea();
        //console.setEditable(false);

        setLayout(new BorderLayout());

        Border outside = BorderFactory.createTitledBorder("");
        Border inside = BorderFactory.createEmptyBorder(5,10,5,10);
        setBorder(BorderFactory.createCompoundBorder(outside,inside));

        add(new JScrollPane(console), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        console.append(text);
    }

    public void cleanText() {
        console.setText(null);
    }
}
