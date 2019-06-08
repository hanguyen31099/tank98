package game.player.playerbullet;

import game.GameObject;
import game.player.Player2;

public class PlayerBullet1 extends PlayerBullet {
    public PlayerBullet1(){
        this.damage = 3;
    }
    @Override
    public void run() {
        super.run();
        this.CheckPlayer2();
    }

    private void CheckPlayer2() {
        Player2 player2 = GameObject.findInterSects("Player2",this.hitBox,Player2.class,this);
        if(player2!=null){
            player2.TakeDame(this.damage);
            this.deactive();
        }
    }
}
