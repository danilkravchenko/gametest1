package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by Крава on 03.11.2015.
 */
public abstract class AbstractScreen implements Screen {
    protected Game game;

    public AbstractScreen(Game game) {
        this.game = game;
    }

    public abstract void show();

    public abstract void render(float delta);

    public abstract void resize(int width, int height);

    public abstract void pause();

    public abstract void hide();

    public void dispose() {
    }

    public void resume() {
    }
}
