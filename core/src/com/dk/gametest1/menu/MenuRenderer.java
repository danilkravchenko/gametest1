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
 * Created by Крава on 03.11.2015.
 */
public class MenuRenderer implements Disposable {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont guiFont;

    @Override
    public void dispose() {
        guiFont.dispose();
        batch.dispose();
    }

    public MenuRenderer() {
        init();
    }

    private void init() {
        batch = new SpriteBatch();
        guiFont = new BitmapFont(Gdx.files.internal("f72.fnt"), true);
        guiFont.setColor(Color.WHITE);
        guiFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.setToOrtho(true);
        camera.update();
    }

    public void resize(int width, int height) {
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            Constants.VIEWPORT_GUI_WIDTH = width / (height / Constants.VIEWPORT_GUI_HEIGHT);
            camera.viewportWidth = Constants.VIEWPORT_GUI_WIDTH;
            Constants.DESKTOP_SCALE_X = width / Constants.VIEWPORT_GUI_WIDTH;
            guiFont.getData().setScale(Constants.DESKTOP_SCALE_X);

        } else {
            Constants.VIEWPORT_GUI_HEIGHT = height / (width / Constants.VIEWPORT_GUI_WIDTH);
            camera.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;

            Constants.MOBILE_SCALE_X = height / Constants.VIEWPORT_GUI_HEIGHT;
            guiFont.getData().setScale(Constants.MOBILE_SCALE_X);
        }
        camera.position.set(camera.viewportWidth / 2,
                camera.viewportHeight / 2, 0);
        camera.update();
    }

    public void render() {
        float scale;
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            scale = Constants.DESKTOP_SCALE_X;
            ;
        } else {
            scale = Constants.MOBILE_SCALE_X;
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        guiFont.draw(batch, "MENU", camera.position.x - scale * (Constants.FONT_SIZE / 4 - 2), camera.position.y - scale * (Constants.FONT_SIZE / 4 + 4));
        batch.end();
    }
}
