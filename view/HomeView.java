package view;

import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HomeView {
    private HomeViewListener homeViewListener;

    private JLabel title;
    private JButton AddMeal;
    private JButton DeleteMeal;
    private JButton EditMeal;
    private JButton Logout;
    private JButton ViewMeal;
    private JTextField SearchBar;
    private JComboBox<String> FilterBox;
    private JScrollPane jScrollPane1; //idk apa ni
    private JTable MealTable;

    public HomeView() {

    }

    public void initUI() {
      //Label
      title = new JLabel();

      //Button
      Logout = new JButton();
      AddMeal = new JButton();
      DeleteMeal = new JButton();
      EditMeal = new JButton();
      ViewMeal = new JButton();

      //ComboBox
      FilterBox = new JComboBox<>();

      //TextField
      SearchBar = new JTextField();

      //ScrollPanel
      jScrollPane1 = new JScrollPane();

      //Table
      MealTable = new JTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      //Title
      title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      title.setText("Home Menu");

      //FilterBox
      FilterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter", "Item 2", "Item 3", "Item 4" }));

      //Set text
      SearchBar.setText("SearchBar");
      Logout.setText("Logout");
      AddMeal.setText("Add Meal");
      DeleteMeal.setText("Delete Meal");
      EditMeal.setText("Edit Meal");
      ViewMeal.setText("View Meal");

      //Meal Table
      MealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Breakfast", "Coomer", "1", "test"},
                {"Breakfast", "Cooming", "2", "69"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Meal Type", "Meal Name", "Day", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MealTable);

      //UI Swing Stuff
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(FilterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddMeal, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteMeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditMeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewMeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FilterBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchBar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddMeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeleteMeal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditMeal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ViewMeal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }
    
    // Filter Dialog UI here bestie
    public void showFilterDialog() {
        
    }

    public void addListener(HomeViewListener homeViewListener) {
        this.homeViewListener = homeViewListener;
    }
}