package com.dk.gametest1.pause;

import com.badlogic.gdx.utils.Disposable;
import com.dk.gametest1.Constants;

/**
 * Pause renderer renders all elements that should be on menu screen
 * Created by dekay on 03.11.2015.
 */
public class PauseRenderer implements Disposable {
    private PauseUpdater pauseUpdater;

    public PauseRenderer(PauseUpdater pauseUpdater) {
        this.pauseUpdater = pauseUpdater;
        init();
    }

    private void init() {
        pauseUpdater.getCamera().viewportHeight = Constants.VIEWPORT_HEIGHT;
        pauseUpdater.getCamera().viewportWidth = Constants.VIEWPORT_WIDTH;
        pauseUpdater.getCamera().position.set(pauseUpdater.getCamera().viewportWidth / 2, pauseUpdater.getCamera().viewportHeight / 2, 0);
        pauseUpdater.getCamera().update();
    }

    /**
     * Rendering font on the screen
     * for now it's just testing
     */
    public void render() {
        pauseUpdater.draw();
    }

    /**
     * Deleting all elements to release memory
     */
    @Override
    public void dispose() {
    }
}
