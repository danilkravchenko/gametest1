package com.dk.gametest1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class GameTest1StartClass extends Game{
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}