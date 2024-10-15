package novella_models.users;

import novella_models.logicnovellas.NovellaGame;

import java.util.Date;
import java.util.List;

public class User {
    private int ID_USER;
    private String login;
    private String password;
    private String email;
    private String img;
    private Date birthday;
    private List<NovellaGame> createGames;
    private List<NovellaGame> playGames;

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<NovellaGame> getCreateGames() {
        return createGames;
    }

    public void setCreateGames(List<NovellaGame> createGames) {
        this.createGames = createGames;
    }

    public List<NovellaGame> getPlayGames() {
        return playGames;
    }

    public void setPlayGames(List<NovellaGame> playGames) {
        this.playGames = playGames;
    }

    //lists??
}
