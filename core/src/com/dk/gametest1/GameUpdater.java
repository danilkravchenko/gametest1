package com.dk.gametest1;

/**
 * Created by Крава on 30.10.2015.
 */
public class GameUpdater {
    LevelLoader level;
    public GameUpdater(){
        init();
    }

    private void init(){
        level = new LevelLoader("dddd");
    }

    private void countCollisions() {

    }

    public void update(float delta){
        countCollisions();
        level.update(delta);
    }

}
