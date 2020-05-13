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
        //console.setEditable(false);

        pressEnter();

        setLayout(new BorderLayout());

        borderSettings();

        add(new JScrollPane(console), BorderLayout.CENTER);
    }

    private void pressEnter() {
        console.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String content = null;
                    try {
                        content = console.getDocument().getText(0, console.getDocument().getLength());
                        if (!content.isBlank()) {
                            String[] data = content.split("\n");
                            //System.out.println(Arrays.toString(data));
                            content = data[data.length-1];
                        }


                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                    //System.out.println(content);

                    if (stringListenerMain != null) {
                        stringListenerMain.textEmitted(content);
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
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
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

    public void cleanText() {
        console.setText(null);
    }

    public void setStringListenerMain (StringListenerMain listener) {
        this.stringListenerMain = listener;
    }

}
