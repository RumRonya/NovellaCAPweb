package novella_models.logicnovellas.gameplayelements.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Inventory {

    private Map<Thing, Integer> things;

    public Inventory() {
        things = new HashMap<Thing, Integer>();
    }

    public Inventory(Map<Thing, Integer> things) {
        this.things = things;
    }

    public Map<Thing, Integer> getThingsWithCount(){
        return things;
    }

    public Set<Thing> getThings() {
        return things.keySet();
    }

    public void setThings(Map<Thing, Integer> things) {
        this.things = things;
    }

    public void addThing(Thing thing) {
        if (this.things == null) {return;}
        if (this.things.containsKey(thing) && thing.isCountable()) {
            this.things.put(thing, this.things.get(thing) + 1);
        }
        else {
            this.things.put(thing, 1);
        }
    }

    public void removeThing(Thing thing) {
        if (this.things == null) return;
        if (!this.things.containsKey(thing)) return;
        if (thing.isCountable()) {
            if (this.things.get(thing) > 1) {
                this.things.put(thing, this.things.get(thing) - 1);
            }
            else {
                this.things.remove(thing);
            }
        }
        else{
            this.things.remove(thing);
        }
    }

    public void clearInventory() {
        this.things = null;
    }
}
