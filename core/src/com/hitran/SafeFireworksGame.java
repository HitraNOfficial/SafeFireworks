package com.hitran;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hitran.helper.ParticleEffectGenerator;

public class SafeFireworksGame extends ApplicationAdapter {
	private static final float WIDTH = 1920;
	private static final float HEIGHT = 1080;

	private SpriteBatch batch;
	private Texture background;

	private OrthographicCamera camera;
	private Viewport gamePort;
	private float viewportX, viewportY, viewportWidth, viewportHeight;

	private ParticleEffectGenerator particleEffectGenerator;
	
	@Override
	public void create () {
		Vector2 size = Scaling.fit.apply(WIDTH, HEIGHT, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewportX = (Gdx.graphics.getWidth() - size.x) / 2;
		viewportY = (Gdx.graphics.getHeight() - size.y) / 2;
		viewportWidth = size.x;
		viewportHeight = size.y;

		camera = new OrthographicCamera();
		gamePort = new FitViewport(WIDTH, HEIGHT, camera);
		gamePort.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

		batch = new SpriteBatch();
		background = new Texture("background.png");

		particleEffectGenerator = new ParticleEffectGenerator();
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0);

		particleEffectGenerator.render(batch, Gdx.graphics.getDeltaTime());

		batch.end();
	}

	private void update(float dt) {
		camera.update();

		if (Gdx.input.justTouched()) {

			Vector3 press = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			Vector3 camCoordinates = camera.unproject(press, viewportX, viewportY, viewportWidth, viewportHeight);

			particleEffectGenerator.update(dt, camCoordinates);
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		particleEffectGenerator.dispose();
	}
}
