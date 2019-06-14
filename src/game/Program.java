package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));

        window.add(panel); // location
        window.pack();
        window.setTitle("Game Touhou");
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyEventPress.isKeyPress = true;
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isPlayer1UpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isPlayer1LeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isPlayer1DownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isPlayer1RightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isPlayer1FirePress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyEventPress.isPlayer2UpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyEventPress.isPlayer2DownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyEventPress.isPlayer2LeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyEventPress.isPlayer2RightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    KeyEventPress.isPlayer2FirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isKeyPress = false;
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isPlayer1UpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isPlayer1DownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isPlayer1LeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isPlayer1RightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isPlayer1FirePress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyEventPress.isPlayer2UpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyEventPress.isPlayer2DownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    KeyEventPress.isPlayer2LeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    KeyEventPress.isPlayer2RightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    KeyEventPress.isPlayer2FirePress = false;
                }
            }
        };
        window.addKeyListener(keyHandler);
        window.setVisible(true);

        panel.gameLoop();
        // ctrl + ? : comment/uncomment
        // alt + enter : sua loi code
        // (fn +) shift + f6 : doi ten
//        // alt + ctrl + l : format code
    }
}
