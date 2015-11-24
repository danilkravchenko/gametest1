package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.dk.gametest1.Constants;
import com.dk.gametest1.game.GameScreen;

/**
 * Created by Крава on 07.11.2015.
 */
public class PauseUpdater {
    protected Stage stage;
    private GameScreen gameScreen;
    private PauseCircle pauseCircle;

    public PauseUpdater(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        init();
    }

    public Stage getStage() {
        return stage;
    }

    private void init() {
        stage = new Stage();
        stage.getCamera().viewportHeight = Constants.VIEWPORT_HEIGHT;
        stage.getCamera().viewportWidth = Constants.VIEWPORT_WIDTH;
        stage.getCamera().position.set(stage.getCamera().viewportWidth / 2, stage.getCamera().viewportHeight / 2, 0);
        stage.getCamera().update();

        pauseCircle = new PauseCircle();
        pauseCircle.setSize(2f, 2f);
        stage.addActor(pauseCircle);
        pauseCircle.addListener(new ActorGestureListener(1, 1f, 0.2f, 0) {
            @Override
            public boolean longPress(Actor actor, float x, float y) {
                Gdx.input.setInputProcessor(gameScreen);
                gameScreen.changeBeforeRender();
                return false;
            }

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                gameScreen.backToMenu();
                System.out.println("back");
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    public void setPauseCirclePosition(float x, float y) {
        pauseCircle.setPosition(x, y);
        Gdx.input.setInputProcessor(stage);
    }

    public void update(float delta) {
        stage.act(delta);
    }
}
