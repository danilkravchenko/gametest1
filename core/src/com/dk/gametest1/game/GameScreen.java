package com.dk.gametest1.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.Constants;

/**
 * Just game screen
 * Created by dekay on 03.11.2015.
 */
public class GameScreen extends AbstractScreen {
    private GameRenderer gameRenderer;
    private GameUpdater gameUpdater;
    private boolean pause;

    public GameScreen(Game game) {
        super(game);
    }

    /**
     * The same as init method
     * setCatchBackKey allows to catch action when user presses back button
     */
    @Override
    public void show() {
        gameUpdater = new GameUpdater(game);
        gameRenderer = new GameRenderer(gameUpdater);
        Gdx.input.setCatchBackKey(true);
        pause = false;
    }

    /**
     * Updating world if pause if false and rendering whenever the pause is true or false
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        if (!pause) {
            gameUpdater.update(delta);
        }
        Gdx.gl.glClearColor(Constants.LIGHT.r, Constants.LIGHT.g, Constants.LIGHT.b, 1);//Clears the screen to color set in parameters
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameRenderer.render();
    }

    /**
     * Occurs if the screen size has been changed
     *
     * @param width  new width
     * @param height new height
     */
    @Override
    public void resize(int width, int height) {
        gameRenderer.resize(width, height);
    }

    @Override
    public void pause() {
        pause = true;
    }

    /**
     * The same as dispose method
     */
    @Override
    public void hide() {
        gameRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

    @Override
    public void resume() {
        super.resume();
        pause = false;
    }
}
