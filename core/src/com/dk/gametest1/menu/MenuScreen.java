package com.dk.gametest1.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.Constants;
import com.dk.gametest1.DirectedGame;
import com.dk.gametest1.ScreenTransition;
import com.dk.gametest1.ScreenTransitionSlide;

/**
 * Menu screen collects elements that are going to be rendered on it
 * Created by dekay on 03.11.2015.
 */
public class MenuScreen extends AbstractScreen implements GestureDetector.GestureListener {
    private MenuRenderer menuRenderer;//renderer to draw objects
    private MenuUpdater menuUpdater;

    public MenuScreen(DirectedGame game) {
        super(game);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return new GestureDetector(this);
    }

    /**
     * Initializing all necessary objects
     */
    @Override
    public void show() {
        menuUpdater = new MenuUpdater();
        menuRenderer = new MenuRenderer(menuUpdater);
    }

    /**
     * Clearing screen to set color
     * Rendering menu until user touches screen
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Constants.LIGHT.r, Constants.LIGHT.g, Constants.LIGHT.b, 1f);//Clears the screen to color set in parameters
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuUpdater.act(delta);
        menuRenderer.render();
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    /**
     * Occurs when the screen size has been changed
     *
     * @param width  new width
     * @param height new height
     */
    @Override
    public void resize(int width, int height) {
        //Empty method, all necessary changes are being done in StartClass
    }

    @Override
    public void pause() {

    }

    /**
     * The same as dispose method
     */
    @Override
    public void hide() {
        menuRenderer.dispose();
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
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (deltaX < 0 && Math.abs(deltaX) > Math.abs(deltaY) && x >= Gdx.graphics.getWidth() * 3 / 4) {
            ScreenTransition transition = ScreenTransitionSlide.init(0.25f,
                    ScreenTransitionSlide.LEFT, false, Interpolation.linear);
            game.setScreen(new SettingsScreen(game), transition);
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
