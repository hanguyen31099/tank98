package game.player;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerBulletRenderer extends Renderer {

    public Renderer current,image1,image2,image3,image4;


    public PlayerBulletRenderer(PlayerBullet master) {
        image1 = new Renderer("assets/images/linhtinh/bullet/bullet-up.png");
        image2 = new Renderer("assets/images/linhtinh/bullet/bullet-down.png");
        image3 = new Renderer("assets/images/linhtinh/bullet/bullet-left.png");
        image4 = new Renderer("assets/images/linhtinh/bullet/bullet-right.png");

        this.current = image1;

    }

    public PlayerBulletRenderer(String url) {
        super(url);
    }

    public PlayerBulletRenderer(String url, boolean isOnce) {
        super(url, isOnce);
    }

    public void checkRender(PlayerBullet playerBullet) {

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
