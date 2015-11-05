package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.dk.gametest1.menu.MenuScreen;

/**
 * Point of entrance in our game or main game class
 */
public class GameTest1StartClass extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}