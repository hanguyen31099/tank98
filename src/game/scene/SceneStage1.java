package game.scene;

import game.GameObject;
import game.maps.Map;
import game.player.PlayerSummer;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
        PlayerSummer playerSummer = GameObject.recycle("PlayerSummer", PlayerSummer.class);
        Map map = Map.load("assets/images/Map/map1/map.json");
        map.generate();
    }

    @Override
    public void clear() {
        GameObject.ClearAll();
    }
}
