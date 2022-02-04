import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent implements Runnable {
    final int BALLDIAMETER = 50;
    int x, y;
    int vx, vy;

    public Ball() {
        x = GamePanel.SCREENWIDTH/2;
        y = GamePanel.SCREENHEIGHT/2;

        //the amount of pixels moved every 10 mills
        vx = 5;
        vy = 5;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D draw = (Graphics2D)g;

        draw.setColor(Color.WHITE);
        draw.fillOval(x, y, BALLDIAMETER, BALLDIAMETER);
    }

    @Override
    public void run() {
        while (true) {
            x += vx;
            y += vy;

            if (this.x <= 0 || this.x >= GamePanel.SCREENWIDTH - BALLDIAMETER) {
                vx = -vx;
            }
            if (this.y <= 0 || this.y >= GamePanel.SCREENHEIGHT - BALLDIAMETER) {
                vy = -vy;
            }

            this.nextFrame();

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }

    public void nextFrame() {repaint();}
}
