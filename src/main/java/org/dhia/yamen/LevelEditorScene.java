package org.dhia.yamen;

import java.awt.event.KeyEvent;

public class LevelEditorScene extends Scene {

    private static boolean changingScene = false;

    public LevelEditorScene() {

    }

    @Override
    public void update(float dt) {
        if(!changingScene && KeyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            changingScene = true;

        }
    }
}
