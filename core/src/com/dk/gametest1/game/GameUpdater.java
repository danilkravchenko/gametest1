package com.dk.gametest1.game;

import com.badlogic.gdx.InputAdapter;
import com.dk.gametest1.DirectedGame;

/**
 * GameUpdater holds level, updates and renders it
 * Created by dekay on 30.10.2015.
 */
public class GameUpdater extends InputAdapter {
    protected Level level;
    private DirectedGame game;//main instance that allows to change screens


    public GameUpdater(DirectedGame game) {
        this.game = game;
        init();
    }

    /**
     * initializing level using path to load schema of level
     * setting input processor which allows to react on the input actions
     */
    private void init() {
        level = new Level("ddd");
    }


    /**
     * updating level
     *
     * @param delta
     */
    public void update(float delta) {
        level.act(delta);
    }
}
