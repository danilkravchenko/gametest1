package com.dk.gametest1.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dk.gametest1.Constants;

/**
 * Abstract class for all out game objects
 * Created by dekay on 30.10.2015.
 */

public abstract class GameObject {
    protected Vector2 position; //position of the object on the screen
    protected Vector2 origin; //point of origin of the object
    protected Vector2 scale; //scale of the object
    protected Vector2 dimension; //size on the screen
    protected int rotation;
    protected float angle; //direction of moving
    protected Vector2 speedXY; //X and Y axes speed (m/s)
    protected Rectangle recBounds;//Physical representation of object
    protected Circle cirBounds;//Physical representation of object

    public GameObject() {
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

    /**
     * Updating objects
     *
     * @param delta - time between current frame and last one in seconds
     */
    public void update(float delta) {
        updateX(delta);
        updateY(delta);
    }

    /**
     * Updating X axis of object and changing the direction if the objects position is near the X bounds of the screen
     *
     * @param delta - time between current frame and last one in seconds
     */
    private void updateX(float delta) {
        position.x += speedXY.x * delta;
        if (position.x >= Constants.VIEWPORT_WIDTH / 2 - dimension.x) {
            position.x = Constants.VIEWPORT_WIDTH / 2 - dimension.x;
            speedXY.x = -speedXY.x;
        }

        if (position.x <= -Constants.VIEWPORT_WIDTH / 2) {
            position.x = -Constants.VIEWPORT_WIDTH / 2;
            speedXY.x = -speedXY.x;
        }
    }

    /**
     * Updating Y axis of object and changing the direction if the objects position is near the Y bounds of the screen
     *
     * @param delta - time between current frame and last one in seconds
     */
    private void updateY(float delta) {
        position.y += speedXY.y * delta;
        if (position.y >= Constants.VIEWPORT_HEIGHT / 2 - dimension.y) {
            position.y = Constants.VIEWPORT_HEIGHT / 2 - dimension.y;
            speedXY.y = -speedXY.y;
        }
        if (position.y <= -Constants.VIEWPORT_HEIGHT / 2) {
            position.y = -Constants.VIEWPORT_HEIGHT / 2;
            speedXY.y = -speedXY.y;
        }
    }

    public abstract void render(SpriteBatch spriteBatch);
}
