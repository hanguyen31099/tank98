package game.player.item;

import game.GameObject;
import game.Physics.BoxCollider;
import game.enemy.EnemyBullet;
import game.explosion.BarrelExplosion;
import game.explosion.Explosion;
import game.player.Player;
import game.player.PlayerBullet;
import game.renderer.Renderer;

import java.awt.*;

public class Barrel extends GameObject {
    public Barrel(){
        key = "Barrel";
        renderer = new Renderer("assets/images/enemies/explosion-item/Barrel1.png");
        hitBox = new BoxCollider(this,30,30);
        GameObject.addToHashMap(key,this);
    }


    @Override
    public void deactive() {
        super.deactive();
        BarrelExplosion explosion = GameObject.recycle(BarrelExplosion.class);
        explosion.position.set(this.position);
    }
}
