package view;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HomeView {
    private List<HomeViewListener> listeners;
    
    public HomeView() {
        this.listeners = new ArrayList<>();
    }

    public void initUI() {

    }

    public void addListener(HomeViewListener listener) {
        listeners.add(listener);
    }
}