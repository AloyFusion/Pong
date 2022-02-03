import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent implements Runnable {
    int x, y;
    int vx, vy;

    public Ball() {
        x = GamePanel.SCREENWIDTH/2;
        y = GamePanel.SCREENHEIGHT/2;

        //the amount of pixels moved every 10 mills
        vx = -1;
        vy = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D draw = (Graphics2D)g;

        draw.setColor(Color.WHITE);
        draw.fillOval(x, y, 50, 50);
    }

    @Override
    public void run() {
        while (true) {
            x += vx;
            y += vy;

            this.nextFrame();

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }

    public void nextFrame() {repaint();}
}
