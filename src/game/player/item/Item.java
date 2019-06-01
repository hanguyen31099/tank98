package game.player.item;

import game.GameObject;
import game.Physics.BoxCollider;
import game.player.Player;


public class Item extends GameObject {
    public Item() {
        hitBox = new BoxCollider(this, 12, 12);
    }
    public void powerUp(Player player){
    }
}

