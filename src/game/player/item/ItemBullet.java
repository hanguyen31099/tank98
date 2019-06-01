package game.player.item;

import game.player.Player;
import game.renderer.Renderer;
import tklibs.Mathx;

public class ItemBullet extends Item {
    public ItemBullet(){
        renderer = new Renderer("assets/images/items/power-up-blue.png");
    }

    @Override
    public void powerUp(Player player) {
        super.powerUp(player);
        player.numberBullet += 2;
        player.numberBullet = Mathx.clamp(player.numberBullet, 3,11);
    }

}
