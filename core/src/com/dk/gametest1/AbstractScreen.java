package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

/**
 * Abstract class that is like a parent for other screens
 * Created by dekay on 03.11.2015.
 */
public abstract class AbstractScreen implements Screen {
    protected Game game; //our main game or object of GameTest1StartClass
    //Need to give access to the game instance for all screens to allow them change the screens by calling setScreen method
    //of game object

    public AbstractScreen(Game game) {
        this.game = game;
    }

    //Abstract methods we need to realize in or screen classes
    public abstract void show();

    public abstract void render(float delta);

    public abstract void resize(int width, int height);

    public abstract void pause();

    public abstract void hide();

    public void dispose() {
        Assets.instance.dispose();
    }

    public void resume() {
        Assets.instance.init(new AssetManager());
    }
}
