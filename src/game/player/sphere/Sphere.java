package game.player.sphere;

import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.Settings;
import game.Vector2D;
import game.player.Player;
import game.renderer.Renderer;

public class Sphere extends GameObject {
    public Vector2D clone;
    public Vector2D cloneGoing;
    public boolean CanGo = true;
    public Vector2D positionFuture;
    public BoxCollider hitBoxClone;
    public Sphere(){
        positionFuture = new Vector2D();
        hitBoxClone = new BoxCollider();
        key = "Sphere";
        anchor.set(0.5,0);
        hitBox = new  BoxCollider(this,3,21);
        clone = new Vector2D();
        cloneGoing = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if(cloneGoing.x>0){
            anchor.set(0,0.5);
            hitBox.set(clone,21,3,anchor);
        }
        if (cloneGoing.x<0){
            anchor.set(0,0.5);
            hitBox.set(clone,21,3,anchor);
        }
        if(cloneGoing.y>0){
            anchor.set(0.5,0);
            hitBox.set(clone,3,21,anchor);
        }
        if(cloneGoing.y<0){
            anchor.set(0.5,0);
            hitBox.set(clone,3,21,anchor);
        }
        this.InterSects();
    }
    int count = 0;
    public void InterSects() {
        positionFuture.set(this.clone);
        positionFuture.add(cloneGoing.x,cloneGoing.y);
        hitBoxClone.BoxColliderClone(this,positionFuture);
        GameObject object = GameObject.findInterSects("Wall",hitBoxClone,Wall.class,this);
        if(object!=null){
            CanGo = false;
        }
        else CanGo = true;
    }
}
