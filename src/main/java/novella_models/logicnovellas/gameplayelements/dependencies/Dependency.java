package novella_models.logicnovellas.gameplayelements.dependencies;

import novella_models.playprogressparts.PlayProgress;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Dependency {
    private boolean isHas;
    private boolean isShow;
    private DependencyDefinable dependentObject;

    public Dependency(DependencyDefinable dependentObject) {
        this.dependentObject = dependentObject;
        this.isHas = true;
        this.isShow = true;
    }

    public Dependency(DependencyDefinable dependentObject, boolean isShow, boolean isHas) {
        this.dependentObject = dependentObject;
        this.isShow = isShow;
        this.isHas = isHas;
    }

    public boolean isHas() {
        return isHas;
    }

    public void setHas(boolean has) {
        isHas = has;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public DependencyDefinable getDependentObject() {
        return dependentObject;
    }

    public void setDependentObject(DependencyDefinable dependentObject) {
        this.dependentObject = dependentObject;
    }

    public boolean isShow(PlayProgress playProgress) {
        boolean isInProgress = playProgress.isContain(dependentObject);
        return (isInProgress == isHas) ? isShow : !isShow;
    }
}
