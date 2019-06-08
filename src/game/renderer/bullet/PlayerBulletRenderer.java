package game.renderer.bullet;

import game.GameObject;
import game.player.playerbullet.PlayerBullet;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerBulletRenderer extends Renderer {

    public Renderer current,image1,image2,image3,image4;


    public PlayerBulletRenderer(PlayerBullet master) {
        image1 = new Renderer("assets/images/bullet/bullet-up.png");
        image2 = new Renderer("assets/images/bullet/bullet-down.png");
        image3 = new Renderer("assets/images/bullet/bullet-left.png");
        image4 = new Renderer("assets/images/bullet/bullet-right.png");

        this.current = image1;

    }

    @Override
    public void render(Graphics g, GameObject master) {
        if (master.velocity.x > 0) {
            current = image4;
        }
        if (master.velocity.x < 0) {
            current = image3;
        }
        if (master.velocity.y > 0) {
            current = image2;
        }
        if (master.velocity.y < 0) {
            current = image1;
        }
        current.render(g, master);
    }
}
