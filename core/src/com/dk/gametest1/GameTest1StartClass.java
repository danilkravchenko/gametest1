package com.dk.gametest1;

import com.badlogic.gdx.Game;


public class GameTest1StartClass extends Game{
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}
}