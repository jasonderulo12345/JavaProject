import model.*;
import view.*;
import presenter.*;

import java.awt.EventQueue;

import event.*;

public class Main {
    public Main() {
        // Testing lok
        Repository<String, User> userRepository = new UserRepositoryImpl("./database/user.txt");
        MealRepository mealRepository = new MealRepositoryImpl("./database/meal.txt");

        // Initiate event bus
        EventBus eventBus = new EventBusImpl();

        new LoginPresenter(userRepository, eventBus);
        new HomePresenter(mealRepository, eventBus);
        new MealPresenter(mealRepository, eventBus);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }
}