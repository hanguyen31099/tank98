package game.player.item;

import game.player.Player;
import game.renderer.Renderer;
import tklibs.Mathx;

public class Itemhp extends Item {
    public Itemhp(){
        renderer = new Renderer("assets/images/items/power-up-red.png");
        //velocity.set(0, 1 + Mathx.random(2,5));
    }

    @Override
    public void powerUp(Player player) {
        player.hp ++;
    }

}
