import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent implements Runnable {
    Paddle paddle1, paddle2;
    final int BALLDIAMETER = 50;
    int x, y;
    int vx, vy;

    public Ball(Paddle paddle1, Paddle paddle2) {
        x = GamePanel.SCREENWIDTH/2;
        y = GamePanel.SCREENHEIGHT/2;

        this.paddle1 = paddle1;
        this.paddle2 = paddle2;

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
            if (this.x <= 0 || this.x >= GamePanel.SCREENWIDTH - BALLDIAMETER ||
                    (this.x == paddle1.xPos && this.y == paddle2.yPos) || (this.x == paddle2.xPos && this.y == paddle2.yPos) ) {
                vx = -vx;
            }

            if (this.y <= 0 || this.y >= GamePanel.SCREENHEIGHT - BALLDIAMETER) {
                vy = -vy;
            }

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
