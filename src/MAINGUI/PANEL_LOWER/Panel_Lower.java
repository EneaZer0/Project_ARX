package MAINGUI.PANEL_LOWER;

import MAINGUI.CleanTerminalListener;
import MAINGUI.TypeDocEvent;
import MAINGUI.TypeDocEventListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Lower extends JPanel {

    /**
     * JButton used to start the process of extraction
     */
    private JButton startButton;
    private JButton cleanTerminalButton;

    private TypeDocEventListener typeDocEventListener;
    private CleanTerminalListener cleanTerminalListener;

    public Panel_Lower_Left panel_lower_left;



    public Panel_Lower() {

        Dimension dimension = getPreferredSize();
        dimension.height = 250;
        setPreferredSize(dimension);

        panel_lower_left = new Panel_Lower_Left();

        startButton = new JButton("Start Extraction");
        startButton.setPreferredSize(new Dimension(125,25));

        cleanTerminalButton = new JButton("Clean Terminal");
        cleanTerminalButton.setPreferredSize(new Dimension(125,25));

        pressingStartButton();

        pressingCleanButton();

        //layoutComponents();
        layoutBoxes();
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
                    clearTextInputs();
                }

            }
        });
    }

    private void pressingCleanButton() {
        cleanTerminalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cleanTerminalListener != null) {
                    cleanTerminalListener.cleanTerminalButtonPressed();
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

        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 30);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 1;
        add(cleanTerminalButton, gridBagConstraints);
    }

    private void layoutBoxes() {

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(200,250));

        setLayout(new BorderLayout());

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);

        left.add(panel_lower_left);
        Border boder = BorderFactory.createEmptyBorder(100,5,5,5);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        right.setBorder(boder);
        right.add(startButton, flowLayout);
        right.add(cleanTerminalButton, flowLayout);
    }


    public void setTypeDocEventListener(TypeDocEventListener listener) {
        this.typeDocEventListener = listener;
    }

    public void setCleanTerminalButtonListner(CleanTerminalListener listner) {
        this.cleanTerminalListener = listner;
    }

    private void clearTextInputs(){
        panel_lower_left.pathInput.setText("");
        panel_lower_left.fondBox.setSelectedIndex(0);
        panel_lower_left.fondTypeBox.setSelectedIndex(0);
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