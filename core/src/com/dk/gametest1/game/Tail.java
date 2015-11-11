//package com.dk.gametest1.game;

/**
 * Tail of ball
 /* * Created by dekay on 31.10.2015.
 *//*
public class Tail extends Actor {
    Vector2 deltaStep;
    private TextureRegion reg; //Texture for tail

    public Tail() {
        this.init();
    }

    *//**
     * inititalizing the tail
 *//*
    private void init() {
        deltaStep = new Vector2();
        Pixmap pix = createTailPixmap();
        Texture texture = new Texture(pix);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        reg = new TextureRegion(texture);
    }

    *//**
     * Creating visual representation for tail using outer and inner radius and color
     *
     * @return pixmap
 *//*
   *//* private Pixmap createTailPixmap() {
       int radius = Constants.CIRCLE_RADIUS;
        int radius2 = Constants.CIRCLE_RADIUS2;
        Pixmap pixmap = new Pixmap(radius * 2 + 1, radius * 2 + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 1, 1, 0);
        pixmap.fill();
        pixmap.setColor(0, 0, 0, 1);
        pixmap.fillCircle(radius, radius, radius);
        pixmap.setColor(1, 1, 1, 1);
        pixmap.fillCircle(radius, radius, radius2);
        return pixmap;
    }*//*

    *//**
     * updating position of the tail
     *
     * @param delta - time between current frame and last one in seconds
 *//*

    @Override
    public void act(float delta) {

    }

    *//**
     * rendering tail using spritebatch and all features of the tail
     *
     * @param batch
 *//*
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(reg.getTexture(),
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation(),
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }
}*/
