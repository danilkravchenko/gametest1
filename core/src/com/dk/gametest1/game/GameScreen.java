package com.dk.gametest1.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.dk.gametest1.AbstractScreen;
import com.dk.gametest1.Constants;
import com.dk.gametest1.menu.MenuScreen;
import com.dk.gametest1.pause.PauseRenderer;
import com.dk.gametest1.pause.PauseUpdater;

/**
 * Just game screen
 * Created by dekay on 03.11.2015.
 */
public class GameScreen extends AbstractScreen {
    public static GAME_STATE gameState;
    private GameRenderer gameRenderer;
    private GameUpdater gameUpdater;
    private PauseUpdater pauseUpdater;
    private PauseRenderer pauseRenderer;

    public GameScreen(Game game) {
        super(game);
        gameUpdater = new GameUpdater(game);
        gameRenderer = new GameRenderer(gameUpdater);
        pauseUpdater = new PauseUpdater(this);
        pauseRenderer = new PauseRenderer(pauseUpdater);
    }

    /**
     * The same as init method
     * setCatchBackKey allows to catch action when user presses back button
     */
    @Override
    public void show() {
        changeBeforeRender();
    }

    public void changeBeforeRender() {
        Gdx.input.setCatchBackKey(true);
        Gdx.input.setInputProcessor(this);
        gameState = GAME_STATE.RUNNING;
        gameUpdater.level.score.startTimer();
    }

    public void backToMenu() {
        game.setScreen(new MenuScreen(game));
    }

    /**
     * Updating world if pause if false and rendering whenever the pause is true or false
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Constants.LIGHT.r, Constants.LIGHT.g, Constants.LIGHT.b, 1f);//Clears the screen to color set in parameters
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        switch (gameState) {
            case RUNNING:
                gameUpdater.update(delta);
                gameRenderer.render();
                break;
            case PAUSED:
                pauseUpdater.update(delta);
                pauseRenderer.render();
                break;
        }
    }

    /**
     * Occurs if the screen size has been changed
     *
     * @param width  new width
     * @param height new height
     */
    @Override
    public void resize(int width, int height) {
        //Empty method, all necessary changes are being done in StartClass
    }

    /**
     * If game is being paused
     */
    @Override
    public void pause() {
        System.out.println("pause");
        if (gameState == GAME_STATE.RUNNING) {
            gameState = GAME_STATE.PAUSED;
            pauseGame(Gdx.input.getX(), Gdx.input.getY());
        }
    }

    /**
     * The same as dispose method
     */
    @Override
    public void hide() {
        System.out.println("hide");
        gameRenderer.dispose();
        pauseRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

    @Override
    public void resume() {
        super.resume();
    }

    /**
     * Occurs the user releases mouse or finger
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     * @return
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (gameState == GAME_STATE.RUNNING)
            pauseGame(screenX, screenY);
        return false;
    }

    /**
     * Pause the game
     *
     * @param x
     * @param y
     */
    private void pauseGame(int x, int y) {
        pauseUpdater.setPauseCirclePosition(x, y);
        gameUpdater.level.score.stopTimer();
        gameState = GAME_STATE.PAUSED;
    }

    /**
     * Game states
     */
    public enum GAME_STATE {
        RUNNING,
        PAUSED,
        JUST_STARTED
    }
}
