package game.Enity.wall.wall_brown.wallMini;

import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class Wall_Brown_halfUp extends Wall {
    public Wall_Brown_halfUp(){
        WallName = "Wall_Brown_halfUp";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-mini/wall-Brown2.png");
        hitBox  = new BoxCollider(this,24,12);
//        GameObject.addToHashMap(WallName,this);
    }
}
