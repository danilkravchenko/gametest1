package com.dk.gametest1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class GameTest1StartClass implements ApplicationListener {

	private GameRenderer gameRenderer;
	private GameUpdater gameUpdater;
	private boolean pause;

	@Override
	public void create () {
		gameUpdater = new GameUpdater();
		gameRenderer = new GameRenderer(gameUpdater);
		pause = false;
	}

	@Override
	public void resize(int width, int height) {
		gameRenderer.resize(width, height);
	}

	@Override
	public void pause() {
		pause = true;
	}

	@Override
	public void resume() {
		pause = false;
	}

	@Override
	public void dispose() {
		gameRenderer.dispose();
	}

	@Override
	public void render () {
		if(!pause){
			gameUpdater.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameRenderer.render();
	}
}