package com.dk.gametest1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Крава on 30.10.2015.
 */

public abstract class GameObject {
    Vector2 position;
    Vector2 origin;
    Vector2 scale;
    Vector2 dimension;
    int rotation;
    float angle;
    Vector2 speedXY;
    Rectangle recBounds;
    Circle cirBounds;

    public GameObject(){
        position = new Vector2();
        recBounds = new Rectangle();
        cirBounds = new Circle();
        origin = new Vector2();
        scale = new Vector2(1f, 1f);
        rotation = 0;
        dimension = new Vector2(1f, 1f);
        angle = 0;
        speedXY = new Vector2();
    }

    public void update(float delta){
        updateX(delta);
        updateY(delta);
    }

    private void updateX(float delta) {
        position.x += speedXY.x * delta;
        if(position.x >= Constants.VIEWPORT_WIDTH / 2 - dimension.x){
            position.x = Constants.VIEWPORT_WIDTH / 2 - dimension.x;
            speedXY.x = -speedXY.x;
        }

        if(position.x <= -Constants.VIEWPORT_WIDTH / 2){
            position.x = -Constants.VIEWPORT_WIDTH / 2;
            speedXY.x = -speedXY.x;
        }
    }

    private void updateY(float delta){
        position.y += speedXY.y * delta;
        if(position.y >= Constants.VIEWPORT_HEIGHT / 2 - dimension.y){
            position.y = Constants.VIEWPORT_HEIGHT / 2 - dimension.y;
            speedXY.y = -speedXY.y;
        }
        if(position.y <= -Constants.VIEWPORT_HEIGHT / 2){
            position.y = -Constants.VIEWPORT_HEIGHT / 2;
            speedXY.y = -speedXY.y;
        }
    }

    public abstract void render(SpriteBatch spriteBatch);
}
