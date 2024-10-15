package novella_dao;

import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NovellaCreateAndPlayDAO implements NovellaCAPBase{
    private Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/novella_create_and_play", "root", "Ver13deth4");;

    public NovellaCreateAndPlayDAO() throws SQLException {
    }

    public NovellaCreateAndPlayDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(int id) throws SQLException {
        return new UserDAO(connection).findById(id);
    }

    @Override
    public void createUser(User user) {
        try {
            new UserDAO(connection).createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createUser(String username, String password) {
        try {
            new UserDAO(connection).createUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createNovellaGame(NovellaGame novella) {
        try {
            new NovellaGameDAO(connection).createNovellaGame(novella);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createNovellaGame(int id_User, String name, String poster, String description, int age) {
        try {
            new NovellaGameDAO(connection).createNovellaGame(id_User, name, poster, description, age);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

