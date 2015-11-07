package com.dk.gametest1.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.dk.gametest1.pause.PauseScreen;

/**
 * GameUpdater holds level, updates and renders it
 * Created by dekay on 30.10.2015.
 */
public class GameUpdater extends InputAdapter {
    protected Level level;
    private Game game;//main instance that allows to change screens


    public GameUpdater(Game game) {
        this.game = game;
        init();
    }

    /**
     * pauses the game
     */
    private void backToMenu() {
        game.setScreen(new PauseScreen(game));
    }

    /**
     * initializing level using path to load schema of level
     * setting input processor which allows to react on the input actions
     */
    private void init() {
        level = new Level("ddd");
        Gdx.input.setInputProcessor(this);
    }

    /**
     * occures if user touches the screen
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     * @return
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * occures if user releases the screen after touching
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     * @return
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        backToMenu();
        return false;
    }

    /**
     * occures if user presses the button
     *
     * @param keycode
     * @return
     */
    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    /**
     * releasing button
     *
     * @param keycode
     * @return
     */
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    /**
     * updating level
     *
     * @param delta
     */
    public void update(float delta) {
        //countCollisions();
        level.act(delta);
    }

    private void countCollisions() {

    }
}
