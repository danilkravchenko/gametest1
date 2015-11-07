package com.dk.gametest1.pause;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.game.GameScreen;
import com.dk.gametest1.menu.MenuScreen;

/**
 * Pause screen collects elements that are going to be rendered on it
 * Created by dekay on 03.11.2015.
 */
public class PauseScreen extends AbstractScreen {
    private PauseRenderer pauseRenderer;
    private PauseUpdater pauseUpdater;


    public PauseScreen(Game game, float x, float y) {
        super(game);
        pauseUpdater = new PauseUpdater(x, y);
    }

    /**
     * Initializing all necessary objects
     */
    @Override
    public void show() {
        pauseRenderer = new PauseRenderer(pauseUpdater);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void resize(int width, int height) {

    }

    /**
     * Clearing screen to set color
     * Rendering pause until user touches screen or presses back button
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pauseRenderer.render();
        if (Gdx.input.isKeyPressed(Input.Keys.BACK) || Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MenuScreen(game));
        }
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
        }

    }

    @Override
    public void pause() {

    }

    /**
     * The same as dispose method
     */
    @Override
    public void hide() {
        pauseRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

}
