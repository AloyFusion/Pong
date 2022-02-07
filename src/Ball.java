import javax.swing.*;
import java.awt.*;

public class Ball extends JComponent implements Runnable {
    Paddle paddle1, paddle2, aaa;
    final int BALLDIAMETER = 50;
    int x, y;
    int vx, vy;

    public Ball(Paddle paddle1, Paddle paddle2, Paddle aaa) {
        x = GamePanel.SCREENWIDTH/2;
        y = GamePanel.SCREENHEIGHT/2;

        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.aaa = aaa;

        //the amount of pixels moved every 10 mills
        vx = 5;
        vy = 5;
    }

    public void setX(int x) {this.x = x;}

    public void  setY(int y) {this.y = y;}

    public void setVx(int vx) {this.vx = vx;}

    public void setVy(int vy) {this.vy = vy;}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D draw = (Graphics2D)g;

        draw.setColor(Color.WHITE);
        draw.fillOval(x, y, BALLDIAMETER, BALLDIAMETER);
    }

    @Override
    public void run() {
        while (true) {
            if ((this.x == paddle1.xPos + 25 && this.y >= paddle1.yPos + 25 && this.y <= paddle1.yPos + paddle1.height + 25) ||
                    (this.x == paddle2.xPos - 50 && this.y >= paddle2.yPos + 25 && this.y <= paddle2.yPos + paddle2.height + 25) ||
                    (this.x == aaa.xPos -50 && this.y >= aaa.yPos + 25 && this.y <= aaa.yPos + aaa.height + 25)) {
                vx = -vx;
            }

            if (this.y <= 0 || this.y >= GamePanel.SCREENHEIGHT - BALLDIAMETER) {
                vy = -vy;
            }

            /*
            if (this.x < 0) {
                reset();
                blueScore();
            }
            else if (this.x > GamePanel.SCREENWIDTH) {
                reset();
                redScore();
            }
        */

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
