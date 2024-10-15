package novella_models;

import novella_models.logicnovellas.NovellaGame;
import novella_models.logicnovellas.gameplayelements.Scene;
import novella_models.logicnovellas.gameplayelements.answers.Answer;
import novella_models.logicnovellas.gameplayelements.dialogs.Dialog;
import novella_models.playprogressparts.Choice;
import novella_models.playprogressparts.PlayProgress;

import javax.management.InstanceNotFoundException;

public class GamePlay {
    private NovellaGame novellaGame;
    private PlayProgress playProgress;
    private Scene currentScene;

    public GamePlay(PlayProgress playProgress) throws InstanceNotFoundException {
        this.novellaGame = playProgress.getNovellaGame();
        this.playProgress = playProgress;
        Scene lastScene = playProgress.getCurrentScene();
        this.currentScene = lastScene.convertToPlayScene(playProgress);
    }

    public Scene runCurrentScene(int numAnswer) throws InstanceNotFoundException {
        return runCurrentScene(currentScene.getAnswerByNum(numAnswer));
    }

    public Scene runCurrentScene(Answer answer) throws InstanceNotFoundException {
        playProgress.getDoneScene().add(currentScene.getNumScene());

        for (Dialog dialog: currentScene.getDialogs()){
            dialog.writeNote(playProgress);
            dialog.run(playProgress);
        }

        answer.writeNote(playProgress);
        answer.run(playProgress);

        if (answer.isFinal()){
            currentScene = playProgress.gameOver(answer.getTypeEnd());
        }
        else {
            playProgress.addChoice(new Choice(currentScene.getNumScene(), answer.getNumAnswer()));
            int numNextScene = currentScene.getNumNextSceneByPlayAnswer(answer.getNumAnswer());
            currentScene = novellaGame.sceneByNum(numNextScene);
        }

        if (currentScene.isCheckPoint()) {
            playProgress.updateCheckPoint();
        }
        currentScene = currentScene.convertToPlayScene(playProgress);

        return currentScene;
    }

}
