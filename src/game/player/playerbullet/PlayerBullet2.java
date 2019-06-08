package game.player.playerbullet;

import game.GameObject;
import game.player.Player1;

public class PlayerBullet2 extends PlayerBullet {
    public PlayerBullet2(){
        this.damage = 3;
    }
    @Override
    public void run() {
        super.run();
        this.CheckPlayer2();
    }

    private void CheckPlayer2() {
        Player1 player1 = GameObject.findInterSects("Player1",this.hitBox,Player1.class,this);
        if(player1!=null){
            player1.TakeDame(this.damage);
            this.deactive();
        }
    }
}
