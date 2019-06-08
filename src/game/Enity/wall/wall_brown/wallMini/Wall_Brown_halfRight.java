package game.Enity.wall.wall_brown.wallMini;

import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class Wall_Brown_halfRight extends Wall {
    public Wall_Brown_halfRight(){
        WallName = "Wall_Brown_halfRight";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-mini/wall-Brown3.png");
        hitBox = new BoxCollider(this,12,24);
//        GameObject.addToHashMap(WallName,this);
    }
}
