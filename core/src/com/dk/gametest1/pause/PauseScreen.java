package com.dk.gametest1.pause;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.game.GameScreen;
import com.dk.gametest1.menu.MenuScreen;

/**
 * Created by Крава on 03.11.2015.
 */
public class PauseScreen extends AbstractScreen {
    private PauseRenderer pauseRenderer;

    public PauseScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        pauseRenderer = new PauseRenderer();
        Gdx.input.setCatchBackKey(true);
    }

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
    public void resize(int width, int height) {
        pauseRenderer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {
        pauseRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

}
