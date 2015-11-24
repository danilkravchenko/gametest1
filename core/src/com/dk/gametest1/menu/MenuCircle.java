package com.dk.gametest1.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dk.gametest1.Assets;

/**
 * Created by Крава on 24.11.2015.
 */
public class MenuCircle extends Actor {
    private TextureRegion reg;

    public MenuCircle() {
        init();
    }

    private void init() {
        reg = Assets.instance.menuCircle.menuCircle;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        System.out.println(reg.getRegionX() + " " + reg.getRegionY());
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
