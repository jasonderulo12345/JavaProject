package view;

import utility.*;

import java.awt.Component;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class FilterDialog extends JDialog {
    //Variable Declaration
    private JLabel nameLabel;
    private JLabel foodgroupLabel;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JLabel drinkLabel;
    public JButton search;
    public JTextField name;
    public JDatePicker date;
    public JTextField drink;
    public JComboBox<String> foodgroupComboBox;
    public JComboBox<String> dayComboBox;

    public void initUI() {

        //Label
        nameLabel = new JLabel();
        foodgroupLabel = new JLabel();
        dateLabel = new JLabel();
        dayLabel = new JLabel();
        drinkLabel = new JLabel();

        //TextField
        name = new JTextField();
        drink = new JTextField();

        //Setting up date picker
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        date = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        //ComboBox
        foodgroupComboBox = new JComboBox<>();
        dayComboBox = new JComboBox<>();

        //Button
        search = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Set Text
        nameLabel.setText("Name:");
        foodgroupLabel.setText("Food Group:");
        dateLabel.setText("Date:");
        dayLabel.setText("Day:");
        drinkLabel.setText("Drink:");
        search.setText("Search");

        //ComboBox
        foodgroupComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"NONE", "FRUIT", "VEGETABLE", "GRAIN", "PROTEIN", "DAIRY"}));
        dayComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"NONE", "BREAKFAST", "LUNCH", "DINNER"}));

        //Swing UI Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(search)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addGap(48, 48, 48)
                            .addComponent(name, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(foodgroupLabel)
                                .addComponent(dateLabel)
                                .addComponent(dayLabel)
                                .addComponent(drinkLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(foodgroupComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent((Component) date)
                                .addComponent(dayComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(drink)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(foodgroupLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodgroupComboBox))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent((Component) date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(drinkLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(drink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setResizable(false);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }
}
