package novella_models.logicnovellas.gameplayelements.answers;

import novella_models.logicnovellas.gameplayelements.Scene;
import novella_models.logicnovellas.gameplayelements.dependencies.DependenciesList;
import novella_models.logicnovellas.gameplayelements.dependencies.Dependency;
import novella_models.logicnovellas.gameplayelements.inventory.ChangerInventory;
import novella_models.playprogressparts.DiaryWriter;
import novella_models.playprogressparts.Note;
import novella_models.playprogressparts.PlayProgress;

import java.time.LocalDateTime;

public class Answer extends ChangerInventory implements DiaryWriter {
    private int ID_ANSWER;
    private Scene scene;
    private int numAnswer;
    private String text;
    private int nextScene;
    private TypeEnd typeEnd = TypeEnd.NONE;
    private DependenciesList dependenciesList = new DependenciesList();

    public Answer() {
    }

    public Answer(int ID_ANSWER, Scene scene, int numAnswer, int nextScene, TypeEnd typeEnd, DependenciesList dependenciesList) {
        this.ID_ANSWER = ID_ANSWER;
        this.scene = scene;
        this.numAnswer = numAnswer;
        this.nextScene = nextScene;
        this.typeEnd = typeEnd;
        this.dependenciesList = dependenciesList;
    }

    public Answer(int ID_ANSWER, Scene scene, int numAnswer, String text, int nextScene, TypeEnd typeEnd, DependenciesList dependenciesList) {
        this.ID_ANSWER = ID_ANSWER;
        this.scene = scene;
        this.numAnswer = numAnswer;
        this.text = text;
        this.nextScene = nextScene;
        this.typeEnd = typeEnd;
        this.dependenciesList = dependenciesList;
    }

    public int getID_ANSWER() {
        return ID_ANSWER;
    }

    public void setID_ANSWER(int ID_ANSWER) {
        this.ID_ANSWER = ID_ANSWER;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getNumAnswer() {
        return numAnswer;
    }

    public void setNumAnswer(int numAnswer) {
        this.numAnswer = numAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNextScene() {
        return nextScene;
    }

    public void setNextScene(int nextScene) {
        this.nextScene = nextScene;
    }

    public TypeEnd getTypeEnd() {
        return typeEnd;
    }

    public void setTypeEnd(TypeEnd typeEnd) {
        this.typeEnd = typeEnd;
    }

    public DependenciesList getDependenciesList() {
        return dependenciesList;
    }

    public void setDependenciesList(DependenciesList dependenciesList) {
        this.dependenciesList = dependenciesList;
    }

    public void addDependencies(Dependency dependency) {
        dependenciesList.addDependency(dependency);
    }

    public void removeDependencies(Dependency dependency) {
        dependenciesList.removeDependency(dependency);
    }

    public void removeAllDependencies() {
        dependenciesList.removeAllDependencies();
    }

    public boolean isPlay(PlayProgress playProgress) {
        return dependenciesList.isPlay(playProgress);
    }

    public boolean isFinal(){
        return typeEnd!=TypeEnd.NONE;
    }

    @Override
    public void writeNote(PlayProgress playProgress) {
        playProgress.addNote(new Note("You", this.text, LocalDateTime.now()));
    }
}
