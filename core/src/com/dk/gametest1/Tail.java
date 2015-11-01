package com.dk.gametest1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;

/**
 * Created by Крава on 31.10.2015.
 */
public class Tail extends GameObject{
    TextureRegion reg;
    Vector2 deltaStep;
    public Tail(){
        this.init();
    }

    private void init(){
        deltaStep = new Vector2();
        Pixmap pix = createTailPixmap();
        Texture texture = new Texture(pix);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        reg = new TextureRegion(texture);
    }

    private Pixmap createTailPixmap(){
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
    }

   public void update(float delta){
       super.update(delta);
   }

    public void render(SpriteBatch batch){
        batch.draw(reg.getTexture(),
                position.x, position.y,
                origin.x, origin.y,
                dimension.x, dimension.y,
                scale.x, scale.y,
                rotation,
                reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(),
                false, false);
    }
}
