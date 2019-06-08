package game.renderer.player;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerRenderer extends Renderer {
    public Renderer current,image1,image2,image3,image4;
    public PlayerRenderer(){

    }
    @Override
    public void render(Graphics g, GameObject master) {
        if (master.Go.x > 0) {
            current = image4;
        }
        if (master.Go.x < 0) {
            current = image3;
        }
        if (master.Go.y > 0) {
            current = image2;
        }
        if (master.Go.y < 0) {
            current = image1;
        }
        current.render(g, master);
    }
}
