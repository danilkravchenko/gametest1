package com.dk.gametest1.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.dk.gametest1.Constants;

/**
 * TimeScore or timer on the game screen
 * Created by dekay on 31.10.2015.
 */
public class TimeScore extends Actor {
    protected long time; //time since the game has been started
    private TextureRegion reg; //Texture for TimeScore
    private Timer timer; //Timer

    public TimeScore() {
        init();
    }

    /**
     * initializing everything connected with timeScore
     */
    private void init() {
        timer = new Timer();
        //every second timer calls method increaseTime
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                increaseTime();
            }
        }, 1, 1);
        timer.stop();
        setSize(5f, 5f);
        setPosition(0 - getWidth() / 2, 0 - getHeight() / 2);
        Pixmap pix = createPixmap();
        Texture texture = new Texture(pix);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        reg = new TextureRegion(texture);
    }

    /**
     * creating visual representatiton of the timeScore using color, outer and inner radius
     *
     * @return pixmap
     */
    private Pixmap createPixmap() {
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

    /**
     * rendering timescore using all features
     *
     * @param spriteBatch
     */
    @Override
    public void draw(Batch spriteBatch, float parentAlpha) {
        spriteBatch.draw(reg.getTexture(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation(),
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }

    /**
     * increasing time
     */
    private void increaseTime() {
        time++;
    }

    public void stopTimer() {
        timer.stop();
    }

    public void startTimer() {
        timer.start();
    }
}
