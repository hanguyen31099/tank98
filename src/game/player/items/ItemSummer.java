package game.player.items;

import game.GameObject;
import game.Settings;
import tklibs.Mathx;

public class ItemSummer extends GameObject {
    public static boolean CanCount = true;
    public ItemSummer() {
        key = "ItemSummer";
        GameObject.addToHashMap(key,this);
    }
    int count = 0;
    @Override
    public void run() {
        super.run();
        if(CanCount) count++;
        summorItem();
    }
    private void summorItem() {
        if (count > 300) {
            CanCount = false;
            int itemType = Mathx.random(1, 2);
            switch (itemType) {
                case 1: {
                    ItemHp item = GameObject.recycle("ItemHp", ItemHp.class);
                    item.position.set(Mathx.random(12, Settings.GAME_WIDTH-50), Mathx.random(12, Settings.GAME_HEIGHT-50));
                    break;
                }
                case 2: {
                    ItemShield item = GameObject.recycle("ItemShield", ItemShield.class);
                    item.position.set(Mathx.random(12, Settings.GAME_WIDTH-50), Mathx.random(12, Settings.GAME_HEIGHT-50));
                    break;
                }
            }
            count = 0;
        }
    }
}
