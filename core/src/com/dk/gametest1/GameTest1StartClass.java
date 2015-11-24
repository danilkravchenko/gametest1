package com.dk.gametest1;

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
}