package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File; // File | directory
import java.util.ArrayList;

public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int frameCount;
    public boolean isOnce;

    public Renderer() {

    }

    public Renderer(String url){
        File source = new File(url);
        if(source.exists() && source.isFile()){
            image = SpriteUtils.loadImage(url);

        }
        if(source.exists() && source.isDirectory()){
            images = SpriteUtils.loadImages(url);
            frameCount = 0;
            currentImageIndex = 0;
        }
    }
    public Renderer(String url,boolean isOnce){
        this(url);
        this.isOnce = isOnce;

    }
    public void render(Graphics g, GameObject master){
        if(image != null){
            drawImage(g,image,master);
        }
        if(images!=null){
            BufferedImage currrentImage = images.get(currentImageIndex);
            drawImage(g,currrentImage,master);
            frameCount++;
            if(frameCount>15){
                currentImageIndex++;
                if(currentImageIndex >=images.size()){
                    if(isOnce){
                        master.deactive();
                    }
                    currentImageIndex = 0;
                }
                frameCount = 0;
            }
        }
    }

    private void drawImage(Graphics g, BufferedImage image,GameObject master) {
        g.drawImage(image,
                (int)(master.position.x - master.anchor.x * image.getWidth()),
                (int)(master.position.y - master.anchor.y * image.getHeight()),
                null);
//        if(master.hitBox!=null){
//            g.setColor(Color.GREEN);
//            g.drawRect(
//                    (int) master.hitBox.left(),
//                    (int) master.hitBox.top(),
//                    master.hitBox.width,master.hitBox.height);
//        }

    }
}
