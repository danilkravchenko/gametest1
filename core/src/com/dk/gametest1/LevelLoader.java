package com.dk.gametest1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Крава on 30.10.2015.
 */
public class LevelLoader {
    Array<Ball> balls;
    TimeScore score;
    public LevelLoader(String path){
        init();
    }

    private void init(){
        balls = new Array<Ball>();
        score = new TimeScore();
        for(int i = 0; i < 5; i++){
            Ball ball = new Ball();
            ball.origin.set(ball.getRadius() / 2, ball.getRadius() / 2);
            ball.position.set(MathUtils.random(-Constants.VIEWPORT_WIDTH / 2, Constants.VIEWPORT_WIDTH / 2), MathUtils.random(-Constants.VIEWPORT_HEIGHT / 2, Constants.VIEWPORT_HEIGHT / 2));
            balls.add(ball);
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
