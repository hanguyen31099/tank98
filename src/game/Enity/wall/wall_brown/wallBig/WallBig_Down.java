package game.Enity.wall.wall_brown.wallBig;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class WallBig_Down extends Wall {
    public WallBig_Down(){
        WallName = "WallBig_Down";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-Big/wall-down.png");
        hitBox = new BoxCollider(this,48,24);
    }
}
