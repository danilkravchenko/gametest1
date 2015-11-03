package com.dk.gametest1;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Крава on 31.10.2015.
 */
public class TimeScore extends GameObject {
    TextureRegion reg;
    Timer timer;
    long time;

    public TimeScore(){
        init();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(reg.getTexture(),
                position.x, position.y,
                origin.x, origin.y,
                dimension.x, dimension.y,
                scale.x, scale.y,
                rotation,
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }

    private void init(){
        timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                increaseTime();
            }
        }, 1, 1);
        dimension.set(5f, 5f);
        position.set(0 - dimension.x / 2, 0 - dimension.y / 2);
        Pixmap pix = createPixmap();
        Texture texture = new Texture(pix);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        reg = new TextureRegion(texture);
    }

    private Pixmap createPixmap(){
        int radius = Constants.CIRCLE_RADIUS;
        int radius2 = Constants.CIRCLE_RADIUS2;
        Pixmap pixmap = new Pixmap(radius * 2 + 1, radius * 2 + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Constants.LIGHT);
        pixmap.fill();
        pixmap.setColor(Constants.GRAY);
        pixmap.fillCircle(radius, radius, radius);
        pixmap.setColor(Constants.LIGHT);
        pixmap.fillCircle(radius, radius, radius2);
        return pixmap;
    }

    private void increaseTime(){
        time++;
    }
}
