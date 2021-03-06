package view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HomeView extends JFrame {
    private HomeViewListener homeViewListener;

    public JLabel title;
    private JButton addMeal;
    private JButton deleteMeal;
    private JButton editMeal;
    private JButton logout;
    private JButton viewMeal;
    private JTextField searchBar;
    private JButton filter;
    private JButton clear;
    private JScrollPane jScrollPane1;
    public JLabel filterIndicator;
    public JTable mealTable;
    public FilterDialog filterDialog;

    public HomeView() { }

    public void initUI() {
        //Label
        title = new JLabel();
        filterIndicator = new JLabel();
        filterIndicator.setFont(new Font("Tahoma", 3, 14));

        //Button
        logout = new JButton();
        addMeal = new JButton();
        deleteMeal = new JButton();
        editMeal = new JButton();
        viewMeal = new JButton();

        //Filter
        filter = new JButton();

        //Clear
        clear = new JButton();

        //TextField
        searchBar = new JTextField();

        //ScrollPanel
        jScrollPane1 = new JScrollPane();

        //Table
        mealTable = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Title
        title.setFont(new Font("Tahoma", 0, 24));
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setText("Welcome, Arzmin");;

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

        //Filter
        filter.setText("Filter");
        filter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                showFilterDialog();
            }
        });

        //Clear
        clear.setText("Clear");
        clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                homeViewListener.onClearClicked();
            }
        });

        //Meal Table
        mealTable.setFont(new Font("Tahoma", 0, 14));
        mealTable.setRowSelectionAllowed(true);
        mealTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane1.setViewportView(mealTable);

        //UI Swing Stuff
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterIndicator, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addMeal, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMeal, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteMeal, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewMeal, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                                .addComponent(clear, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logout, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(filter, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMeal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMeal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewMeal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteMeal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filterIndicator)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Set the icon
        setIconImage(new ImageIcon("./resource/logo.png").getImage());

        pack();
        setTitle("Home");
        setResizable(false);
        setVisible(true);
    }
    
    // Filter Dialog UI here bestie
    public void showFilterDialog() {
        filterDialog = new FilterDialog();
        filterDialog.initUI();

        filterDialog.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Filter clicked");
                homeViewListener.onFilterClicked();
            }
        });

        filterDialog.setVisible(true);
    }

    public void addListener(HomeViewListener homeViewListener) {
        this.homeViewListener = homeViewListener;
    }
}