package novella_models.playprogressparts;

import novella_models.logicnovellas.NovellaGame;
import novella_models.logicnovellas.gameplayelements.Scene;
import novella_models.logicnovellas.gameplayelements.answers.TypeEnd;
import novella_models.logicnovellas.gameplayelements.dependencies.DependencyDefinable;
import novella_models.logicnovellas.gameplayelements.inventory.Inventory;
import novella_models.logicnovellas.gameplayelements.inventory.Thing;
import novella_models.users.User;

import javax.management.InstanceNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PlayProgress {
    private User player;
    private NovellaGame novellaGame;
    private Inventory inventory;
    private List<Choice> choiceList;
    private CheckPoint checkPoint;
    private List<Note> diary;
    private Set<Integer> doneScene;
    private double percentDone;
    private LocalDateTime saveDate;

    public PlayProgress() {
        recalculatePercentDone();
    }

    public PlayProgress(User player, NovellaGame novellaGame, Inventory inventory, List<Choice> choiceList, CheckPoint checkPoint, List<Note> diary, Set<Integer> doneScene, double percentDone, LocalDateTime saveDate) {
        this.player = player;
        this.novellaGame = novellaGame;
        this.inventory = inventory;
        this.choiceList = choiceList;
        this.checkPoint = checkPoint;
        this.diary = diary;
        this.doneScene = doneScene;
        this.percentDone = percentDone;
        this.saveDate = saveDate;
    }

    private void recalculatePercentDone(){
        if (doneScene==null || doneScene.isEmpty() || novellaGame.getScenes() == null || novellaGame.getScenes().isEmpty()) return;
        percentDone = (double) doneScene.size() / (double) novellaGame.getScenes().size() * 100;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public NovellaGame getNovellaGame() {
        return novellaGame;
    }

    public void setNovellaGame(NovellaGame novellaGame) {
        this.novellaGame = novellaGame;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public CheckPoint getCheckPoint() {
        return checkPoint;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(LocalDateTime saveDate) {
        this.saveDate = saveDate;
    }

    public Set<Integer> getDoneScene() {
        return doneScene;
    }

    public void setDoneScene(Set<Integer> doneScene) {
        this.doneScene = doneScene;
    }

    public void addDoneScene(int numScene) {
        doneScene.add(numScene);
        recalculatePercentDone();
    }

    public double getPercentDone() {
        return percentDone;
    }

    public List<Note> getDiary() {
        return diary;
    }

    public void setDiary(List<Note> diary) {
        this.diary = diary;
    }

    public void setCheckPoint(CheckPoint checkPoint) {
        this.checkPoint = checkPoint;
    }

    public boolean isContain(DependencyDefinable dependentObject) {
        if (dependentObject==null) return false;
        if (dependentObject instanceof Choice) return isContainChoice((Choice) dependentObject);
        if (dependentObject instanceof Thing) return  isContainThing((Thing) dependentObject);
        return false;
    }

    private boolean isContainChoice(Choice choice) {
        for (Choice ch: choiceList){
            if (ch.getNumScene()==choice.getNumScene()){
                if (choice.getNumAnswer()==0||ch.getNumAnswer()==choice.getNumAnswer()) return true;
            }
        }
        return false;
    }

    private boolean isContainThing(Thing thing) {
        for (Thing th: inventory.getThings()){
            if (th.equals(thing)) return true;
        }
        return false;
    }

    public Scene getCurrentScene() throws InstanceNotFoundException {
        return novellaGame.sceneByNum(numCurrentScene());
    }

    private int numCurrentScene() throws InstanceNotFoundException {
        Scene lastScene = novellaGame.sceneByNum(choiceList.getLast().getNumScene());
        return lastScene.getNumNextSceneByPlayAnswer(choiceList.getLast().getNumAnswer());
    }

    public Scene gameOver(TypeEnd typeEnd) throws InstanceNotFoundException {
        if (typeEnd==TypeEnd.BAD) {
            backToCheckPoint();
        }
        else {
            choiceList.add(new Choice(0,0));
        }
        return getCurrentScene();
    }

    public void addThing(Thing thing) {
        inventory.addThing(thing);
    }

    public void removeThing(Thing thing) {
        inventory.removeThing(thing);
    }

    public void addChoice(Choice choice) {
        choiceList.add(choice);
    }

    public void addNote(Note note) {
        diary.add(note);
    }

    public void removeNote(Note note) {
        diary.remove(note);
    }

    public void clearNotes() {
        diary.clear();
    }

    public void updateCheckPoint() {
        checkPoint.setChoiceList(choiceList);
        checkPoint.setInventory(inventory);
    }

    public void backToCheckPoint() {
        choiceList = checkPoint.getChoiceList();
        inventory = checkPoint.getInventory();
    }

    public void clearCheckPoint() {
        checkPoint.clear();
    }
}
