package game.enemy;

import game.GameObject;
import game.Physics.BoxCollider;
import game.Settings;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Zombie extends Enemy {
    public Zombie(){
        key = "Zombie";
        image1 = "assets/images/enemies/level0/Zombie/zombieUP.png";
        image2 = "assets/images/enemies/level0/Zombie/zombieDOWN.png";
        image3 = "assets/images/enemies/level0/Zombie/zombieLEFT.png";
        image4 = "assets/images/enemies/level0/Zombie/zombieRIGHT.png";
        image = image2;
        renderer = new Renderer(image);
        hitBox = new BoxCollider(this,renderer.image.getWidth(),renderer.image.getHeight());
        velocity.set(0,1);
        dame = 1;
        hp = 3;
        GameObject.addToHashMap(key,this);
    }
    @Override
    public void reset() {
        super.reset();
        position.set(0,-50);
        hp = 3;
    }

    @Override
    public void render(Graphics g) {
        if(this.hp>0)
            renderer = new Renderer(image);
        super.render(g);
    }

    @Override
    public void run() {
        int angle = move();
        if(angle!=-1)
            this.velocity.setAngle(Math.toRadians(angle));
        super.run();
        this.velocity.set(0,1);
    }
    private int move(){
        // double y = this.position.y-Settings.PLAYER_POSITION.y;
        // double x = this.position.x-Settings.PLAYER_POSITION.x;
        double playerX = Settings.PLAYER_POSITION.x;
        double playerY = Settings.PLAYER_POSITION.y;
        double moveX = Math.abs(this.position.x-playerX);
        double moveY = Math.abs(this.position.y-playerY);
//        if(x==0){
//            if(y<0) {
//                velocity.setAngle(Math.toRadians(90));
//            }
//            else{
//                velocity.setAngle(Math.toRadians(-90));
//            }
//        }
//        else {
//            if((x>0&&y<0 )|| (x>0&&y>0)){
//                velocity.setAngle(Math.atan(y/x)+
//                        Math.abs(90+Math.abs(Math.atan(y/x))));
//            }
//            else{
//                velocity.setAngle(Math.atan(y/x));
//            }
//        }
        if(moveX>=10){
            if(moveY>=10){
                if(moveX<moveY){
                    if(this.position.x<playerX){
                        image = image4;
                        return 0;
                    }
                    if(this.position.x>playerX){
                        image = image3;
                        return 180;
                    }
                }
                else{
                    if(this.position.y<playerY){
                        image = image2;
                        return 90;
                    }
                    if(this.position.y>playerY){
                        image = image1;
                        return -90;
                    }
                }
            }
            else{
                if(this.position.x<playerX){
                    image = image4;
                    return 0;
                }
                if(this.position.x>playerX){
                    image = image3;
                    return 180;
                }
            }
        }
        else{
            if(this.position.y<playerY){
                image = image2;
                return 90;
            }
            if(this.position.y>playerY){
                image =image1;
                return -90;
            }
        }
        return -1;
    }
}
