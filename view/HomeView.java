package view;

import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomeView extends JFrame {
    private HomeViewListener homeViewListener;

    private JLabel title;
    private JButton addMeal;
    private JButton deleteMeal;
    private JButton editMeal;
    private JButton logout;
    private JButton viewMeal;
    private JTextField searchBar;
    private JComboBox<String> filterBox;
    private JScrollPane jScrollPane1; //idk apa ni
    public JTable mealTable;

    public HomeView() {

    }

    public void initUI() {
        //Label
        title = new JLabel();

        //Button
        logout = new JButton();
        addMeal = new JButton();
        deleteMeal = new JButton();
        editMeal = new JButton();
        viewMeal = new JButton();

        //ComboBox
        filterBox = new JComboBox<>();

        //TextField
        searchBar = new JTextField();

        //ScrollPanel
        jScrollPane1 = new JScrollPane();

        //Table
        mealTable = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Title
        title.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Home Menu");

        //FilterBox
        filterBox.setModel(new DefaultComboBoxModel<>(new String[] { "Filter", "Item 2", "Item 3", "Item 4" }));

        //Set text
        searchBar.setText("SearchBar");
        
        logout.setText("Logout");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                homeViewListener.onLogoutButtonPressed();
            }
        });

        addMeal.setText("Add Meal");
        addMeal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                homeViewListener.onAddMealPressed();
            }
        });

        deleteMeal.setText("Delete Meal");
        deleteMeal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                homeViewListener.onDeleteMealPressed();
            }
        });

        editMeal.setText("Edit Meal");
        editMeal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                homeViewListener.onEditMealPressed();
            }
        });

        viewMeal.setText("View Meal");
        viewMeal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {               
                homeViewListener.onViewMealPressed();
            }
        });

        //Meal Table
        mealTable.setRowSelectionAllowed(true);
        mealTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane1.setViewportView(mealTable);

        //UI Swing Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterBox, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBar, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addMeal, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(logout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteMeal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editMeal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewMeal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(filterBox, GroupLayout.Alignment.TRAILING)
                    .addComponent(searchBar, GroupLayout.Alignment.TRAILING)
                    .addComponent(addMeal, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteMeal, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMeal, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewMeal, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setVisible(true);
    }
    
    // Filter Dialog UI here bestie
    public void showFilterDialog() {
        
    }

    public void addListener(HomeViewListener homeViewListener) {
        this.homeViewListener = homeViewListener;
    }
}