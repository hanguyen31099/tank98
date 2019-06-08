package game.renderer.player;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;

public class Player1Render extends PlayerRenderer {
    public Player1Render(GameObject master){
        image1 = new Renderer("assets/images/players/player/lv1/lv1-up");
        image2 = new Renderer("assets/images/players/player/lv1/lv1-down");
        image3 = new Renderer("assets/images/players/player/lv1/lv1-left");
        image4 = new Renderer("assets/images/players/player/lv1/lv1-right");
        this.current = image1;
    }

}
