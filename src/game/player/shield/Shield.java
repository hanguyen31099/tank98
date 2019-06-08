package game.player.shield;

import game.GameObject;
import game.renderer.Renderer;

public class Shield extends GameObject {
    public Shield(){
        key = "Shield";
        this.position.set(-30,-30);
        renderer = new Renderer("assets/images/shield",15,false);
        GameObject.addToHashMap(key,this);
    }
}
