package game.Enity.wall.wall_brown.wallBig;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class WallBig_Left extends Wall {
    public WallBig_Left(){
        WallName = "WallBig_Left";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-Big/wall-left.png");
        hitBox = new BoxCollider(this,24,48);
    }
}
