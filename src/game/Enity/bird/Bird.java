package game.Enity;

import game.GameObject;
import game.Physics.BoxCollider;
import game.explosion.BirdExplosion;
import game.renderer.Renderer;

public class Bird extends GameObject {
    public Bird(){
        key = "Bird";
        hitBox = new BoxCollider(this,45,45);
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void deactive() {
        super.deactive();
        BirdExplosion explosion = GameObject.recycle("BirdExplosion",BirdExplosion.class);
        explosion.position.set(this.position);
    }
}
