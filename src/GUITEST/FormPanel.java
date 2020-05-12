package GUITEST;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupetionLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okButton;


    private FormListener formListener;

    private JList ageList;

    private JComboBox employmentCombo;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupetionLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        employmentCombo = new JComboBox();


        // Set up of list box
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110,70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);


        // Set up of combo box
        DefaultComboBoxModel employmentModel = new DefaultComboBoxModel();
        employmentModel.addElement("employed");
        employmentModel.addElement("self-employed");
        employmentModel.addElement("unemployed");
        employmentCombo.setModel(employmentModel);

        okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String name = nameField.getText();
            String occupation = occupationField.getText();
            AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
            String employmentCat = (String) employmentCombo.getSelectedItem();

            System.out.println(employmentCat);

            FromEvent event = new FromEvent(this, name, occupation, ageCat.getId(), employmentCat);

            if (formListener != null) {
                formListener.formEventOccurred(event);
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        ////////////// First row ////////////////////
        gridBagConstraints.gridy = 0;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;

        gridBagConstraints.gridx = 0;

        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.anchor = GridBagConstraints.LINE_END;

        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        add(nameField, gridBagConstraints);


        ////////////// Next row ////////////////////

        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.1;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        add(occupetionLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gridBagConstraints);

        /////////////// Next row ///////////////////

        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.2;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Age: "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        add(ageList, gridBagConstraints);

        /////////////// Next row ///////////////////

        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.2;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Employment: "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        add(employmentCombo, gridBagConstraints);

        /////////////// Next row ///////////////////

        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 2.0;

        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, gridBagConstraints);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

}

class AgeCategory {

    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
}
