package game.Physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public int width;
    public int height;
    public Vector2D position;
    public Vector2D anchor;
    public BoxCollider(){

    }
   
    public BoxCollider (GameObject master, int width,int height){
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }
    public void BoxColliderClone (GameObject master, Vector2D position){
        this.position = position;
        this.width = master.hitBox.width;
        this.height = master.hitBox.height;
        this.anchor = master.hitBox.anchor;
    }
    public void set(Vector2D position,int width,int height,Vector2D anchor){
        this.position = position;
        this.width = width;
        this.height = height;
    }
    public BoxCollider SpcecticalHitBox(String find){
        BoxCollider clone = new BoxCollider();
        clone.position = this.position;
        clone.width = this.width;
        clone.height = this.height;
        clone.anchor = this.anchor;
        if(find=="width"){
            clone.width = clone.width*3;
        }
        if (find=="height") {
            clone.height = clone.height*3;
        }
        return clone;
    }
    public double top() {
        return position.y - anchor.y *height;
    }
    public double bottom() {
        return this.top() + this.height;
    }
    public double left() {
        return position.x - anchor.x*width;
    }
    public double right(){
        return this.left() + this.width;
    }

    public boolean interset(BoxCollider other){
        // this co giao voi box truyen vao hay khong
        return  other.bottom() >= this.top()
                && other.top() <= this.bottom()
                && other.right() >=this.left()
                && other.left() <= this.right();
    }


}
