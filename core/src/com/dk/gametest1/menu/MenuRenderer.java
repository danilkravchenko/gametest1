package com.dk.gametest1.menu;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.dk.gametest1.Constants;

/**
 * MenuRenderer renders all elements that should be on menu screen
 * Created by dekay on 03.11.2015.
 */
public class MenuRenderer implements Disposable {
    private OrthographicCamera camera; //camera is like a user's eyes or a real camera. It has bounds of view which are called ViewPorts
    private SpriteBatch batch; //spritebatch is like a shit of paper where you can draw everything on it.
    private BitmapFont guiFont;//test font to draw word "Menu"

    public MenuRenderer() {
        init();
    }

    /**
     * Initializing  fonts, batches, and camera
     */
    private void init() {
        batch = new SpriteBatch();
        guiFont = new BitmapFont(Gdx.files.internal("f72.fnt"), true);
        guiFont.setColor(Color.WHITE);
        //Setting Linear filters to font
        guiFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        //Creating Orthographic camera with defined Viewports
        camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        camera.position.set(0, 0, 0);
        //flip Y axis
        camera.setToOrtho(true);
        camera.update();
    }

    /**
     * Rendering font on the screen
     * for now it's just testing
     */
    public void render() {
        float scale;
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            scale = Constants.DESKTOP_SCALE_X;
        } else {
            scale = Constants.MOBILE_SCALE_X;
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        guiFont.draw(batch, "MENU", camera.position.x - scale * (Constants.FONT_SIZE / 4 - 2), camera.position.y - scale * (Constants.FONT_SIZE / 4 + 4));
        batch.end();
    }

    /**
     * Deleting all elements to release memory
     */
    @Override
    public void dispose() {
        guiFont.dispose();
        batch.dispose();
    }
}
