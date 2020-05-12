package MAINGUI.PANEL_LOWER;

import MAINGUI.StringListenerMain;
import MAINGUI.TypeDocEvent;
import MAINGUI.TypeDocEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Lower extends JPanel {

    /**
     * JButton used to start the process of extraction
     */
    private JButton startButton;

    private TypeDocEventListener typeDocEventListener;

    public Panel_Lower_Left panel_lower_left;



    public Panel_Lower() {

        Dimension dimension = getPreferredSize();
        dimension.height = 250;
        setPreferredSize(dimension);

        panel_lower_left = new Panel_Lower_Left();
        /*
        panel_lower_left.setTypeDocEvent(new TypeDocEventListener() {
            @Override
            public void typeDocEventOccurred(TypeDocEvent event) {
                String path = event.getPath();
                String fond = event.getFond();
                String typeFond = event.getTypeFond();

                information = "Path: " + path + ", Fond: " + fond + ", Type of Document: " + typeFond;
            }
        });

         */

        startButton = new JButton("Start Extraction");
        startButton.setPreferredSize(new Dimension(125,25));

        // Border innerBorder = BorderFactory.createTitledBorder("");
        // Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        // setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        pressingStartButton();

        layoutComponents();
    }


    private void pressingStartButton() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String path = panel_lower_left.pathInput.getText();
                String fond = panel_lower_left.fondBox.getSelectedItem().toString();
                String fondType = panel_lower_left.fondTypeBox.getSelectedItem().toString();

                String information = "Path: " + path + ", Fond: " + fond + ", Type of Document: " + fondType;

                System.out.println(information);

                TypeDocEvent event = new TypeDocEvent(this, path, fond, fondType);

                if (typeDocEventListener != null) {
                    typeDocEventListener.typeDocEventOccurred(event);
                }

            }
        });
    }


    private void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //_____________ Fist line ___________ //

        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(panel_lower_left, gridBagConstraints);

        gridBagConstraints.weightx = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 30);
        gridBagConstraints.gridx = 1;
        add(startButton, gridBagConstraints);
    }

    public void setTypeDocEventListener(TypeDocEventListener listener) {
        this.typeDocEventListener = listener;
    }

}

class ReaderCategory {

    private int id;
    private String type;

    public ReaderCategory(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public int getId() {
        return id;
    }
}