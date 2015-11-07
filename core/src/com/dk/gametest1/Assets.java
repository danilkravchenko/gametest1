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
    public static final String TEXTURE_ATLAS = "unamed.pack";
    public static final Assets instance = new Assets();
    public PauseCircle pauseCircle;
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
    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error("Assets", "Couldn't load asset '"
                + asset.fileName + "'", (Exception) throwable);
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
}
