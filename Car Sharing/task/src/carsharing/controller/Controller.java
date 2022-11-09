package carsharing.controller;

import carsharing.controller.menu_actions.Action;
import carsharing.controller.menu_actions.MenuState;
import carsharing.utils.Const;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    private final String dbUrl;
    private final Connection connection;
    private boolean finished;

    public Controller(String[] args) throws IOException, SQLException {
        this.finished = false;
        File dbFile = getDBFile(args);
        dbUrl = Const.DB_URL + dbFile.getName();
        createDatabase(dbFile);

        connection = DriverManager.getConnection(dbUrl);
    }

    public void makeAction() throws IOException, SQLException {
        Action action = Action.getAction();
        if (Action.getState() == MenuState.TERMINATE) {
            setFinished(true);
        } else {
            action.setConnection(connection);
            action.execute();
        }
    }

    private File getDBFile(String[] args) {
        File dbFile = null;
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if ("-databaseFileName".equals(args[i]) && args[i + 1] != null) {
                    dbFile = new File(Const.PATH + args[i + 1]);
                    break;
                }
            }
        }

        if (dbFile == null) {
            dbFile = new File(Const.PATH + "database.mv.db");
        }

        return dbFile;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void createDatabase(File dbFile) throws IOException {
        new File(Const.PATH).mkdirs();
        dbFile.createNewFile();

        newDBCreateQuery();
    }

    private void newDBCreateQuery() {
        try (Connection connection = DriverManager.getConnection(dbUrl);
             Statement statement = connection.createStatement()) {
            Class.forName(Const.DRIVER);
            connection.setAutoCommit(true);

            statement.execute("DROP TABLE IF EXISTS company");

            String sql = "CREATE TABLE IF NOT EXISTS company" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(75) UNIQUE NOT NULL);";

            statement.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
