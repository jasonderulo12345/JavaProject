package view;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import utility.DateLabelFormatter;

import java.awt.event.*;
import java.util.Properties;
import java.awt.Component;
import java.awt.Font;

public class MealView extends JFrame {
    private MealViewListener mealViewListener;

    //Variable Declaration
    public JLabel title;
    public JLabel image;
    private JLabel nameLabel;
    private JLabel foodgroupLabel;
    private JLabel dateLabel;
    private JLabel dayLabel;
    private JLabel drinkLabel;
    public JTextField name;
    public JComboBox<String> foodGroup;
    public JDatePicker date;
    public JComboBox<String> day;
    public JTextField drink;    
    public JButton save;
    private JButton cancel;
    public JButton delete;

    public void initUI() {
        //Label
        title = new JLabel();
        nameLabel = new JLabel();
        foodgroupLabel = new JLabel();
        dateLabel = new JLabel();
        dayLabel = new JLabel();
        drinkLabel = new JLabel();
        image = new JLabel();

        //Date
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        date = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        //TextField
        name = new JTextField();
        foodGroup = new JComboBox<>();
        day = new JComboBox<>();
        drink = new JTextField();

        //Button
        save = new JButton();
        cancel = new JButton();
        delete = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Drop down
        foodGroup.setModel(new DefaultComboBoxModel<>(new String[] {"FRUIT", "VEGETABLE", "GRAIN", "PROTEIN", "DAIRY"} ));
        day.setModel(new DefaultComboBoxModel<>(new String[] {"BREAKFAST", "LUNCH", "DINNER"} ));

        //Title
        title.setFont(new Font("Tahoma", 0, 24)); // NOI18N 
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Meal Number 1");

        //Delete
        delete.setText("Delete");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mealViewListener.onDeleteButtonPressed();
            }
        });

        //Set Text
        nameLabel.setText("Name");
        foodgroupLabel.setText("Food Group");
        dateLabel.setText("Date");
        dayLabel.setText("Day");
        drinkLabel.setText("Drink");

        //Save
        save.setText("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mealViewListener.onSaveButtonPressed();
            }
        });

        //Cancel
        cancel.setText("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mealViewListener.onCancelButtonPressed();
            }
        });

        //Image
        image.setIcon(new ImageIcon("image path"));
        image.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (image.isEnabled()) { handleFile(); }
            }
        });

        //UI Swing Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(image, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(delete, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37))
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(drinkLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foodgroupLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodGroup, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
                                .addComponent((Component) date, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
                            .addComponent(day, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
                        .addComponent(drink, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(save, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(85, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(image, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(68, 68, 68)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(foodgroupLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(foodGroup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent((Component) date, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(day, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(dayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(drink, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(drinkLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(save, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29))
            );

        pack();
        setVisible(true);
    }

    public void addListener(MealViewListener mealViewListener) {
        this.mealViewListener = mealViewListener;
    }

    private void handleFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println("Chosen file path: " + imagePath);
        image.setIcon(new ImageIcon(imagePath));
    }
}