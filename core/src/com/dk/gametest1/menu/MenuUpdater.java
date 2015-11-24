package com.dk.gametest1.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dk.gametest1.Constants;

/**
 * Created by Крава on 24.11.2015.
 */
public class MenuUpdater extends Stage {
    private MenuCircle menuCircle;

    public MenuUpdater() {
        init();
    }

    private void init() {
        menuCircle = new MenuCircle();
        menuCircle.setSize(4.0f, 4.0f);
        menuCircle.setPosition(Constants.VIEWPORT_WIDTH / 2 - menuCircle.getWidth() / 2, Constants.VIEWPORT_HEIGHT / 2 - menuCircle.getHeight() / 2);
        this.addActor(menuCircle);
    }

}
