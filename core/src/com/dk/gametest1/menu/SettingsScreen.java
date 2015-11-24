package com.dk.gametest1.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.DirectedGame;
import com.dk.gametest1.ScreenTransition;
import com.dk.gametest1.ScreenTransitionSlide;

/**
 * Created by Крава on 24.11.2015.
 */
public class SettingsScreen extends AbstractScreen implements GestureDetector.GestureListener {

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
        return new GestureDetector(this);
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (deltaX > 0 && Math.abs(deltaX) > Math.abs(deltaY) && x <= Gdx.graphics.getWidth() / 4) {
            ScreenTransition transition = ScreenTransitionSlide.init(0.25f,
                    ScreenTransitionSlide.RIGHT, false, Interpolation.linear);
            game.setScreen(new MenuScreen(game), transition);
        }
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
