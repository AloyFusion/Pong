import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //settings
    final int ORIGINALTILESIZE = 16;
    final int SCALE = 2;
    final int TILESIZE = ORIGINALTILESIZE * SCALE;

    final int SCREENWIDTH = 1920;
    final int SCREENHEIGHT = 1080;

    Paddle redPaddle, bluePaddle;
    Ball ball;

    Thread TRedPaddle, TBluePaddle, TBall;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setDoubleBuffered(true);

        redPaddle = new Paddle(250, new Color(255, 0, 0));
        bluePaddle = new Paddle(SCREENWIDTH - 250 - 25, new Color(0, 0, 255));
        ball = new Ball();

        TRedPaddle = new Thread(redPaddle);
        TBluePaddle = new Thread(bluePaddle);
        TBall = new Thread(ball);

        TRedPaddle.start();
        TBluePaddle.start();
        TBall.start();
    }

    @Override
    public void paintComponents(Graphics g) {
        Graphics2D draw = (Graphics2D) g;

        draw.setColor(Color.BLACK);
        draw.fillRect(0, 0, SCREENWIDTH, SCREENHEIGHT);

        redPaddle.paintComponent(g);
        bluePaddle.paintComponent(g);
        ball.paintComponent(g);
    }

    public void stopThread() {
        TRedPaddle.stop();
        TBluePaddle.stop();
        TBall.stop();
    }

    public void nextFrame() {
        this.repaint();
    }

}
