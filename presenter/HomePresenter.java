package presenter;

import event.*;
import model.*;
import view.HomeViewListener;
import view.HomeView;

// Setiap presenter mesti ada view dgn repository aka model
public class HomePresenter implements Subscriber, HomeViewListener {
    private String currentUserId;
    private EventBus eventBus;
    private HomeView homeView;
    private MealRepository mealRepository;

    public HomePresenter(EventBus eventBus, HomeView homeView, MealRepository mealRepository) {
        this.currentUserId = ""; // No user logged in
        this.eventBus = eventBus;
        this.homeView = homeView;
        this.mealRepository = mealRepository;
    }

    @Override
    public void onAddMealPressed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onEditMealPressed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onDeleteMealPressed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onFilterClicked() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLogoutButtonPressed() {
        eventBus.dispatch(new LogoutEvent());
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getEventName()) {
            case "Login": handleLoginEvent((LoginEvent)event); break;
        }
    }

    private void handleLoginEvent(LoginEvent loginEvent) {
        currentUserId = loginEvent.getUserId();
        // homeView.initializeUI();
    }
}