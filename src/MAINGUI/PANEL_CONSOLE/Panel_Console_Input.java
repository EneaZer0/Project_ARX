package MAINGUI.PANEL_CONSOLE;

import MAINGUI.StringListenerMain;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel_Console_Input extends JPanel {

    public JTextPane consoleInput;

    /**
     * Variable to send the inputs in the Terminal to the MainFrame
     */
    private StringListenerMain stringListenerMain;

    public Panel_Console_Input() {
        consoleInput = new JTextPane();
        consoleInput.setEnabled(true);

        setLayout(new BorderLayout());

        borderSettings();

        add(consoleInput, BorderLayout.CENTER);
        pressEnter();
    }

    private void pressEnter() {
        consoleInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String content = null;
                    try {
                        content = consoleInput.getDocument().getText(0, consoleInput.getDocument().getLength()).strip();
                        if (!content.isBlank() && !content.isEmpty()) {
                            String[] data = content.split("\n");
                            //System.out.println(Arrays.toString(data));
                            //content = data[data.length-2];
                        }

                        cleanText();


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

    public void cleanText() {
        consoleInput.setText(null);
    }

    public void setStringListenerMain (StringListenerMain listener) {
        this.stringListenerMain = listener;
    }
}
