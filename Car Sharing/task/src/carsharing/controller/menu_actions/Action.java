package carsharing.controller.menu_actions;

import carsharing.view.View;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Action {

    private static MenuState menuState = MenuState.MAIN;
    private static final View view = new View();
    private Connection connection;


    public Action() {
    }

    public static Action getAction() {
        MenuState state = getState();
        return switch (state) {
            case MAIN -> new MainMenu(view);
            case MANAGER -> new ManagerMenu(view);
            default -> null;
        };
    }

    public static MenuState getState() {
        return menuState;
    }

    static void setState(MenuState state) {
        Action.menuState = state;
    }

    public abstract void execute() throws IOException;

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        this.connection.setAutoCommit(true);
    }

    public Connection getConnection() {
        return connection;
    }
}
