package game.Enity.wall.wall_brown.wallBig;

import game.Enity.wall.Wall;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class WallBig extends Wall {
    public WallBig(){
        WallName = "WallBig";
        renderer = new Renderer("assets/images/wall/Wall-Brown/Wall-Big/wall1.png");
        hitBox = new BoxCollider(this,48,48);
    }

    @Override
    public void deactive() {
        super.deactive();
    }
}
