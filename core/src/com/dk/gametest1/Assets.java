package com.dk.gametest1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Крава on 07.11.2015.
 */
public class Assets implements Disposable, AssetErrorListener {
    public static final String TEXTURE_ATLAS = "text.pack";
    public static final Assets instance = new Assets();
    public PauseCircle pauseCircle;
    public Background background;
    public TimerCircle timerCircle;
    private AssetManager assetManager;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas atlas = assetManager.get(TEXTURE_ATLAS);
        pauseCircle = new PauseCircle(atlas);
        background = new Background(atlas);
        timerCircle = new TimerCircle(atlas);
    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error("Assets", "Couldn't load asset '"
                + asset.fileName + "'", throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PauseCircle {
        public final TextureAtlas.AtlasRegion pCircle;

        public PauseCircle(TextureAtlas atlas) {
            pCircle = atlas.findRegion("pause_circle");
        }
    }

    public class Background {
        public final TextureAtlas.AtlasRegion back;

        public Background(TextureAtlas atlas) {
            back = atlas.findRegion("back");
        }
    }

    public class TimerCircle {
        public final TextureAtlas.AtlasRegion circle;

        public TimerCircle(TextureAtlas atlas) {
            circle = atlas.findRegion("timer_circle");
        }
    }
}
