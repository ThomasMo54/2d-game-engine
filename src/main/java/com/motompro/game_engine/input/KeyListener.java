package com.motompro.game_engine.input;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class KeyListener {

    private static KeyListener instance;

    private final boolean[] keyPressed;

    private KeyListener() {
        this.keyPressed = new boolean[350];
    }

    public static KeyListener getInstance() {
        if(instance == null)
            instance = new KeyListener();
        return instance;
    }

    public static boolean isKeyPressed(int key) {
        return getInstance().keyPressed[key];
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods) {
        getInstance().keyPressed[key] = action == GLFW_PRESS;
    }
}
