package com.hitran.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ParticleEffectGenerator {
    private ParticleEffect effectCircleBlue, effectCircleGreen, effectCircleRed, effectCircleYellow,
            effectHeartBlue, effectHeartGreen, effectHeartRed, effectHeartYellow,
            effectStarBlue, effectStarGreen, effectStarRed, effectStarYellow,
            effectTriangleBlue, effectTriangleGreen, effectTriangleRed, effectTriangleYellow;
    private ParticleEffectPool poolCircleBlue, poolCircleGreen, poolCircleRed, poolCircleYellow,
            poolHeartBlue, poolHeartGreen, poolHeartRed, poolHeartYellow,
            poolStarBlue, poolStarGreen, poolStarRed, poolStarYellow,
            poolTriangleBlue, poolTriangleGreen, poolTriangleRed, poolTriangleYellow;

    private Map<ParticleEffectPool, Array<ParticleEffectPool.PooledEffect>> activeEffects;
    private Array<ParticleEffectPool> allPools;

    private Random rand;

    public ParticleEffectGenerator() {
        allPools = new Array<>();
        rand = new Random();

        effectCircleBlue = new ParticleEffect();
        effectCircleBlue.load(Gdx.files.internal("circle_blue.p"), Gdx.files.internal(""));
        poolCircleBlue = new ParticleEffectPool(effectCircleBlue, 1, 15);
        allPools.add(poolCircleBlue);

        effectCircleGreen = new ParticleEffect();
        effectCircleGreen.load(Gdx.files.internal("circle_green.p"), Gdx.files.internal(""));
        poolCircleGreen = new ParticleEffectPool(effectCircleGreen, 1, 15);
        allPools.add(poolCircleGreen);

        effectCircleRed = new ParticleEffect();
        effectCircleRed.load(Gdx.files.internal("circle_red.p"), Gdx.files.internal(""));
        poolCircleRed = new ParticleEffectPool(effectCircleRed, 1, 15);
        allPools.add(poolCircleRed);

        effectCircleYellow = new ParticleEffect();
        effectCircleYellow.load(Gdx.files.internal("circle_yellow.p"), Gdx.files.internal(""));
        poolCircleYellow = new ParticleEffectPool(effectCircleYellow, 1, 15);
        allPools.add(poolCircleYellow);

        effectHeartBlue = new ParticleEffect();
        effectHeartBlue.load(Gdx.files.internal("heart_blue.p"), Gdx.files.internal(""));
        poolHeartBlue = new ParticleEffectPool(effectHeartBlue, 1, 15);
        allPools.add(poolHeartBlue);

        effectHeartGreen = new ParticleEffect();
        effectHeartGreen.load(Gdx.files.internal("heart_green.p"), Gdx.files.internal(""));
        poolHeartGreen = new ParticleEffectPool(effectHeartGreen, 1, 15);
        allPools.add(poolHeartGreen);

        effectHeartRed = new ParticleEffect();
        effectHeartRed.load(Gdx.files.internal("heart_red.p"), Gdx.files.internal(""));
        poolHeartRed = new ParticleEffectPool(effectHeartRed, 1, 15);
        allPools.add(poolHeartRed);

        effectHeartYellow = new ParticleEffect();
        effectHeartYellow.load(Gdx.files.internal("heart_yellow.p"), Gdx.files.internal(""));
        poolHeartYellow = new ParticleEffectPool(effectHeartYellow, 1, 15);
        allPools.add(poolHeartYellow);

        effectStarBlue = new ParticleEffect();
        effectStarBlue.load(Gdx.files.internal("star_blue.p"), Gdx.files.internal(""));
        poolStarBlue = new ParticleEffectPool(effectStarBlue, 1, 15);
        allPools.add(poolStarBlue);

        effectStarGreen = new ParticleEffect();
        effectStarGreen.load(Gdx.files.internal("star_green.p"), Gdx.files.internal(""));
        poolStarGreen = new ParticleEffectPool(effectStarGreen, 1, 15);
        allPools.add(poolStarGreen);

        effectStarRed = new ParticleEffect();
        effectStarRed.load(Gdx.files.internal("star_red.p"), Gdx.files.internal(""));
        poolStarRed = new ParticleEffectPool(effectStarRed, 1, 15);
        allPools.add(poolStarRed);

        effectStarYellow = new ParticleEffect();
        effectStarYellow.load(Gdx.files.internal("star_yellow.p"), Gdx.files.internal(""));
        poolStarYellow = new ParticleEffectPool(effectStarYellow, 1, 15);
        allPools.add(poolStarYellow);

        effectTriangleBlue = new ParticleEffect();
        effectTriangleBlue.load(Gdx.files.internal("triangle_blue.p"), Gdx.files.internal(""));
        poolTriangleBlue = new ParticleEffectPool(effectTriangleBlue, 1, 15);
        allPools.add(poolTriangleBlue);

        effectTriangleGreen = new ParticleEffect();
        effectTriangleGreen.load(Gdx.files.internal("triangle_green.p"), Gdx.files.internal(""));
        poolTriangleGreen = new ParticleEffectPool(effectTriangleGreen, 1, 15);
        allPools.add(poolTriangleGreen);

        effectTriangleRed = new ParticleEffect();
        effectTriangleRed.load(Gdx.files.internal("triangle_red.p"), Gdx.files.internal(""));
        poolTriangleRed = new ParticleEffectPool(effectTriangleRed, 1, 15);
        allPools.add(poolTriangleRed);

        effectTriangleYellow = new ParticleEffect();
        effectTriangleYellow.load(Gdx.files.internal("triangle_yellow.p"), Gdx.files.internal(""));
        poolTriangleYellow = new ParticleEffectPool(effectTriangleYellow, 1, 15);
        allPools.add(poolTriangleYellow);

        activeEffects = new HashMap<>();
        activeEffects.put(poolCircleBlue, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolCircleGreen, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolCircleRed, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolCircleYellow, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolHeartBlue, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolHeartGreen, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolHeartRed, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolHeartYellow, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolStarBlue, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolStarGreen, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolStarRed, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolStarYellow, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolTriangleBlue, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolTriangleGreen, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolTriangleRed, new Array<ParticleEffectPool.PooledEffect>());
        activeEffects.put(poolTriangleYellow, new Array<ParticleEffectPool.PooledEffect>());
    }

    public void render(SpriteBatch batch, float dt) {

        Iterator it = activeEffects.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ParticleEffectPool, Array<ParticleEffectPool.PooledEffect>> pair = (Map.Entry) it.next();

            Array<ParticleEffectPool.PooledEffect> currentActiveEffects = pair.getValue();
            if (currentActiveEffects.size == 0) {
                continue;
            }

            for (int i = 0; i < currentActiveEffects.size; ) {
                ParticleEffectPool.PooledEffect currentEffect = currentActiveEffects.get(i);
                currentEffect.update(dt);

                if (currentEffect.isComplete()) {
                    pair.getKey().free(currentEffect);
                    currentActiveEffects.removeIndex(i);
                } else {
                    currentEffect.draw(batch, Gdx.graphics.getDeltaTime());
                    i++;
                }
            }
        }
    }

    public void update(float dt, Vector3 camCoordinates) {

        int currentPoolPosition = rand.nextInt(allPools.size);
        ParticleEffectPool pool = allPools.get(currentPoolPosition);

        if (camCoordinates != null) {
            ParticleEffectPool.PooledEffect effect = pool.obtain();
            if (effect != null) {
                effect.reset();
                effect.setPosition(camCoordinates.x, camCoordinates.y);
                activeEffects.get(pool).add(effect);
            }
        }
    }

    public void dispose() {
        effectCircleBlue.dispose();
        effectCircleGreen.dispose();
        effectCircleRed.dispose();
        effectCircleYellow.dispose();
        effectHeartBlue.dispose();
        effectHeartGreen.dispose();
        effectHeartRed.dispose();
        effectHeartYellow.dispose();
        effectStarBlue.dispose();
        effectStarGreen.dispose();
        effectStarRed.dispose();
        effectStarYellow.dispose();
        effectTriangleBlue.dispose();
        effectTriangleGreen.dispose();
        effectTriangleRed.dispose();
        effectTriangleYellow.dispose();
    }
}
