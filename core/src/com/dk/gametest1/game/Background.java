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
    private TextureRegion backReg;
    private Circle circle;

    public Background() {
        init();
    }

    private void init() {
        backReg = Assets.instance.background.back;
        circle = new Circle();
        setSize(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        setPosition(-Constants.VIEWPORT_WIDTH / 2, -Constants.VIEWPORT_HEIGHT / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(backReg.getTexture(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation(),
                backReg.getRegionX(), backReg.getRegionY(),
                backReg.getRegionWidth(), backReg.getRegionHeight(),
                false, false);
        circle.draw(batch, parentAlpha);
    }

    class Circle extends Actor {
        private TextureRegion circleReg;

        public Circle() {
            init();
        }

        private void init() {
            circleReg = Assets.instance.timerCircle.circle;
            setSize(Constants.TIMER_CIRCLE_RADIUS, Constants.TIMER_CIRCLE_RADIUS);
            setPosition(0 - Constants.TIMER_CIRCLE_RADIUS / 2f, 0 - Constants.TIMER_CIRCLE_RADIUS / 2f);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(circleReg.getTexture(),
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation(),
                    circleReg.getRegionX(), circleReg.getRegionY(),
                    circleReg.getRegionWidth(), circleReg.getRegionHeight(),
                    false, false);
        }
    }
}
