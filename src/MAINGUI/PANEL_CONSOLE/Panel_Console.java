package MAINGUI.PANEL_CONSOLE;

import MAINGUI.StringListenerMain;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel_Console extends JPanel {

    /**
     * Variable that sets the Terminal;
     */
    public JTextPane console;
    /**
     * Variable to send the inputs in the Terminal to the MainFrame
     */
    private StringListenerMain stringListenerMain;

    /**
     * Constructor which sets the console
     */
    public Panel_Console() {

        console = new JTextPane();
        console.setEditable(false);



        setLayout(new BorderLayout());

        borderSettings();

        add(new JScrollPane(console), BorderLayout.CENTER);
    }



    private void borderSettings() {
        Border outside = BorderFactory.createTitledBorder("");
        Border inside = BorderFactory.createEmptyBorder(5,10,5,10);
        setBorder(BorderFactory.createCompoundBorder(outside,inside));
    }

    public void appendText(String text) {
        // console.append(text);
        appendToPane(console,text, Color.BLACK);
    }

    public void appendToPane(JTextPane tp, String msg, Color c) {
        console.setEditable(true);
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
        console.setEditable(false);
    }

    public void cleanText() {
        console.setText(null);
    }



}
