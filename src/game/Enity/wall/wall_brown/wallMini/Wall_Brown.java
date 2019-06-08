package game.Enity.wall.wall_brown.wallMini;


import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class Wall_Brown extends Wall {
    public Wall_Brown(){
        WallName = "Wall_Brown";
        hitBox = new BoxCollider(this,24,24);
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-mini/Wall-Brown.png");
    }

    @Override
    public void deactive() {
        super.deactive();
        if(bulletGoing.x>0) {
            Wall wall = GameObject.recycle("Wall_Brown_halfRight",Wall_Brown_halfRight.class);
            wall.position.set(this.position.x+6,this.position.y);
        }
        if(bulletGoing.x<0){
            Wall wall = GameObject.recycle("Wall_Brown_halfLeft",Wall_Brown_halfLeft.class);
            wall.position.set(this.position.x-6,this.position.y);
        }
        if(bulletGoing.y>0){
            Wall wall = GameObject.recycle("Wall_Brown_halfDown",Wall_Brown_halfDown.class);
            wall.position.set(this.position.x,this.position.y+6);
        }
        if(bulletGoing.y<0){
            Wall wall = GameObject.recycle("Wall_Brown_halfUp",Wall_Brown_halfUp.class);
            wall.position.set(this.position.x,this.position.y-6);
        }
    }
}
