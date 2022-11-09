package carsharing.controller.menu_actions;

import carsharing.model.Company;
import carsharing.utils.Console;
import carsharing.view.View;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerMenu extends Action {

    private final View view;

    public ManagerMenu(View view) {
        super();
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            int action = view.showManagerMenu();
            switch (action) {
                case 0 -> setState(MenuState.MAIN);
                case 1 -> showCompanyList();
                case 2 -> createCompany();
            }
        } catch (IOException e) {
            Console.writeLine("You should enter numbers.");
        }
    }

    private void showCompanyList() {
        List<Company> list;
        try (Statement statement = getConnection().createStatement()) {
            String query = "SELECT * FROM company";
            ResultSet result = statement.executeQuery(query);
            list = convertResultSetToList(result);
            view.showCompanyList(list);

        } catch (SQLException e) {
            Console.writeLine("showCompanyList method. SQL Exception caught");
            e.printStackTrace();
        }
    }

    private List<Company> convertResultSetToList(ResultSet set) throws SQLException {
        List<Company> list = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt("id");
            String name = set.getString("name");

            Company company = new Company(id, name);
            list.add(company);
        }
        return list;
    }

    private void createCompany() throws IOException {
        String newCompanyName = view.showCreateDialog();

        try (Statement statement = getConnection().createStatement()) {
            String query = "INSERT INTO company(name) VALUES ('" + newCompanyName + "');";

            statement.execute(query);
            Console.writeLine("The company was created!\n");
        } catch (SQLException e) {
            Console.writeLine("createCompany method. SQL Exception caught");
            e.printStackTrace();
        }
    }
}
