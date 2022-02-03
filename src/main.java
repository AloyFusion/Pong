import javax.swing.*;
import java.awt.*;

public class main {
    public static  void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();

        final int FPS = 60;
        int currentFrame = 0;

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.setResizable(false);
        window.setTitle("Pong");

        window.add(gamePanel);

        window.pack();

        window.setVisible(true);

        while (true) {
            currentFrame++;
            gamePanel.nextFrame();
            try {
                Thread.sleep(1000/FPS);
            } catch (Exception e) {}
        }
    }
}
