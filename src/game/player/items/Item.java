package game.player.items;

import game.GameObject;
import game.Physics.BoxCollider;

import java.awt.*;

public class Item extends GameObject {
    public Item(){
        immune = true;
        hitBox = new BoxCollider(this,48,48);
    }
    int immuneCount = 0,Count = 0;
    @Override
    public void render(Graphics g) {
        if(immune){
            immuneCount++;
            Count++;
            if(Count<=20){
                renderer.render(g,this);
            }
            if(Count>=40) Count = 0;
            if(immuneCount>=300){
                immuneCount = 0;
                this.deactive();
            }
        }
        else renderer.render(g,this);
    }

    @Override
    public void deactive() {
        super.deactive();
        immuneCount = 0;Count = 0;
        ItemSummer.CanCount = true;
    }
}
