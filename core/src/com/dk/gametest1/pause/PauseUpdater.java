package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dk.gametest1.Constants;

/**
 * Created by Крава on 07.11.2015.
 */
public class PauseUpdater extends InputAdapter {
    protected Stage stage;
    private PauseCircle pauseCircle;

    public PauseUpdater(float x, float y) {
        init(x, y);
    }

    private void init(float x, float y) {
        stage = new Stage();
        stage.getCamera().viewportHeight = Constants.VIEWPORT_HEIGHT;
        stage.getCamera().viewportWidth = Constants.VIEWPORT_WIDTH;
        stage.getCamera().position.set(stage.getCamera().viewportWidth/2, stage.getCamera().viewportHeight/2, 0);
        stage.getCamera().update();


        pauseCircle = new PauseCircle();
        pauseCircle.setSize(2f, 2f);
        pauseCircle.setPosition(x, Gdx.graphics.getHeight() - y);
        stage.addActor(pauseCircle);
    }

    private void update(float delta) {
        stage.act(delta);
    }
}
