package com.dk.gametest1.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dk.gametest1.Constants;

/**
 * Class Ball is being used for generating balls for game
 * Created by dekay on 30.10.2015.
 */
public class Ball extends Actor {
    protected float angle; //direction of moving
    protected Vector2 speedXY; //speed in m/s
    protected Circle bounds; //physical representation for ball
    private Pixmap pixmap; //visual representation for ball
    private TextureRegion textureRegion; //texture for ball
    private int radius; //radius of bitmap
    private Tail bigTail; //everything is clear
    private Tail smallTail;

    public Ball() {
        init();
    }

    public int getRadius() {
        return radius;
    }

    /**
     * Initializing everything connected with ball
     */
    private void init() {
        speedXY = new Vector2();
        radius = Constants.SMALL_BALL_RADIUS_FOR_BITMAP;
        setSize(Constants.BALL_RADIUS, Constants.BALL_RADIUS);
        bounds = new Circle(0, 0, getHeight() / 2);

        //Randomly calculating the start angle between direction of ball and X axis
        //and calculating speed in m/s
        angle = MathUtils.random(0, MathUtils.PI * 2);
        speedXY.x = Constants.SMALL_BALL_SPEED * MathUtils.cos(angle);
        speedXY.y = Constants.SMALL_BALL_SPEED * MathUtils.sin(angle);

        //Creating pixmap and texture for ball and adding Linear filter to the texture
        pixmap = createBallPixmap();
        Texture texture = new Texture(pixmap);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureRegion = new TextureRegion(texture);

    /*    //Creating bigTail
        bigTail = new Tail();
        bigTail.dimension.set(0.3f, 0.3f);
        bigTail.origin.set(Constants.CIRCLE_RADIUS / 2, Constants.CIRCLE_RADIUS / 2);
        bigTail.deltaStep.set(0, 0.5f);
        bigTail.speedXY.set(speedXY);

        //Creating smallTail
        smallTail = new Tail();
        smallTail.dimension.set(0.2f, 0.2f);
        smallTail.origin.set(Constants.CIRCLE_RADIUS2 / 2, Constants.CIRCLE_RADIUS2 / 2);
        smallTail.deltaStep.set(0f, 0.9f);
        smallTail.speedXY.set(speedXY);*/
    }

    /**
     * Creating visual representation of ball using radius and color
     *
     * @return pixmap
     */
    private Pixmap createBallPixmap() {
        Pixmap pixmap = new Pixmap(radius * 2 + 1, radius * 2 + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Constants.DARK);
        pixmap.fillCircle(radius, radius, radius);
        return pixmap;
    }

    /**
     * Drawing the ball using batch
     * This method uses all features of ball
     *
     * @param spriteBatch
     */
    @Override
    public void draw(Batch spriteBatch, float parentAlpha) {
        // bigTail.render(spriteBatch);
        // smallTail.render(spriteBatch);
        spriteBatch.draw(textureRegion.getTexture(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation(),
                textureRegion.getRegionX(), textureRegion.getRegionY(),
                textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                false, false);
    }

    /**
     * Updating tails' and ball's positions
     *
     * @param delta - time between current frame and last one in seconds
     */
    public void update(float delta) {
       /* float coA = speedXY.x / Constants.SMALL_BALL_SPEED;
        float siA = speedXY.y / Constants.SMALL_BALL_SPEED;
        bigTail.position.set(position.x - bigTail.deltaStep.y * coA + dimension.x / 2 - bigTail.dimension.x / 2,
                position.y - bigTail.deltaStep.y * siA + getHeight( / 2 - bigTail.getHeight( / 2);
        smallTail.position.set(position.x - smallTail.deltaStep.y * coA + dimension.x / 2 - smallTail.dimension.x / 2,
                position.y - smallTail.deltaStep.y * siA + getHeight( / 2 - smallTail.getHeight( / 2);
        super.update(delta);
        bigTail.update(delta);
        smallTail.update(delta);*/
    }

    /**
     * updating ball's position
     * @param delta
     */
    @Override
    public void act(float delta) {
        updateX(delta);
        updateY(delta);
    }

    /**
     * Updating X axis of object and changing the direction if the objects position is near the X bounds of the screen
     *
     * @param delta - time between current frame and last one in seconds
     */
    private void updateX(float delta) {
        setX(getX() + speedXY.x * delta);
        if (getX() >= Constants.VIEWPORT_WIDTH / 2 - getWidth()) {
            setX(Constants.VIEWPORT_WIDTH / 2 - getWidth());
            speedXY.x = -speedXY.x;
        }

        if (getX() <= -Constants.VIEWPORT_WIDTH / 2) {
            setX(-Constants.VIEWPORT_WIDTH / 2);
            speedXY.x = -speedXY.x;
        }
    }

    /**
     * Updating Y axis of object and changing the direction if the objects position is near the Y bounds of the screen
     *
     * @param delta - time between current frame and last one in seconds
     */
    private void updateY(float delta) {
        setY(getY() + speedXY.y * delta);
        if (getY() >= Constants.VIEWPORT_HEIGHT / 2 - getHeight()) {
            setY(Constants.VIEWPORT_HEIGHT / 2 - getHeight());
            speedXY.y = -speedXY.y;
        }
        if (getY() <= -Constants.VIEWPORT_HEIGHT / 2) {
            setY(-Constants.VIEWPORT_HEIGHT / 2);
            speedXY.y = -speedXY.y;
        }
    }
}
