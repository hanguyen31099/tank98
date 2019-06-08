package game.explosion;

import game.Enity.Bird;
import game.GameObject;
import game.renderer.Renderer;

public class BirdExplosion extends GameObject {
    public BirdExplosion(){
        key = "BirdExplosion";
        renderer = new Renderer("assets/images/Explosion/TankExplosion",true);
        GameObject.addToHashMap(key,this);
    }
}
