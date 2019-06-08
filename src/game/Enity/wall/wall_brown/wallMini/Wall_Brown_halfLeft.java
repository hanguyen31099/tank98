package game.Enity.wall.wall_brown.wallMini;

import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class Wall_Brown_halfLeft extends Wall {
    public Wall_Brown_halfLeft(){
        WallName = "Wall_Brown_halfLeft";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-mini/wall-Brown1.png");
        hitBox = new BoxCollider(this,12,24);
//        GameObject.addToHashMap(WallName,this);
    }
}
