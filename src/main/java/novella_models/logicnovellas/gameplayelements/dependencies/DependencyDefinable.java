package novella_models.logicnovellas.gameplayelements.dependencies;

import novella_models.playprogressparts.PlayProgress;

public interface DependencyDefinable {
    public boolean isInProgress(PlayProgress playProgress);
}
