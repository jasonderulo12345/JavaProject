package view;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HomeView {
    private HomeViewListener homeViewListener;
    
    public HomeView() {

    }

    public void initUI() {

    }

    public void addListener(HomeViewListener homeViewListener) {
        this.homeViewListener = homeViewListener;
    }
}