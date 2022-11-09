package carsharing.view;

import carsharing.model.Company;
import carsharing.utils.Console;

import java.io.IOException;
import java.util.List;

public class View {

    public View() {
    }

    public int showMainMenu() throws IOException {
        Console.writeLine("1. Log in as a manager");
        Console.writeLine("0. Exit");
        return Console.readInt();
    }

    public int showManagerMenu() throws IOException {
        Console.writeLine("1. Company list");
        Console.writeLine("2. Create a company");
        Console.writeLine("0. Back");
        return Console.readInt();
    }

    public void showCompanyList(List<Company> list) {
        if (!list.isEmpty()) {
            Console.writeLine("Company list:");
            for (Company company : list) {
                Console.writeLine(company.getId() + ". " + company.getName());
            }
        } else {
            Console.writeLine("The company list is empty!\n");
        }

    }

    public String showCreateDialog() throws IOException {
        Console.writeLine("Enter the company name:");
        return Console.readLine();
    }
}
