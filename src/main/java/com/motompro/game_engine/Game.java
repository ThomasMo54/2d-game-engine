package com.motompro.game_engine;

public abstract class Game {

    private boolean running = true;

    public Game() {
        init();
        while(running) {
            update();
            render();
        }
    }

    public abstract void init();
    public abstract void update();
    public abstract void render();

    public void stop() {
        this.running = false;
    }
}
