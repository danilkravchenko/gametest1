package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * Pause renderer renders all elements that should be on menu screen
 * Created by dekay on 03.11.2015.
 */
public class PauseRenderer implements Disposable {
    private PauseUpdater pauseUpdater;
    private BitmapFont guiFont;//test font to draw word "Pause"

    public PauseRenderer(PauseUpdater pauseUpdater) {
        this.pauseUpdater = pauseUpdater;
        init();
    }

    private void init() {
        guiFont = new BitmapFont(Gdx.files.internal("f72.fnt"), true);
        guiFont.setColor(Color.BLACK);
        //Setting Linear filters to font
        guiFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        //Creating Orthographic camera with defined Viewports
    }

    /**
     * Rendering font on the screen
     * for now it's just testing
     */
    public void render() {
        pauseUpdater.stage.draw();
    }

    /**
     * Deleting all elements to release memory
     */
    @Override
    public void dispose() {
        guiFont.dispose();
    }
}
