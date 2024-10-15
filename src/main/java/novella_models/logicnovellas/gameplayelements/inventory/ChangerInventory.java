package novella_models.logicnovellas.gameplayelements.inventory;

import novella_models.playprogressparts.PlayProgress;

import java.util.HashMap;
import java.util.Map;

//!!!!!!!!!!!!!!!!!!!!!!!!!equal hash

public abstract class ChangerInventory {
    private Map<Thing, ChangeType> changerInventory;

    //constructs and get&set
    public ChangerInventory() {
        this.changerInventory = new HashMap<Thing, ChangeType>();
    }

    public ChangerInventory(Map<Thing, ChangeType> changerInventory) {
        this.changerInventory = new HashMap<Thing, ChangeType>();
        this.changerInventory.putAll(changerInventory);
    }

    public ChangerInventory(Thing thing, ChangeType changeType) {
        this.changerInventory = new HashMap<Thing, ChangeType>();
        this.changerInventory.put(thing, changeType);
    }

    public Map<Thing, ChangeType> getChangerInventory() {
        return changerInventory;
    }

    public void setChangerInventory(Map<Thing, ChangeType> changerInventory) {
        this.changerInventory = new HashMap<Thing, ChangeType>();
        this.changerInventory.putAll(changerInventory);
    }

    //change changerInventory
    public void addChangerInventory(Thing thing, ChangeType changeType) {
        this.changerInventory.put(thing, changeType);
    }

    public void addAllChangerInventory(Map<Thing, ChangeType> changerInventory) {
        this.changerInventory.putAll(changerInventory);
    }

    public void removeChangerInventory(Thing thing) {
        this.changerInventory.remove(thing);
    }

    public void clearChangerInventory() {
        this.changerInventory.clear();
    }

    public void run(PlayProgress playProgress){
        for (Map.Entry<Thing, ChangeType> entry : changerInventory.entrySet()) {
            switch (entry.getValue()) {
                case ADD:
                    playProgress.addThing(entry.getKey());
                    break;
                case DELETE:
                    playProgress.removeThing(entry.getKey());
                    break;
            }
        }
    }

}
