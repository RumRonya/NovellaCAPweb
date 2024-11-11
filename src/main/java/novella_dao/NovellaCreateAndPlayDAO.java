package novella_dao;

import jakarta.servlet.http.Part;
import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    public List<User> getUsers() {
        try {
            return new UserDAO(connection).getUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getCreatingUsers() {
        try {
            return new UserDAO(connection).getCreatingUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NovellaGame getTheBestNovellaGameByUserId(int id_User) {
        try {
            return new NovellaGameDAO(connection).getTheBestNovellaGameByUserId(id_User);
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
    public int createNovellaGame(int id_User, String name, String h_poster, String v_poster, String[] genres, String description, int age) {
        try {
            return new NovellaGameDAO(connection).createNovellaGame(id_User, name, h_poster, v_poster, genres, description, age);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<Integer, String> getGenres() {
        try {
            return new GenreDAO(connection).getAllGenres();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setPosters(int id_novella, String hPoster, String vPoster) {
        try {
            new NovellaGameDAO(connection).setPosters(id_novella, hPoster, vPoster);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

