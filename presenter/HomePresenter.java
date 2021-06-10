package presenter;

import event.*;
import model.*;
import view.HomeViewListener;
import view.HomeView;

// Setiap presenter mesti ada view dgn repository aka model
public class HomePresenter implements HomeViewListener, Subscriber {
    private int currentUserId;
    private EventBus eventBus;
    private HomeView homeView;
    private MealRepository mealRepository;

    public HomePresenter(EventBus eventBus, HomeView homeView, MealRepository mealRepository) {
        this.currentUserId = -1; // No user logged in
        this.eventBus = eventBus;
        this.homeView = homeView;
        this.mealRepository = mealRepository;
    }

    @Override
    public void onAddMealPressed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onDeleteButtonPressed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onFilterClicked() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLogoutButtonPressed() {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getEventName()) {
            case "Login": handleLoginEvent((LoginEvent)event); break;
        }
    }

    private void handleLoginEvent(LoginEvent loginEvent) {
        // TODO Auto-generated method stub

    }

    private void handleLogoutEvent(LogoutEvent logoutEvent) {
        // TODO Auto-generated method stub

    }
}