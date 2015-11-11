package com.dk.gametest1.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dk.gametest1.Assets;
import com.dk.gametest1.Constants;

/**
 * Created by Крава on 11.11.2015.
 */
public class Background extends Actor {
    private TextureRegion reg;

    public Background() {
        init();
    }

    private void init() {
        reg = Assets.instance.background.back;
        setSize(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        setPosition(-Constants.VIEWPORT_WIDTH / 2, -Constants.VIEWPORT_HEIGHT / 2);
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
