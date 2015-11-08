package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dk.gametest1.Constants;
import com.dk.gametest1.game.GameScreen;

/**
 * Created by Крава on 07.11.2015.
 */
public class PauseUpdater {
    protected Stage stage;
    private GameScreen gameScreen;
    private PauseCircle pauseCircle;

    public PauseUpdater(float x, float y, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        init(x, y);
    }

    private void init(float x, float y) {
        stage = new Stage();
        stage.getCamera().viewportHeight = Constants.VIEWPORT_HEIGHT;
        stage.getCamera().viewportWidth = Constants.VIEWPORT_WIDTH;
        stage.getCamera().position.set(stage.getCamera().viewportWidth / 2, stage.getCamera().viewportHeight / 2, 0);
        stage.getCamera().update();

        pauseCircle = new PauseCircle();
        pauseCircle.setSize(2f, 2f);
        pauseCircle.setPosition(x, y);
        pauseCircle.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gameScreen.changeBeforeRender();
                return false;
            }
        });
        stage.addActor(pauseCircle);
        Gdx.input.setInputProcessor(stage);
    }

    public void update(float delta) {
        stage.act(delta);
    }
}
