package game.player;

import game.GameObject;
import game.Physics.BoxCollider;
import game.enemy.Enemy;
import game.player.item.Barrel;

import java.awt.*;

public class PlayerBullet extends GameObject { // PlayerBulletType2

    public static boolean isresus = false;
    public int damge;

    public PlayerBullet() {
        this.renderer = new PlayerBulletRenderer(this);
        key = "PlayerBullet";
        velocity.set(0,3);
        hitBox = new BoxCollider(this,10,13);
        damge = 1;
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run(); //position.add(velocity.x,velocity.y)
        this.checkEnemy();
        this.checkBarrel();
    }

    private void checkBarrel() {
        Barrel barrel = GameObject.findInterSects(Barrel.class,this.hitBox);
        if (barrel!=null){
            this.deactive();
            barrel.deactive();
        }
    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findInterSects(Enemy.class,this.hitBox);
        if(enemy!=null){
            //enemy.deactive();
            enemy.takeDamege(damge);
            this.deactive();
        }
    }

    @Override
    public void deactive() {
        isresus = false;
        super.deactive();
    }


}
