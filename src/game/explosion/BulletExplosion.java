package game.explosion;

import game.GameObject;
import game.renderer.Renderer;

public class BulletExplosion extends GameObject {
    public BulletExplosion(){
        key = "BulletExplosion";
        renderer = new Renderer("assets/images/Explosion/TankExplosion",true);
        GameObject.addToHashMap(key,this);
    }
}
