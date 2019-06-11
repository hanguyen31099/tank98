package game.scene;

import game.GameObject;
import game.maps.Map;

public class SceneWelcome extends Scene {

    @Override
    public void init() {
        GameObject.recycle("BackgroundWelcome",BackgroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.ClearAll();
    }
}
