package game.explosion;

import game.GameObject;
import game.Settings;
import game.renderer.Renderer;

public class Explosion extends GameObject {
    public Explosion() {
        key ="Explosion";
        renderer = new Renderer("assets/images/Explosion/explosion", true);
        GameObject.addToHashMap(key,this);
    }

}
