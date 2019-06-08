package game.Enity.wall.wall_brown.wallBig;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class WallBig_Up extends Wall {
    public WallBig_Up(){
        WallName = "WallBig_Up";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-Big/wall-up.png");
        hitBox = new BoxCollider(this,48,24);
    }
}
