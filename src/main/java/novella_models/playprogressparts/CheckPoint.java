package novella_models.playprogressparts;

import novella_models.logicnovellas.gameplayelements.inventory.Inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckPoint {
    private int ID;
    private PlayProgress progress;
    private Inventory inventory;
    private List<Choice> choiceList;
    private List<Note> diary;
    private LocalDateTime saveDate;

    public CheckPoint(PlayProgress playProgress) {
        playProgress.setCheckPoint(this);
        inventory = playProgress.getInventory();
        choiceList = playProgress.getChoiceList();
        diary = playProgress.getDiary();
        saveDate = LocalDateTime.now();
    }

    public CheckPoint(int ID, PlayProgress progress, Inventory inventory, List<Choice> choiceList, List<Note> diary, LocalDateTime saveDate) {
        this.ID = ID;
        this.progress = progress;
        this.inventory = inventory;
        this.choiceList = choiceList;
        this.diary = diary;
        this.saveDate = saveDate;
    }

    public CheckPoint() {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PlayProgress getProgress() {
        return progress;
    }

    public void setProgress(PlayProgress progress) {
        this.progress = progress;
    }

    public List<Note> getDiary() {
        return diary;
    }

    public void setDiary(List<Note> diary) {
        this.diary = diary;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(LocalDateTime saveDate) {
        this.saveDate = saveDate;
    }

    public void clear() {
        this.inventory = new Inventory();
        this.choiceList = new ArrayList<>();
    }
}
