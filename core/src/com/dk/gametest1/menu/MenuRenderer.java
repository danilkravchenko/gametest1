package com.dk.gametest1.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import com.dk.gametest1.Constants;

/**
 * MenuRenderer renders all elements that should be on menu screen
 * Created by dekay on 03.11.2015.
 */
public class MenuRenderer implements Disposable {
    // private OrthographicCamera camera; //camera is like a user's eyes or a real camera. It has bounds of view which are called ViewPorts
    // private SpriteBatch batch; //spritebatch is like a shit of paper where you can draw everything on it.
    private BitmapFont guiFont;//test font to draw word "Menu"
    private MenuUpdater menuUpdater;

    public MenuRenderer(MenuUpdater menuUpdater) {
        this.menuUpdater = menuUpdater;
        init();
    }

    /**
     * Initializing  fonts, batches, and camera
     */
    private void init() {
        menuUpdater.getCamera().viewportHeight = Constants.VIEWPORT_HEIGHT;
        menuUpdater.getCamera().viewportWidth = Constants.VIEWPORT_WIDTH;
        menuUpdater.getCamera().position.set(menuUpdater.getCamera().viewportWidth / 2, menuUpdater.getCamera().viewportHeight / 2, 0);
        menuUpdater.getCamera().update();

        guiFont = new BitmapFont(Gdx.files.internal("f72.fnt"), true);
        guiFont.setColor(Color.WHITE);
        guiFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    /**
     * Rendering font on the screen
     * for now it's just testing
     */
    public void render() {
        menuUpdater.draw();
    }

    /**
     * Deleting all elements to release memory
     */
    @Override
    public void dispose() {
        guiFont.dispose();
        //batch.dispose();
    }
}
