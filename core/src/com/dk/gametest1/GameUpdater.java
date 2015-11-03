package com.dk.gametest1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.awt.event.KeyListener;

/**
 * Created by Крава on 30.10.2015.
 */
public class GameUpdater extends InputAdapter{
    LevelLoader level;
    private Game game;

    private void backToMenu(){
        game.setScreen(new PauseScreen(game));
    }

    public GameUpdater(Game game){
        this.game = game;
        init();
    }

    private void init(){
        level = new LevelLoader("dddd");
        Gdx.input.setInputProcessor(this);
    }

    private void countCollisions() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        backToMenu();
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    public void update(float delta){
        //countCollisions();
        level.update(delta);
    }

}
