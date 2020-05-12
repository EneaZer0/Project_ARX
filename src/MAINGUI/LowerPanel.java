package MAINGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LowerPanel extends JPanel {

    /**
     * JButton used to start the process of extraction
     */
    private JButton startButton;

    private JComboBox fondBox;

    private JComboBox fondTypeBox;


    public LowerPanel() {

        Dimension dimension = getPreferredSize();
        dimension.height = 250;
        setPreferredSize(dimension);

        startButton = new JButton("Start Extraction");
        startButton.setPreferredSize(new Dimension(125,25));

        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setFondBox();

        setFondTypeBox();

        layoutComponents();
    }

    private void setFondBox() {
        // Set up of type list box
        fondBox = new JComboBox();

        DefaultComboBoxModel fondOfExtractorsModel = new DefaultComboBoxModel();

        fondOfExtractorsModel.addElement(new ReaderCategory(0, "AnaCap"));
        fondOfExtractorsModel.addElement(new ReaderCategory(1, "BTC TREA"));
        fondOfExtractorsModel.addElement(new ReaderCategory(2, "Headway"));
        fondOfExtractorsModel.addElement(new ReaderCategory(3, "Khronos"));


        fondBox.setModel(fondOfExtractorsModel);

        fondBox.setPreferredSize(new Dimension(100, 25));
        fondBox.setBorder(BorderFactory.createEtchedBorder());
        fondBox.setSelectedIndex(0);

    }

    private void setFondTypeBox() {
        fondTypeBox = new JComboBox();

        DefaultComboBoxModel typeFondExtractorModel = new DefaultComboBoxModel();

        typeFondExtractorModel.addElement(new ReaderCategory(0, "Capital Call"));
        typeFondExtractorModel.addElement(new ReaderCategory(1, "Statement"));

        fondTypeBox.setModel(typeFondExtractorModel);

        fondTypeBox.setPreferredSize(new Dimension(100, 25));
        fondTypeBox.setBorder(BorderFactory.createEtchedBorder());
        fondTypeBox.setSelectedIndex(0);

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
        gridBagConstraints.insets = new Insets(0, 30, 0, 0);
        add(fondBox, gridBagConstraints);

        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(fondTypeBox, gridBagConstraints);

        gridBagConstraints.weightx = 2;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 30);
        gridBagConstraints.gridx = 2;
        add(startButton, gridBagConstraints);
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