package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Крава on 03.11.2015.
 */
public class PauseScreen extends AbstractScreen {
private PauseRenderer pauseRenderer;
    public PauseScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        pauseRenderer = new PauseRenderer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pauseRenderer.render();
        if(Gdx.input.isTouched()){
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
    }

}
