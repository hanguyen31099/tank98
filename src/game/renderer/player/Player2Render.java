package game.renderer.player;

import game.GameObject;
import game.renderer.Renderer;

public class Player2Render extends PlayerRenderer {
    public Player2Render(GameObject master){
        image1 = new Renderer("assets/images/players/player/player2/player2-up");
        image2 = new Renderer("assets/images/players/player/player2/player2-down");
        image3 = new Renderer("assets/images/players/player/player2/player2-left");
        image4 = new Renderer("assets/images/players/player/player2/player2-right");
        this.current = image1;
    }
}
