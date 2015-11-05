package com.dk.gametest1.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.dk.gametest1.Constants;

/**
 * This class loads level and holds all game objects, updates them and renders
 * Created by dekay on 30.10.2015.
 */

public class LevelLoader {
    protected Ball[] balls;
    protected TimeScore score;

    public LevelLoader(String path) {
        init();
    }

    /**
     * Initializing all game objects
     */
    private void init() {
        balls = new Ball[Constants.BALLS_QUANTITY];
        score = new TimeScore();
        for (int i = 0; i < Constants.BALLS_QUANTITY; i++) {
            balls[i] = new Ball();
            balls[i].origin.set(balls[i].getRadius() / 2, balls[i].getRadius() / 2);
            balls[i].position.set(MathUtils.random(-Constants.VIEWPORT_WIDTH / 2, Constants.VIEWPORT_WIDTH / 2), MathUtils.random(-Constants.VIEWPORT_HEIGHT / 2, Constants.VIEWPORT_HEIGHT / 2));
        }
    }

    /**
     * updating game objects
     *
     * @param delta
     */
    public void update(float delta) {
        for (Ball ball :
                balls) {
            ball.update(delta);
        }
    }

    /**
     * rendering game objects using batch
     *
     * @param batch
     */
    public void render(SpriteBatch batch) {
        score.render(batch);
        for (Ball ball :
                balls) {
            ball.render(batch);
        }
    }
}
