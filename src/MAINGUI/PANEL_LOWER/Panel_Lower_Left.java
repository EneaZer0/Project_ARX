package MAINGUI.PANEL_LOWER;

import MAINGUI.TypeDocEventListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel_Lower_Left extends JPanel {

    protected JComboBox fondBox;

    protected JComboBox fondTypeBox;

    protected JLabel pathLabel;
    protected JTextField pathInput;

    public TypeDocEventListener typeDocEventListener;


    Insets noinsets;
    Insets left_5;
    Insets right_5;
    Insets left_10;
    Insets right_10;


    public Panel_Lower_Left() {

        Dimension dimension = getPreferredSize();
        dimension.width = 350;
        dimension.height = 240;
        setPreferredSize(dimension);


        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setInsets();

        setPath();

        setFondBox();

        setFondTypeBox();

        setLayout();
    }

    private void setInsets() {

        noinsets = new Insets(0,0,0,0);
        left_5 = new Insets(0,5,0,0);
        right_5 = new Insets(0,0,0, 5);
        left_10 = new Insets(0,10,0,0);
        right_10 = new Insets(0,0,0, 10);

    }

    private void setPath() {
        pathLabel = new JLabel("Path: ");
        pathInput = new JTextField(10);



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

    private void setLayout() {

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.NONE;



        ///////////// First Line /////////////

        int y = 0;

        // ____________ Path Label ___________
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;

        gridOrganizer(pathLabel, gridBagConstraints, y,0, right_5, GridBagConstraints.LINE_END);


        // ____________ Path Input ___________

        gridOrganizer(pathInput, gridBagConstraints, y,1, noinsets, GridBagConstraints.LINE_START);


        //////////// Second Line /////////////

        y++;
        gridBagConstraints.weighty = 0.5;
        gridOrganizer(fondBox, gridBagConstraints, y,0, right_10, GridBagConstraints.FIRST_LINE_END);


        gridOrganizer(fondTypeBox, gridBagConstraints, y,1, left_5, GridBagConstraints.FIRST_LINE_START);


    }

    private void gridOrganizer(Object element, GridBagConstraints gridBagConstraints, int y, int x, Insets insets, int anchor) {

        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;



        gridBagConstraints.anchor = anchor;

        gridBagConstraints.insets = insets;

        add((Component) element, gridBagConstraints);

    }

    public String combogetter( JComboBox comboBox) {
        return (String) comboBox.getSelectedItem();
    }
}
