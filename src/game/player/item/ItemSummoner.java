package game.player.item;

import game.GameObject;
import game.Settings;
import tklibs.Mathx;

public class ItemSummoner extends GameObject {

    public ItemSummoner(){
        key = "ItemSummoner";
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void run() {
        super.run();
        summorItem();
    }
    int count = 0;
    private void summorItem() {
//        count++;
//        if(count>120){
//            int itemType = Mathx.random(1,2);
//            switch (itemType){
//                case 1 : {
//                    Itemhp item = GameObject.recycle(Itemhp.class);
//                    item.position.set(Mathx.random(0, Settings.GAME_WIDTH),Mathx.random(0,Settings.GAME_HEIGHT));
//                    break;
//                }
//                case 2 : {
//                    ItemBullet item = GameObject.recycle(ItemBullet.class);
//                    item.position.set(Mathx.random(0, Settings.GAME_WIDTH),Mathx.random(0,Settings.GAME_HEIGHT));
//                    break;
//                }
//            }
//            count = 0;
//        }
    }
}
