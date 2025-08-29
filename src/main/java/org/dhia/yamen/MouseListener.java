package org.dhia.yamen;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance= null ;

    private double xPose,  yPose, lastX, lastY;
    private double scrollX, scrollY;
    private boolean mouseButtonPressed[]= new boolean[3];
    private boolean isDragging;

    private MouseListener() {
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPose = 0.0;
        this.yPose = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
        this.mouseButtonPressed[0] = false;
        this.mouseButtonPressed[1] = false;
    }

    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    public static void mousePoseCallback(long window, double xPos, double yPos) {
        get().lastX = xPos;
        get().lastY = yPos;
        get().xPose = xPos;
        get().yPose = yPos;

        get().isDragging= get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2] ;
    }


    public static void mouseButtonCallback(long window, int button, int action, int mods) {
        if(action==GLFW_PRESS){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = true;            }

        } else if(action==GLFW_RELEASE){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = false;
            }
        }
        get().isDragging = false;
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    public static void endFrame(long window) {
        get().scrollX = 0.0;
        get().scrollY = 0.0;
        get().lastX = get().xPose;
        get().lastY = get().yPose;
    }

    public static float getX() {
        return (float)get().xPose;
    }
    public static float getY() {
        return (float)get().yPose;
    }
    public static float getDx() {
        return (float)get().lastX - (float)get().xPose;
    }
    public static float getDy() {
        return (float)get().lastY - (float)get().yPose;
    }

    public static float getScrollX() {
        return (float)get().scrollX;
    }
    public static float getScrollY() {
        return (float)get().scrollY;
    }

    public static boolean isDragging() {
        return get().isDragging;
    }
    public static boolean mouseButtonDown( int button) {
        if(button < get().mouseButtonPressed.length){
            return get().mouseButtonPressed[button];
        } else {
            return false;
        }

    }


}
