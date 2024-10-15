package novella_models.logicnovellas;

import novella_models.logicnovellas.gameplayelements.Scene;
import novella_models.users.User;

import java.util.Date;
import java.util.List;



public class NovellaGame {
    private int ID_NOVELLA;
    private User creator;
    private String name;
    private String poster;
    private String description;
    private Genre genre;
    private double rating;
    private int ageRestriction;
    private Duration duration;
    private Date createDate;
    private Date updateDate;
    private List<Scene> scenes;

    public int getID_NOVELLA() {
        return ID_NOVELLA;
    }

    public void setID_NOVELLA(int ID_NOVELLA) {
        this.ID_NOVELLA = ID_NOVELLA;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public Scene sceneByNum(int numScene) {
        for (Scene scene : scenes) {
            if (scene.getNumScene() == numScene) {return scene;}
        }
        return null;
    }

    public void addScene(Scene scene) {
        this.scenes.add(scene);
    }

    public void removeScene(Scene scene) {
        this.scenes.remove(scene);
    }

    public void removeAllScenes() {
        this.scenes.clear();
    }

    public void removeScene(int numScene) {
        Scene scene = this.sceneByNum(numScene);
        this.scenes.remove(scene);
    }
}
