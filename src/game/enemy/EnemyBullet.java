package game.enemy;

import game.GameObject;
import game.Physics.BoxCollider;
import game.player.Player;
import game.player.item.Barrel;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public int damge;
    public EnemyBullet() {
        renderer = new Renderer("assets/images/enemies/bullets/projectile.png");
        velocity.set(0,3);
        hitBox = new BoxCollider(this,renderer.image.getWidth(),renderer.image.getHeight());
        damge = 1;
    }

    @Override
    public void run() {
        super.run();
        this.checkPlayer();
        this.checkBarrel();
    }
    private void checkBarrel() {
        Barrel barrel = GameObject.findInterSects(Barrel.class,this.hitBox);
        if (barrel!=null){
            this.deactive();
            barrel.deactive();
        }
    }

    private void checkPlayer() {
        Player player = GameObject.findInterSects(Player.class,this.hitBox);
        if(player!=null ){
            player.TakeDame(damge);
            this.deactive();
        }
    }

    @Override
    public void reset() {
        super.reset();
    }
}
