import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //settings
    final int ORIGINALTILESIZE = 16;
    final int SCALE = 2;

    final int TILESIZE = ORIGINALTILESIZE * SCALE;
    final int MAXSCREENCOL = 16;
    final int MAXSCREENROW = 12;
    final int SCREENWIDTH = TILESIZE * MAXSCREENCOL;
    final int SCREENHEIGHT = TILESIZE * MAXSCREENROW;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setDoubleBuffered(true);
    }

}
