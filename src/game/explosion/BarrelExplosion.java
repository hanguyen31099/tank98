package game.explosion;

import game.GameObject;
import game.renderer.Renderer;

public class BarrelExplosion extends GameObject {
    public BarrelExplosion(){
        renderer = new Renderer("assets/images/enemies/explosion-item",true);
    }
}
