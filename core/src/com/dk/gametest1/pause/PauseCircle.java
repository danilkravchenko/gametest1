package com.dk.gametest1.pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dk.gametest1.Assets;
import com.dk.gametest1.Constants;

/**
 * Created by Крава on 07.11.2015.
 */
public class PauseCircle extends Actor {

    private TextureRegion reg;

    public PauseCircle() {
        init();
    }

    private void init() {
        reg = Assets.instance.pauseCircle.pCircle;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void setPosition(float x, float y) {
        float nX = x * Constants.VIEWPORT_WIDTH / Gdx.graphics.getWidth();
        float nY = y * Constants.VIEWPORT_HEIGHT / Gdx.graphics.getHeight();
        super.setPosition(nX - getWidth() / 2, nY - getHeight() / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(reg.getTexture(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation(),
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }
}
