package com.dk.gametest1;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.dk.gametest1.menu.MenuScreen;

/**
 * Point of entrance in our game or main game class
 */
public class GameTest1StartClass extends DirectedGame {
    @Override
    public void create() {
        Assets.instance.init(new AssetManager());
        setScreen(new MenuScreen(this));
    }

    @Override
    public void resize(int width, int height) {
        //super.resize(width, height);
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            Constants.VIEWPORT_WIDTH = width / (height / Constants.VIEWPORT_HEIGHT);
            Constants.VIEWPORT_GUI_WIDTH = width / (height / Constants.VIEWPORT_GUI_HEIGHT);
            Constants.DESKTOP_SCALE_X = width / Constants.VIEWPORT_GUI_WIDTH;

        } else {
            Constants.VIEWPORT_HEIGHT = height / (width / Constants.VIEWPORT_WIDTH);
            Constants.VIEWPORT_GUI_HEIGHT = height / (width / Constants.VIEWPORT_GUI_WIDTH);
            Constants.MOBILE_SCALE_X = height / Constants.VIEWPORT_GUI_HEIGHT;
        }
    }
}