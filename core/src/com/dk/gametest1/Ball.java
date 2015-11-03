package com.dk.gametest1;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Крава on 30.10.2015.
 */
public class Ball extends GameObject{
    private Pixmap pixmap;
    private TextureRegion textureRegion;
    private int radius;
    Tail bigTail;
    private Tail smallTail;
    Vector2 previousPos;

    public int getRadius() {
        return radius;
    }

    public Ball(){
        init();
    }

    private void init(){
        previousPos = new Vector2();
        radius = Constants.SMALL_BALL_RADIUS_FOR_BITMAP;
        dimension.set(Constants.BALL_RADIUS, Constants.BALL_RADIUS);
        cirBounds = new Circle(0, 0, getSmallestDimension());

        angle = MathUtils.random(0, MathUtils.PI * 2);
        speedXY.x = Constants.SMALL_BALL_SPEED * MathUtils.cos(angle);
        speedXY.y = Constants.SMALL_BALL_SPEED * MathUtils.sin(angle);

        pixmap = createBallPixmap();
        Texture texture = new Texture(pixmap);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureRegion = new TextureRegion(texture);

        bigTail = new Tail();
        bigTail.dimension.set(0.3f, 0.3f);
        bigTail.origin.set(Constants.CIRCLE_RADIUS/2,Constants.CIRCLE_RADIUS/2);
        bigTail.deltaStep.set(0, 0.5f);
        bigTail.speedXY.set(speedXY);

        smallTail = new Tail();
        smallTail.dimension.set(0.2f, 0.2f);
        smallTail.origin.set(Constants.CIRCLE_RADIUS2/2,Constants.CIRCLE_RADIUS2/2);
        smallTail.deltaStep.set(0f, 0.9f);
        smallTail.speedXY.set(speedXY);
    }

    private Pixmap createBallPixmap(){
        Pixmap pixmap = new Pixmap(radius * 2 + 1, radius * 2 + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Constants.DARK);
        pixmap.fillCircle(radius, radius, radius);
        return pixmap;
    }


    @Override
    public void render(SpriteBatch spriteBatch) {
        bigTail.render(spriteBatch);
        smallTail.render(spriteBatch);
        spriteBatch.draw(textureRegion.getTexture(),
                position.x, position.y,
                origin.x, origin.y,
                dimension.x, dimension.y,
                scale.x, scale.y,
                rotation,
                textureRegion.getRegionX(), textureRegion.getRegionY(),
                textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                false, false);
    }

    public void update(float deltaTime){
        float coA = speedXY.x / Constants.SMALL_BALL_SPEED;
        float siA = speedXY.y / Constants.SMALL_BALL_SPEED;
        bigTail.position.set(position.x - bigTail.deltaStep.y * coA + dimension.x / 2 - bigTail.dimension.x / 2,
                    position.y - bigTail.deltaStep.y * siA + dimension.y / 2 - bigTail.dimension.y / 2);
        smallTail.position.set(position.x - smallTail.deltaStep.y * coA  + dimension.x / 2 - smallTail.dimension.x / 2,
                    position.y - smallTail.deltaStep.y * siA + dimension.y / 2 - smallTail.dimension.y / 2);
        super.update(deltaTime);
        bigTail.update(deltaTime);
        smallTail.update(deltaTime);
    }

    public float getSmallestDimension(){
        return dimension.x > dimension.y ? dimension.x/2 : dimension.y / 2;
    }
}
