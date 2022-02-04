import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //settings
    //final static int ORIGINALTILESIZE = 16;
    //final static int SCALE = 2;
    //final static int TILESIZE = ORIGINALTILESIZE * SCALE;

    final static int SCREENWIDTH = 1920;
    final static int SCREENHEIGHT = 1080;

    Paddle redPaddle, bluePaddle;
    Ball ball;

    Thread TRedPaddle, TBluePaddle, TBall;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        //this.setDoubleBuffered(true);

        redPaddle = new Paddle(250, 150, Paddle.ContactSide.right, false, new Color(255, 0, 0));
        bluePaddle = new Paddle(SCREENWIDTH - 250 - 25, 150, Paddle.ContactSide.left, true, new Color(0, 0, 255));
        ball = new Ball(redPaddle, bluePaddle);

        TRedPaddle = new Thread(redPaddle);
        TBluePaddle = new Thread(bluePaddle);
        TBall = new Thread(ball);

        TRedPaddle.start();
        TBluePaddle.start();
        TBall.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D draw = (Graphics2D)g;

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

    public void nextFrame() {repaint();}
}
