package com.dk.gametest1;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Крава on 30.10.2015.
 */
public class GameRenderer implements Disposable {
    private GameUpdater gameUpdater;
    SpriteBatch spriteBatch;
    OrthographicCamera camera;
    OrthographicCamera cameraGUI;
    BitmapFont guiFont;

    public GameRenderer(GameUpdater gameUpdater){
        this.gameUpdater = gameUpdater;
        init();
    }

    private void init(){
        guiFont = new BitmapFont(Gdx.files.internal("f72.fnt"), true);
        guiFont.setColor(Color.BLACK);
        guiFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        spriteBatch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        cameraGUI.position.set(0, 0, 0);
        cameraGUI.setToOrtho(true);
        cameraGUI.update();
        camera.update();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        guiFont.dispose();
    }

    public void resize(int width, int height){
        if(Gdx.app.getType() == Application.ApplicationType.Desktop){
            Constants.VIEWPORT_WIDTH = width / (height / Constants.VIEWPORT_HEIGHT);
            camera.viewportWidth = Constants.VIEWPORT_WIDTH;

            Constants.VIEWPORT_GUI_WIDTH = width / (height / Constants.VIEWPORT_GUI_HEIGHT);
            cameraGUI.viewportWidth = Constants.VIEWPORT_GUI_WIDTH;

            Constants.DESKTOP_SCALE_X = width/Constants.VIEWPORT_GUI_WIDTH;
            guiFont.getData().setScale(Constants.DESKTOP_SCALE_X);

        }else {
            Constants.VIEWPORT_HEIGHT = height / (width / Constants.VIEWPORT_WIDTH);
            camera.viewportHeight = Constants.VIEWPORT_HEIGHT;

            Constants.VIEWPORT_GUI_HEIGHT = height / (width / Constants.VIEWPORT_GUI_WIDTH);
            cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;

            Constants.MOBILE_SCALE_X = height / Constants.VIEWPORT_GUI_HEIGHT;
            guiFont.getData().setScale(Constants.MOBILE_SCALE_X);
        }

        cameraGUI.position.set(cameraGUI.viewportWidth / 2,
                cameraGUI.viewportHeight / 2, 0);
        cameraGUI.update();

        camera.update();
    }

    public void render(){
        renderGame(spriteBatch);
        renderGUI(spriteBatch);
    }

    private void renderGame(SpriteBatch batch){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        gameUpdater.level.render(batch);
        batch.end();
    }

    private void renderGUI(SpriteBatch batch){
        renderGUITimer(batch);
    }

    private void renderGUITimer(SpriteBatch batch){
        float scale;
        if(Gdx.app.getType() == Application.ApplicationType.Desktop){
            scale = Constants.DESKTOP_SCALE_X;;
        }else {
            scale = Constants.MOBILE_SCALE_X;
        }
        batch.setProjectionMatrix(cameraGUI.combined);
        batch.begin();
        long time = gameUpdater.level.score.time;
        if(time < 10){
            guiFont.draw(batch, String.valueOf(time), cameraGUI.position.x - scale * (Constants.FONT_SIZE / 4 - 2), cameraGUI.position.y - scale * (Constants.FONT_SIZE / 4 + 4));
        }else if(time >= 10 && time < 100){
            guiFont.draw(batch, String.valueOf(time), cameraGUI.position.x - scale * (Constants.FONT_SIZE / 2 - 2), cameraGUI.position.y - scale * (Constants.FONT_SIZE / 4 + 4));
        }else{
            guiFont.draw(batch, String.valueOf(time), cameraGUI.position.x - scale * (Constants.FONT_SIZE/2 + Constants.FONT_SIZE/4 - 2), cameraGUI.position.y - scale * (Constants.FONT_SIZE / 4 + 4));
        }
        batch.end();
    }
}
