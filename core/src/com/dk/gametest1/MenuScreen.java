package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Крава on 03.11.2015.
 */
public class MenuScreen extends AbstractScreen {
    private MenuRenderer menuRenderer;

    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        menuRenderer = new MenuRenderer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuRenderer.render();
        if(Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        menuRenderer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {
        menuRenderer.dispose();
    }
}
