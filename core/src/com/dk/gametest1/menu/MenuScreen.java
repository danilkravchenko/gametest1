package com.dk.gametest1.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.DirectedGame;
import com.dk.gametest1.ScreenTransition;
import com.dk.gametest1.ScreenTransitionSlide;

/**
 * Menu screen collects elements that are going to be rendered on it
 * Created by dekay on 03.11.2015.
 */
public class MenuScreen extends AbstractScreen {
    private MenuRenderer menuRenderer;//renderer to draw objects
    private int time = 100;

    public MenuScreen(DirectedGame game) {
        super(game);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return this;
    }

    /**
     * Initializing all necessary objects
     */
    @Override
    public void show() {
        menuRenderer = new MenuRenderer();
    }

    /**
     * Clearing screen to set color
     * Rendering menu until user touches screen
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(1, 1, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuRenderer.render();
      /*  if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
        }*/
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        ScreenTransition transition = ScreenTransitionSlide.init(0.75f,
                ScreenTransitionSlide.LEFT, false, Interpolation.bounceOut);
        game.setScreen(new SettingsScreen(game), transition);
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
}
