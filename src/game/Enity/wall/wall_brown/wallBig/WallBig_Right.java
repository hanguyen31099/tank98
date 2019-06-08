package game.Enity.wall.wall_brown.wallBig;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class WallBig_Right extends Wall {
    public WallBig_Right(){
        WallName = "WallBig_Right";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-Big/wall-right.png");
        hitBox = new BoxCollider(this,24,48);
    }
}
