package novella_dao;

import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.util.List;

public interface NovellaCAPBase {
    //users
    public void createUser(User user);
    public void createUser(String username, String password);
    public List<User> getUsers();

    //novellas
    public void createNovellaGame(NovellaGame novella);
    public void createNovellaGame(int id_User, String name, String poster, String description, int age);

}
