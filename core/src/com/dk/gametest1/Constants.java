package com.dk.gametest1;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Крава on 30.10.2015.
 */

public class Constants {
    public static final int BALLS_QUANTITY = 5;     //easy - 3, medium - 4, hard - 5 (посмотрим как будет с препятствиями)
    public static final float BALL_RADIUS = 0.8f;   //размер шарика

    public static float VIEWPORT_WIDTH = 10.0f;
    public static float VIEWPORT_HEIGHT = 10.0f;

    public static float VIEWPORT_GUI_WIDTH = 640;
    public static float VIEWPORT_GUI_HEIGHT = 480;

    public static final int SMALL_BALL_RADIUS_FOR_BITMAP = 128;
    public static final float SMALL_BALL_SPEED = 25f;   //easy - 15, medium - 20, hard - 25

    public static final int CIRCLE_RADIUS = 150;        //timer outer radius
    public static final int CIRCLE_RADIUS2 = 143;       //timer inner radius

    public static float MOBILE_SCALE_X = 1;
    public static float DESKTOP_SCALE_X = 1;

    public static final int FONT_SIZE = 72;

    public static final Color DARK = new Color(0.066f, 0.094f, 0.121f, 1);
    public static final Color LIGHT = new Color(0.95f, 0.95f, 0.95f, 1);
    public static final Color GRAY = new Color(0.87f, 0.87f, 0.87f, 1);
}
