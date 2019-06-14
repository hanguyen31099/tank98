package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Physics.BoxCollider;
import game.Settings;
import game.player.playerbullet.PlayerBullet2;
import game.renderer.player.Player2Render;

public class Player2 extends Player {

    public Player2(){
        key = "Player2";
        Find = "Player1";
        this.renderer = new Player2Render(this);
        anchor.set(0.4,0.5);
        hitBox = new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);
        dame = 3;
        GameObject.addToHashMap(key,this);
    }
    int count = 0; // dem so khung hinh

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
    }
    private void fire() {
        count++;
        if(KeyEventPress.isPlayer2FirePress&&((count>= 30||isFrist))){
            isFrist = false;
            count = 0;
            PlayerBullet2 bullet = GameObject.recycle("PlayerBullet2",PlayerBullet2.class);
            //bullet.Find = "Player1";
            if(isGoing=="Up"){
                bullet.velocity.set(0,-5);
                bullet.position.set(this.position.x+3,this.position.y);
            }
            if(isGoing=="Down"){
                bullet.velocity.set(0,5);
                bullet.position.set(this.position.x+3,this.position.y);
            }
            if(isGoing=="Left"){
                bullet.velocity.set(-5,0);
                bullet.position.set(this.position.x,this.position.y);
            }
            if(isGoing=="Right"){
                bullet.velocity.set(5,0);
                bullet.position.set(this.position.x,this.position.y);
            }


        }
    }
    private void move() {
        if(KeyEventPress.isPlayer2UpPress) {
            Go.set(0,-2);
            isGoing = "Up";
        }
        if(KeyEventPress.isPlayer2DownPress) {
            Go.set(0,2);
            isGoing = "Down";
        }
        if(KeyEventPress.isPlayer2LeftPress) {
            Go.set(-2,0);
            isGoing = "Left";
        }
        if(KeyEventPress.isPlayer2RightPress) {
            Go.set(2,0);
            isGoing = "Right";
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        Settings.Player2active = false;
    }
}
