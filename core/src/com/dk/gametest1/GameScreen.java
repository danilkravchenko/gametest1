package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Крава on 03.11.2015.
 */
public class GameScreen extends AbstractScreen {
    private GameRenderer gameRenderer;
    private GameUpdater gameUpdater;
    private boolean pause;

    public GameScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        gameUpdater = new GameUpdater(game);
        gameRenderer = new GameRenderer(gameUpdater);
        Gdx.input.setCatchBackKey(true);
        pause = false;
    }

    @Override
    public void render(float delta) {
        if(!pause){
            gameUpdater.update(delta);
        }
        Gdx.gl.glClearColor(Constants.LIGHT.r, Constants.LIGHT.g, Constants.LIGHT.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        gameRenderer.resize(width, height);
    }

    @Override
    public void pause() {
        pause = true;
    }

    @Override
    public void hide() {
        gameRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resume() {
        super.resume();
        pause = false;
    }
}
