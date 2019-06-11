package game.player.playerbullet;

import game.Enity.Bird;
import game.Enity.wall.Wall;
import game.GameObject;
import game.Physics.BoxCollider;
import game.explosion.BulletExplosion;
import game.renderer.bullet.PlayerBulletRenderer;

import java.awt.*;
import java.util.ArrayList;

public class PlayerBullet extends GameObject { // PlayerBulletType2

    public static boolean isresus = false;
    public String Find;
    public int damage;

    public PlayerBullet() {
        this.renderer = new PlayerBulletRenderer(this);
        hitBox = new BoxCollider(this,10,13);
        this.key = "PlayerBullet";
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void run() {
        super.run();
        this.CheckWall();
        this.CheckBird();
        this.checkBullet();
    }

    private void checkBullet() {
        PlayerBullet bullet = GameObject.findInterSects("PlayerBullet",this.hitBox,PlayerBullet.class,this);
        if(bullet!=null){
            this.deactive();
            bullet.deactive();
        }
    }

    private void CheckBird() {
        Bird bird = GameObject.findInterSects("Bird",this.hitBox,Bird.class,this);
        if(bird!=null){
            this.deactive();
            bird.deactive();
        }
    }

    private void CheckWall() {
        String find = "";
        if(this.velocity.x!=0){
            find = "width";
        }
        if(this.velocity.y!=0){
            find = "height";
        }
        ArrayList<GameObject> walls = new ArrayList<>();
        GameObject.findInterSectsWall("Wall",this.hitBox,find,this,Wall.class,walls);
        if(walls!=null){
            for (int i = 0; i <walls.size() ; i++) {
                GameObject master = walls.get(i);
                master.bulletGoing = this.velocity;
                if (master.WallName!="Wall_while"){
                    master.deactive();
                }
            }
           if (walls.size()>0)  this.deactive();
        }
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
    }


    @Override
    public void deactive() {
        super.deactive();
        BulletExplosion explosion = GameObject.recycle("BulletExplosion",BulletExplosion.class);
        explosion.position.set(this.position);
    }


}
