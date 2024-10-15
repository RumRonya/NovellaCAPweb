package novella_models.playprogressparts;

import novella_models.logicnovellas.gameplayelements.dependencies.DependencyDefinable;

public class Choice implements DependencyDefinable {
    private int numScene;
    private int numAnswer;

    public Choice(int numScene, int numAnswer) {
        this.numScene = numScene;
        this.numAnswer = numAnswer;
    }

    public Choice(Choice choice) {
        this.numScene = choice.numScene;
        this.numAnswer = choice.numAnswer;
    }

    public int getNumScene() {
        return numScene;
    }

    public void setNumScene(int numScene) {
        this.numScene = numScene;
    }

    public int getNumAnswer() {
        return numAnswer;
    }

    public void setNumAnswer(int numAnswer) {
        this.numAnswer = numAnswer;
    }
}
