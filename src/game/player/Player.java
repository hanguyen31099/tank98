package game.player;

import game.*;
import game.Enity.wall.Wall;
import game.explosion.Explosion;
import game.Physics.BoxCollider;
import game.explosion.ExplosionReset;
import game.player.items.ItemHp;
import game.player.items.ItemShield;
import game.player.shield.Shield;
import game.player.sphere.Sphere;
import tklibs.Mathx;

import java.awt.*;


public class Player extends GameObject {
    public int hp;
    public String isGoing;
    public int numberBullet;
    public boolean isFrist = true;
    public Vector2D positionFuture;
    public BoxCollider hitBoxClone;
    public Vector2D Clone;
    public int dame;
    public Shield shield;
    public Sphere sphere;
    public Player() {
        Go = new Vector2D();
        positionFuture = new Vector2D();
        hitBoxClone = new BoxCollider();
        isGoing = "Up";
        key = "Player";
        Clone = new Vector2D();
        this.position.set(-30,-30);
        hp = 10;
        GameObject.addToHashMap(key,this);
        shield = GameObject.recycle("Shield",Shield.class);
        sphere = GameObject.recycle("Sphere",Sphere.class);
    }

    @Override
    public void run() { // 60 fps >> 60 vien dan dc tao ra 1s >> 3 vien duoc tao ra 1s
        this.checkMove();
        this.ChangeShere();
        shield.position.set(this.position);
        if(sphere.CanGo!=true){
            this.Go.set(0,0);
        }
        position.add(Go.x,Go.y);
        this.checkItem();
        super.run();
        Go.set(0,0);
        this.limit();
    }

    public void checkItem() {
        ItemHp itemHp = GameObject.findInterSects("ItemHp",this.hitBox,ItemHp.class,this);
        if(itemHp!=null){
            itemHp.deactive();
            this.hp++;
        }
        ItemShield itemShield = GameObject.findInterSects("ItemShield",this.hitBox,ItemShield.class,this);
        if(itemShield!=null){
            itemShield.deactive();
            shield.reset();
        }
    }

    public void ChangeShere() {
        sphere.cloneGoing = this.Go;
        if(Go.x>0||Go.y>0){
            Clone.set(this.position);
        }
        if(Go.x<0){
            Clone.set(this.position.x-Settings.PLAYER_WIDTH/2-5,this.position.y);
            sphere.clone = Clone;
            sphere.position.set(Clone);
        }
        if(Go.y<0){
            Clone.set(this.position.x,this.position.y-Settings.PLAYER_HEIGHT/2-5);
            sphere.clone = Clone;
            sphere.position.set(Clone);
        }
        sphere.clone.set(Clone);

    }

    public void TakeDame(int dame) {
        if(!shield.active){
            this.hp-=dame;
            immune = true;
            if(hp<0){
                this.deactive();
            }
        }
    }

    int immuneCount = 0;
    public void render(Graphics g) {
        if(immune){
            immuneCount++;
            if(immuneCount%3==0){
                renderer.render(g,this);
            }
            if(immuneCount>=60){
                immuneCount = 0;
                immune = false;
            }
        }
        else renderer.render(g,this);
    }

    private void checkMove() {
        positionFuture.set(this.position);
        positionFuture.add(Go.x,Go.y);
        hitBoxClone.BoxColliderClone(this,positionFuture);
        GameObject object = GameObject.findInterSects("Wall",hitBoxClone,Wall.class,this);
        if(object!=null){
            this.Go.set(0,0);
        }
        GameObject object1 = GameObject.findInterSects("Player",hitBoxClone,Player.class,this);
        if(object1!=null){
            this.Go.set(0,0);
        }
    }


    private void limit() {
        position.x = Mathx.clamp(position.x, 20, Settings.BACKGROUND_WIDTH - 22);
        position.y = Mathx.clamp(position.y, 20, Settings.GAME_HEIGHT -25);
    }

    @Override
    public void deactive() {
        super.deactive();
        Explosion explosion = GameObject.recycle("Explosion",Explosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public void reset() {
        super.reset();
        this.hp = 10;
        shield.reset();
        immune = true;
    }
}
