package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    private int screenWidth = 800;
    private int screenHeight = 600;
    private int targetWidth = screenWidth;
    private int targetHeight = screenHeight;
    private float resizeDuration = 1.0f;
    private float resizeTimer = 0.0f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            targetWidth = 1024;
            targetHeight = 768;
            resizeTimer = 0.0f;
        }

        if (resizeTimer < resizeDuration) {
            resizeTimer += deltaTime;
            float alpha = Math.min(resizeTimer / resizeDuration, 1.0f);
            screenWidth = (int) lerp(screenWidth, targetWidth, alpha);
            screenHeight = (int) lerp(screenHeight, targetHeight, alpha);
            Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
        }


        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
    }


    private float lerp(float start, float end, float alpha) {
        return start * (1 - alpha) + end * alpha;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
