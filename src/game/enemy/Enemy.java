package game.enemy;

import game.GameObject;
import game.Physics.BoxCollider;
import game.Settings;
import game.Vector2D;
import game.explosion.Explosion;
import game.player.Player;
import game.renderer.Renderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public String image,image1,image2,image3,image4;
    public int dame;
    public int hp;
    public Enemy(){
        key = "Enemy";
        GameObject.addToHashMap(key,this);
    }

    @Override
    public void run() {
        super.run();
        this.checkPlayer();
    }


    private void checkPlayer() {
        Player player = GameObject.findInterSects(Player.class,this.hitBox);
        if(player!=null ){
            player.TakeDame(dame);
            this.deactive();
        }
    }



    public void takeDamege(int damage){
        hp -= damage;
        if(hp<=0){
            Settings.score++;
            hp = 0;
            this.deactive();
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position.x,this.position.y);
    }
}
