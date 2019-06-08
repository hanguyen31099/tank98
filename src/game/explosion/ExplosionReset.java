package game.explosion;

import game.GameObject;
import game.player.Player;
import game.player.Player1;
import game.player.Player2;
import game.renderer.Renderer;

public class ExplosionReset extends GameObject {
    public ExplosionReset(){
        key ="ExplosionReset";
        renderer = new Renderer("assets/images/Explosion/TankExplo",5,true);
        GameObject.addToHashMap(key,this);
    }
}
