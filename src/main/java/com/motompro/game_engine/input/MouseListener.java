package com.motompro.game_engine.input;

import static org.lwjgl.glfw.GLFW.*;

public class MouseListener {

    private static MouseListener instance;

    private double currentX, currentY;
    private double lastX, lastY;
    private double scrollX, scrollY;
    private final boolean[] buttonPressed;
    private boolean dragging;

    private MouseListener() {
        this.currentX = 0;
        this.currentY = 0;
        this.lastX = 0;
        this.lastY = 0;
        this.scrollX = 0;
        this.scrollY = 0;
        this.buttonPressed = new boolean[3];
        this.dragging = false;
    }

    public static MouseListener getInstance() {
        if(instance == null)
            instance = new MouseListener();
        return instance;
    }

    public static double getDx() {
        return getInstance().currentX - getInstance().lastX;
    }

    public static double getDy() {
        return getInstance().currentY - getInstance().lastY;
    }

    public static double getScrollX() {
        return getInstance().scrollX;
    }

    public static double getScrollY() {
        return getInstance().scrollY;
    }

    public static boolean isButtonPressed(int button) {
        return getInstance().buttonPressed[button];
    }

    public static boolean isDragging() {
        return getInstance().dragging;
    }

    public static void mousePositionCallback(long window, double x, double y) {
        // Setting last position
        getInstance().lastX = getInstance().currentX;
        getInstance().lastY = getInstance().currentY;
        // Setting new position
        getInstance().currentX = x;
        getInstance().currentY = y;
        // Check dragging
        if(getInstance().buttonPressed[GLFW_MOUSE_BUTTON_LEFT])
            getInstance().dragging = true;
    }

    public static void mouseButtonCallback(long window, int button, int action, int mods) {
        if(action > 2)
            return;
        if(button == GLFW_MOUSE_BUTTON_LEFT && action == GLFW_RELEASE)
            getInstance().dragging = false;
        getInstance().buttonPressed[button] = action == GLFW_PRESS;
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        getInstance().scrollX = xOffset;
        getInstance().scrollY = yOffset;
    }
}
