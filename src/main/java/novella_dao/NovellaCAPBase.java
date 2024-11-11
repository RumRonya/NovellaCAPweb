package novella_dao;

import jakarta.servlet.http.Part;
import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.util.List;
import java.util.Map;

public interface NovellaCAPBase {
    //users
    public void createUser(User user);
    public void createUser(String username, String password);
    public List<User> getUsers();
    public List<User> getCreatingUsers();
    public NovellaGame getTheBestNovellaGameByUserId(int id_User);

    //novellas
    public void createNovellaGame(NovellaGame novella);
    public int createNovellaGame(int id_User, String name, String h_poster, String v_poster, String[] genres, String description, int age);


    Map<Integer, String> getGenres();

    void setPosters(int id_novella, String hPoster, String vPoster);
}
