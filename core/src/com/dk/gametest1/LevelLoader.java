package com.dk.gametest1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Крава on 30.10.2015.
 */

public class LevelLoader {
    Ball[] balls;
    TimeScore score;
    public LevelLoader(String path){
        init();
    }

    private void init(){
        balls = new Ball[Constants.BALLS_QUANTITY];
        score = new TimeScore();
        for(int i = 0; i < Constants.BALLS_QUANTITY; i++){
            balls[i] = new Ball();
            balls[i].origin.set(balls[i].getRadius() / 2, balls[i].getRadius() / 2);
            balls[i].position.set(MathUtils.random(-Constants.VIEWPORT_WIDTH / 2, Constants.VIEWPORT_WIDTH / 2), MathUtils.random(-Constants.VIEWPORT_HEIGHT / 2, Constants.VIEWPORT_HEIGHT / 2));
        }
    }

    public void update(float delta){
        for (Ball ball :
                balls) {
            ball.update(delta);
        }
    }

    public void render(SpriteBatch batch){
        score.render(batch);
        for (Ball ball :
                balls) {
            ball.render(batch);
        }

    }
}
