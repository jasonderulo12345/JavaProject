import model.*;
import presenter.*;

import java.awt.EventQueue;

import event.*;

public class Main {
    public Main() {
        // Setting up repository
        Repository<String, User> userRepository = new UserRepositoryImpl("./database/user.txt");
        MealRepository mealRepository = new MealRepositoryImpl("./database/meal.txt");

        // Setting up event bus
        EventBus eventBus = new EventBusImpl();

        // Instantiate all presenter
        new LoginPresenter(userRepository, eventBus);
        new HomePresenter(mealRepository, eventBus);
        new MealPresenter(mealRepository, eventBus);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }
}