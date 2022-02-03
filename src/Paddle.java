import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent implements Runnable { //paddle thichness is 25 pixels
     int xPos;

     Color color;
     public Paddle(int x, Color color) {
          this.xPos = x;
          this.color = color;
     }

     @Override
     public void paintComponent(Graphics g) {}

     @Override
     public void run() {}
}
