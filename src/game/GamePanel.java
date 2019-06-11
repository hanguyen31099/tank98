package game;
import game.maps.Map;
import game.player.Player1;
import game.player.Player2;
import game.player.PlayerSummer;
import game.scene.SceneManager;
import game.scene.SceneStage1;
import game.scene.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //Player1 player1;
    PlayerSummer playerSummer;
    Map map;
    public GamePanel() {
        playerSummer = new PlayerSummer();
        map = Map.load("assets/images/Map/map1/map.json");
        //map = Map.load("assets/images/Map/map2/map.json");
        map.generate();

       // SceneManager.signNewScene(new SceneWelcome());
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
        for(int i=0;i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
                
            }
        }

    }
}
