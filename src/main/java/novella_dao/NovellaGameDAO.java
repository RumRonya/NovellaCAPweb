package novella_dao;

import jakarta.servlet.http.Part;
import novella_models.logicnovellas.NovellaGame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class NovellaGameDAO {

    private final Connection connection;
    private static final String INSERT_NEW = "INSERT INTO `novella_create_and_play`.`novellas` (`id_creator`, `name`, `description`, `age_restriction`) " +
            "VALUES (%d, \"%s\", \"%s\", '%d')";
    private static final String GET_ID_NOVELLA = "SELECT ID \n" +
            "FROM novella_create_and_play.novellas WHERE novellas.id_creator = %d\n" +
            "AND novellas.name = \"%s\"\n";
    private static final String INSERT_GENRE = "INSERT INTO `novella_create_and_play`.`novella_genres` (`id_novella`, `id_genre`) " +
            "VALUES (%d, %d)";
    private static final String UPDATE_POSTERS = "UPDATE `novella_create_and_play`.`novellas` SET `h_poster` = \"%s\", `v_poster` = \"%s\" WHERE `ID`=%d\n";

        public NovellaGameDAO(Connection connection){
            this.connection = connection;
        }

    public void createNovellaGame(NovellaGame novellaGame) throws SQLException {
        createNovellaGame(novellaGame.getCreator().getID_USER(), novellaGame.getName(), novellaGame.getH_poster(), novellaGame.getV_poster(), new String[2], novellaGame.getDescription(), novellaGame.getAgeRestriction());
    }

    public int createNovellaGame(int id_User, String name, String h_poster, String v_poster, String[] genres, String description, int age) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(format(INSERT_NEW, id_User, name, description, age));
        ResultSet resultSet = statement.executeQuery(format(GET_ID_NOVELLA, id_User, name));
        int id = 0;
        if (resultSet.next()){
            id = resultSet.getInt("ID");
        }
        for (String str: genres){
            statement.executeUpdate(format(INSERT_GENRE, id, Integer.parseInt(str)));
        }
        statement.executeUpdate(format(UPDATE_POSTERS, h_poster, v_poster, id));
        statement.close();
        return id;
    }

    public void setPosters(int id_novella, String h_poster, String v_poster) throws SQLException, IOException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(format(UPDATE_POSTERS, h_poster, v_poster, id_novella));
        statement.close();
    }

/*
    public void setPosters(int id_User, String title, Part h_poster, Part v_poster) throws SQLException, IOException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(GET_ID_NOVELLA, id_User, title));
        int id = 0;
        if (resultSet.next()){
            id = resultSet.getInt("ID");
        }
        String fileName = Paths.get(h_poster.getSubmittedFileName()).getFileName().toString(); // Получить имя файла
        InputStream fileContent = h_poster.getInputStream(); // Получить содержимое файла
        String path = req.getServletContext().getRealPath("/")+"images/novellas/"+id;
        File uploadsDir = new File(path.replace("target\\NovellasCAP_site","src\\main\\webapp"));

        if (!uploadsDir.exists()) {
            uploadsDir.mkdir();
        }
        Files.copy(fileContent, Paths.get(uploadsDir.getPath() + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);

        File uploadedFile = new File(uploadsDir.getPath() + File.separator + fileName);
        if (uploadedFile.exists()) {
            System.out.println("ok");
        } else {
            System.out.println("okn't");
        }



        statement.executeUpdate(format(UPDATE_POSTERS, h_poster, v_poster, id));
        statement.close();
    }
*/
    public NovellaGame getTheBestNovellaGameByUserId(int id_User) throws SQLException {
        String GET_THE_BEST = "SELECT * \n" +
                "FROM novella_create_and_play.novellas WHERE novellas.id_creator = '%d'\n" +
                "order by raiting limit 1";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(format(GET_THE_BEST, id_User));
        NovellaGame novellaGame = null;
        if (resultSet.next()) {
            novellaGame = new NovellaGame();
            novellaGame.setID_NOVELLA(resultSet.getInt("ID"));
            novellaGame.setName(resultSet.getString("name"));
        }
        statement.close();
        return novellaGame;
    }



}
