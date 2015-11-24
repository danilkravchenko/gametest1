package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.dk.gametest1.game.GameScreen;

/**
 * Created by Крава on 07.11.2015.
 */
public class PauseUpdater extends Stage {
    // protected Stage stage;
    private GameScreen gameScreen;
    private PauseCircle pauseCircle;

    public PauseUpdater(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        init();
    }

    private void init() {
        pauseCircle = new PauseCircle();
        pauseCircle.setSize(2f, 2f);
        this.addActor(pauseCircle);
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
        Gdx.input.setInputProcessor(this);
    }

    public void setPauseCirclePosition(float x, float y) {
        pauseCircle.setPosition(x, y);
        Gdx.input.setInputProcessor(this);
    }
}
