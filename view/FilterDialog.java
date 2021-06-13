package view;

import utility.*;

import java.awt.Component;
import java.awt.Font;
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
        search.setText("Search");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Set Text
        foodgroupLabel.setFont(new Font("Tahoma", 0, 14));
        foodgroupLabel.setText("Food Group");

        nameLabel.setFont(new Font("Tahoma", 0, 14));
        nameLabel.setText("Name");

        dateLabel.setFont(new Font("Tahoma", 0, 14));
        dateLabel.setText("Date");

        drinkLabel.setFont(new Font("Tahoma", 0, 14));
        drinkLabel.setText("Drink");

        dayLabel.setFont(new Font("Tahoma", 0, 14));
        dayLabel.setText("Day");

        //ComboBox
        foodgroupComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"NONE", "FRUIT", "VEGETABLE", "GRAIN", "PROTEIN", "DAIRY"}));
        dayComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"NONE", "BREAKFAST", "LUNCH", "DINNER"}));

        //Swing UI Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(drinkLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foodgroupLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(foodgroupComboBox, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent((Component) date, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(drink, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(foodgroupLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodgroupComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent((Component) date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel)
                    .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(drinkLabel)
                    .addComponent(drink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        // Set the icon
        setIconImage(new ImageIcon("./resource/logo.png").getImage());

        pack();
        getRootPane().setDefaultButton(search);
        setTitle("Filter");
        setResizable(false);
        setModalityType(ModalityType.APPLICATION_MODAL);
    }
}
