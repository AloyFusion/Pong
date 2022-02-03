import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //settings
    final int ORIGINALTILESIZE = 16;
    final int SCALE = 2;
    final int TILESIZE = ORIGINALTILESIZE * SCALE;

    final int SCREENWIDTH = 1920;
    final int SCREENHEIGHT = 1080;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setDoubleBuffered(true);
    }

    public void nextFrame(Graphics2D g) {
        this.paintComponent(g);
    }

}
