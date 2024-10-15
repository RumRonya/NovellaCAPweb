package novella_models.logicnovellas.gameplayelements.dependencies;

import novella_models.playprogressparts.PlayProgress;

import java.util.ArrayList;
import java.util.List;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class DependenciesList {
    private int ID;
    private List<Dependency> listDependencies;
    private DependencyLogic dependencyLogic;

    public DependenciesList() {
        listDependencies = new ArrayList<Dependency>();
        dependencyLogic = DependencyLogic.OR;
    }

    public DependenciesList(List<Dependency> listDependencies, DependencyLogic dependencyLogic) {
        this.listDependencies = new ArrayList<>(listDependencies);
        this.dependencyLogic = dependencyLogic;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Dependency> getListDependencies() {
        return listDependencies;
    }

    public void setListDependencies(List<Dependency> listDependencies) {
        this.listDependencies = new ArrayList<>(listDependencies);
    }

    public DependencyLogic getDependencyLogic() {
        return dependencyLogic;
    }

    public void setDependencyLogic(DependencyLogic dependencyLogic) {
        this.dependencyLogic = dependencyLogic;
    }

    public void addDependency(Dependency dependency) {
        listDependencies.add(dependency);
    }

    public void removeDependency(Dependency dependency) {
        listDependencies.remove(dependency);
    }

    public void removeAllDependencies() {
        listDependencies.clear();
    }

    public boolean isPlay(PlayProgress playProgress){
        if (listDependencies==null || listDependencies.isEmpty()) return true;
        for (Dependency dependency: listDependencies){
            boolean isShowDependency = dependency.isShow(playProgress);
            if (dependencyLogic == DependencyLogic.OR && isShowDependency) return true;
            if (dependencyLogic == DependencyLogic.AND && !isShowDependency) return false;
        }
        return dependencyLogic != DependencyLogic.OR;
    }
}
