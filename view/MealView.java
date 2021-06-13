package view;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import utility.DateLabelFormatter;
import utility.ImageFileFilter;

import java.util.Properties;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

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

        // Image
        image.setFont(new Font("Tahoma", 0, 18));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setText("Upload Image");
        image.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

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
        image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(drinkLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foodgroupLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(day, GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(save, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addComponent(foodGroup)
                    .addComponent((Component) date)
                    .addComponent(drink)
                    .addComponent(image, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addComponent(delete, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(image, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(foodgroupLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodGroup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent((Component) date, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(drinkLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(drink, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(save, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        // Set the icon
        setIconImage(new ImageIcon("./resource/logo.png").getImage());

        pack();
        setTitle("Login");
        setResizable(false);
        setVisible(true);
    }

    public void addListener(MealViewListener mealViewListener) {
        this.mealViewListener = mealViewListener;
    }

    private void handleFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new ImageFileFilter()); // accepts image file only
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println("Chosen file path: " + imagePath);
        Image imageData = new ImageIcon(imagePath).getImage();
        int scaledWidth = (int)(imageData.getWidth(null) * ((float)image.getHeight() / imageData.getHeight(null)));
        ImageIcon scaledImageIcon = new ImageIcon(imageData.getScaledInstance(scaledWidth, image.getHeight(), Image.SCALE_SMOOTH));
        image.setText("");
        image.setBorder(null);
        image.setIcon(scaledImageIcon);

        mealViewListener.onImageChanged(imagePath);
    }
}