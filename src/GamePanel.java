import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //settings
    //final static int ORIGINALTILESIZE = 16;
    //final static int SCALE = 2;
    //final static int TILESIZE = ORIGINALTILESIZE * SCALE;

    final static int SCREENWIDTH = 1920;
    final static int SCREENHEIGHT = 1080;

    Paddle redPaddle, bluePaddle, aaa;
    Ball ball;

    Thread TRedPaddle, TBluePaddle, TBall, aaaa;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        //this.setDoubleBuffered(true);

        redPaddle = new Paddle(250, 1000, Paddle.ContactSide.right, false, new Color(255, 0, 0));
        bluePaddle = new Paddle(SCREENWIDTH - 250 - 25, 1000, Paddle.ContactSide.left, false, new Color(0, 0, 255));
        aaa = new Paddle(SCREENWIDTH/2 - 12, 250, Paddle.ContactSide.right, false, Color.CYAN);
        ball = new Ball(redPaddle, bluePaddle, aaa);

        TRedPaddle = new Thread(redPaddle);
        TBluePaddle = new Thread(bluePaddle);
        aaaa = new Thread(aaa);
        TBall = new Thread(ball);

        TRedPaddle.start();
        TBluePaddle.start();
        aaaa.start();
        TBall.start();
    }

    public void reset() {
        ball.x = SCREENWIDTH - 25;
        ball.y = SCREENHEIGHT - 25;
        ball.vx = 0;
        ball.vy = 0;
    }

    public void redScore() {

    }

    public void blueScore() {

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D draw = (Graphics2D)g;

        draw.setColor(Color.BLACK);
        draw.fillRect(0, 0, SCREENWIDTH, SCREENHEIGHT);

        redPaddle.paintComponent(g);
        bluePaddle.paintComponent(g);
        aaa.paintComponent(g);
        ball.paintComponent(g);
    }

    public void stopThread() {
        TRedPaddle.stop();
        TBluePaddle.stop();
        TBall.stop();
    }

    public void nextFrame() {repaint();}
}
