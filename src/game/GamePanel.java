package game;

import game.enemy.EnemySummoner;
import game.player.Player;
import game.player.item.ItemSummoner;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    EnemySummoner enemy;
    ItemSummoner Item;
    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy= new EnemySummoner();
        Item = new ItemSummoner();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
             if(object.active) {
                 object.render(g);
             }
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000 / 60) {
                // run logic
                this.runAll();
                // render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
//        for(String key: GameObject.hashMaparr.keySet()){
//            System.out.println(key);
//        }
//        System.out.println(GameObject.hashMaparr.size());
        for(int i=0;i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
            }
        }

    }
}
