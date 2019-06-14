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
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public GamePanel() {
        SceneManager.signNewScene(new SceneWelcome());
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
