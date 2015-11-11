package com.dk.gametest1.game;

import com.badlogic.gdx.utils.Timer;

/**
 * TimeScore or timer on the game screen
 * Created by dekay on 31.10.2015.
 */
public class TimeScore {
    protected long time; //time since the game has been started
    private Timer timer; //Timer

    public TimeScore() {
        init();
    }

    /**
     * initializing everything connected with timeScore
     */
    private void init() {
        timer = new Timer();
        //every second timer calls method increaseTime
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                increaseTime();
            }
        }, 1, 1);
        timer.stop();
    }

    /**
     * increasing time
     */
    private void increaseTime() {
        time++;
    }

    public void stopTimer() {
        timer.stop();
    }

    public void startTimer() {
        timer.start();
    }
}
