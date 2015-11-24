package com.dk.gametest1.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.DirectedGame;

/**
 * Created by Крава on 24.11.2015.
 */
public class SettingsScreen extends AbstractScreen {

    public SettingsScreen(DirectedGame game) {
        super(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public InputProcessor getInputProcessor() {
        return this;
    }
}
