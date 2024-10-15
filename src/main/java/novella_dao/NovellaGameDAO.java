package novella_dao;

import novella_models.logicnovellas.NovellaGame;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class NovellaGameDAO {

    private final Connection connection;

        public NovellaGameDAO(Connection connection){
            this.connection = connection;
        }

    public void createNovellaGame(NovellaGame novellaGame) throws SQLException {
        createNovellaGame(novellaGame.getCreator().getID_USER(), novellaGame.getName(), novellaGame.getPoster(), novellaGame.getDescription(), novellaGame.getAgeRestriction());
    }

    public void createNovellaGame(int id_User, String name, String poster, String description, int age) throws SQLException {
        String INSERT_NEW = "INSERT INTO `novella_create_and_play`.`novellas` (`id_creator`, `name`, `poster`, `description`, `age_restriction`) " +
                "VALUES (%d, \"%s\", \"%s\", \"%s\", '%d')";

        Statement statement = connection.createStatement();
        statement.executeUpdate(format(INSERT_NEW, id_User, name, poster, description, age));
        statement.close();
    }
}
