package carsharing.controller.menu_actions;


import carsharing.utils.Console;
import carsharing.view.View;

import java.io.IOException;

public class MainMenu extends Action {

    private final View view;
    public MainMenu(View view) {
        super();
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            int action = view.showMainMenu();
            switch (action) {
                case 0 -> setState(MenuState.TERMINATE);
                case 1 -> setState(MenuState.MANAGER);
                default -> Console.writeLine("Wrong command. Choose another one.");
            }
        } catch (IOException e) {
            Console.writeLine("You should enter numbers.");
        }
    }
}
