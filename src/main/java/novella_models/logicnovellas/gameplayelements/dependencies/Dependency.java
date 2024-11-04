package novella_models.logicnovellas.gameplayelements.dependencies;

import novella_models.playprogressparts.PlayProgress;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Dependency {
    private boolean isHas;
    private DependencyDefinable dependentObject;

    public Dependency(DependencyDefinable dependentObject) {
        this.dependentObject = dependentObject;
        this.isHas = true;
    }

    public Dependency(DependencyDefinable dependentObject, boolean isShow, boolean isHas) {
        this.dependentObject = dependentObject;
        this.isHas = isHas;
    }

    public boolean isHas() {
        return isHas;
    }

    public void setHas(boolean has) {
        isHas = has;
    }

    public DependencyDefinable getDependentObject() {
        return dependentObject;
    }

    public void setDependentObject(DependencyDefinable dependentObject) {
        this.dependentObject = dependentObject;
    }

    public boolean isEquals(PlayProgress playProgress) {
        boolean isInProgress = dependentObject.isInProgress(playProgress); // playProgress.isContain(dependentObject);
        return (isInProgress == isHas);
    }
}
