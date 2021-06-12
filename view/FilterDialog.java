package view;
import javax.swing.*;

public class FilterDialog extends JFrame {
    //Variable Declaration
    private JLabel nameLabel;
    private JLabel foodgroupLabel;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JLabel drinkLabel;
    private JButton Search;
    private JTextField name;
    private JTextField date;
    private JTextField drink;
    private JComboBox<String> foodgroupComboBox;
    private JComboBox<String> dayComboBox;

    public void initUI() {
        //Label
        nameLabel = new JLabel();
        foodgroupLabel = new JLabel();
        dateLabel = new JLabel();
        dayLabel = new JLabel();
        drinkLabel = new JLabel();

        //TextField
        name = new JTextField();
        date = new JTextField();
        drink = new JTextField();

        //ComboBox
        foodgroupComboBox = new JComboBox<>();
        dayComboBox = new JComboBox<>();

        //Button
        Search = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Set Text
        nameLabel.setText("Name:");
        foodgroupLabel.setText("Food Group:");
        dateLabel.setText("Date:");
        dayLabel.setText("Day:");
        drinkLabel.setText("Drink:");
        Search.setText("Search");

        //ComboBox
        foodgroupComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Fruit", "Item 2", "Item 3", "Item 4" }));
        dayComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Breakfast", "Item 2", "Item 3", "Item 4" }));

        //Swing UI Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(Search)
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
                                .addComponent(date)
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
                    .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(drinkLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(drink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}