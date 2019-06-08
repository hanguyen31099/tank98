package game.Enity.wall.wall_while;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class Wall_while extends Wall {
    public Wall_while(){
        WallName = "Wall_while";
        hitBox = new BoxCollider(this,24,24);
        renderer = new Renderer("assets/images/wall/Wall-While/wall-while2.png");
    }
}
