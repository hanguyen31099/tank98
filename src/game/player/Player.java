package game.player;

import game.*;
import game.explosion.Explosion;
import game.player.item.Barrel;
import game.player.item.Item;
import game.Physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends GameObject {
    public boolean immune;
    public boolean changeImage = false;
    public int numberBullet;
    public boolean isFrist = true;
    public static String image,image1,image2,image3,image4;
    public int hp;
    public Player() {
        key = "Player";
        image1 = "assets/images/players/player/lv1/lv1-up";
        image2 = "assets/images/players/player/lv1/lv1-down";
        image3 = "assets/images/players/player/lv1/lv1-left";
        image4 = "assets/images/players/player/lv1/lv1-right";
        image = image1;
        renderer = new Renderer(image);
        this.position = Settings.PLAYER_POSITION;
        hitBox = new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);
        hp = 10;
        immune = false;
        numberBullet = 3;
        GameObject.addToHashMap(key,this);
    }
    int count = 0; // dem so khung hinh

    int renderCount;
    @Override
    public void render(Graphics g) {
        Settings.PLAYER_POSITION = this.position;
        if (hp>0&&changeImage==true){
            renderer = new Renderer(image);
            changeImage = false;
        }
        if(immune){
            renderCount++;
            if(renderCount>=5){
                renderCount = 0;
                super.render(g);
            }
        }
        else{
            super.render(g);
        }
    }

    @Override
    public void run() { // 60 fps >> 60 vien dan dc tao ra 1s >> 3 vien duoc tao ra 1s
        super.run();
        this.move();
        this.limit();
        this.fire();
        this.boom();
        this.checkItem();
        this.checkImmune();
    }
    int countBoom= 0 ;
    private void boom() {
        countBoom++;
        if (((countBoom>=30||isFrist))&&KeyEventPress.isBoom==true){
            isFrist = false;
            countBoom = 0;
            Barrel barrel = GameObject.recycle(Barrel.class);
            barrel.position.set(this.position);
        }
    }


    private void checkItem() {
        Item item = GameObject.findInterSects(Item.class,this.hitBox);
        if(item != null){
            item.powerUp(this);
            item.deactive();
        }
    }

    private void fire() {
        count++;
        if(KeyEventPress.isFirePress&&((count>= 30||isFrist))){
            isFrist = false;
            count = 0;
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.isresus = true;
            if(image==image1){
                bullet.velocity.set(0,-3);
            }
            if(image==image2){
                bullet.velocity.set(0,3);
            }
            if(image==image3){
                bullet.velocity.set(-3,0);
            }
            if(image==image4){
                bullet.velocity.set(3,0);
            }
            bullet.position.set(this.position);
        }
    }
    private void limit() {
        position.x = Mathx.clamp(position.x, 20, Settings.BACKGROUND_WIDTH -10);
        position.y = Mathx.clamp(position.y, 20, Settings.GAME_HEIGHT -30);
    }
    private void move() {
        if(KeyEventPress.isUpPress) {
            position.y-=5;
            image = image1;
            changeImage = true;
        }
        if(KeyEventPress.isDownPress) {
            position.y+=5 ;
            image = image2;
            changeImage = true;
        }
        if(KeyEventPress.isLeftPress) {
            position.x-=5;
            image = image3;
            changeImage = true;
        }
        if(KeyEventPress.isRightPress) {
            position.x+=5;
            image = image4;
            changeImage = true;
        }

    }

    int immuneCount = 0;
    private void checkImmune() {
        if(immune){
            immuneCount++;
            if(immuneCount>60){
                immune = false;
            }
        }else{
            immuneCount = 0;
        }
    }

    public void TakeDame(int dame) {
        if(!immune){
            hp-=dame;
            if(hp<=0){
                hp = 0;
                this.deactive();
            }
            else{
                immune = true;
            }
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position);
    }
}
