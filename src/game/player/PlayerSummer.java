package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.explosion.ExplosionReset;
import game.player.playerbullet.PlayerBullet;
import game.player.shield.Shield;
import tklibs.Mathx;

public class PlayerSummer extends GameObject {
    int CountDiePlayer1 = 0;
    int CountDiePlayer2 = 0;
    boolean player1Reset = false;
    boolean player2Reset = false;
    boolean isFist = true;
    Vector2D clone1;
    Vector2D clone2;
    Player1 player1;
    Player2 player2;
    PlayerBullet playerBullet;
    public PlayerSummer(){
        key = "PlayerSummer";
        clone1 = new Vector2D();
        clone2 = new Vector2D();
        player1 = new Player1();
        player2 = new Player2();
        playerBullet = new PlayerBullet();
        player1.deactive();
        player2.deactive();
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void run() {
        super.run();
        if(isFist==true||Settings.Player1active==false){
            CountDiePlayer1++;
            if( CountDiePlayer1>=120||isFist){
                CountDiePlayer1 = 0;
                ExplosionReset explosion = GameObject.recycle("ExplosionReset",ExplosionReset.class);
                player1Reset = true;
                Settings.Player1active=true;
                int radom = Mathx.random(1,2);
                switch (radom) {
                    case 1: {
                        explosion.position.set(200, 600);
                        break;
                    }
                    case 2: {
                        explosion.position.set(500, 600);
                        break;
                    }
                }
                clone1.set(explosion.position);
            }
        }
        if(Settings.PlayerRevival&&player1Reset){
            player1Reset = false;
            Player1 player1 = GameObject.recycle("Player1",Player1.class);
            player1.position.set(clone1);
            System.out.println(player1.active);
        }
        if(isFist==true||Settings.Player2active==false){
            CountDiePlayer2++;
            if( CountDiePlayer2>=120||isFist){
                player2Reset = true;
                CountDiePlayer2 = 0;
                ExplosionReset explosion = new ExplosionReset();
                Settings.Player2active=true;
                int radom = Mathx.random(1,2);
                switch (radom) {
                    case 1: {
                        explosion.position.set(150, 50);
                        break;
                    }
                    case 2: {
                        explosion.position.set(450, 50);
                        break;
                    }
                }
                clone2.set(explosion.position);
            }
        }
        if(Settings.PlayerRevival&&player2Reset){
            player2Reset = false;
            Settings.PlayerRevival = false;
            Player2 player2 = GameObject.recycle("Player2",Player2.class);
            player2.position.set(clone2);
        }
        if (Settings.PlayerRevival) Settings.PlayerRevival = false;
        isFist =false;
    }
}
