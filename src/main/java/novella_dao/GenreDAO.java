package novella_dao;

import novella_models.users.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreDAO {
    private Connection connection;

    public GenreDAO(Connection connection){
        this.connection = connection;
    }

    public Map<Integer,String> getAllGenres() throws SQLException {
        ResultSet resultSet = connection.prepareStatement("SELECT * FROM novella_create_and_play.genres").executeQuery();
        Map<Integer,String> genres = new HashMap<>();
        while (resultSet.next()){
            genres.put(resultSet.getInt("ID"), resultSet.getString("genre") );
        }
        return genres;
    }
}
