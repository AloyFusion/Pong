import javax.swing.*;
import java.awt.*;

public class Paddle extends JComponent implements Runnable { //paddle thickness is 25 pixels
     Point cursorPos;

     int contactX;
     int xPos, yPos;
     int height;

     boolean bot;

     enum ContactSide {left, right}

     Color color;
     public Paddle(int x, int height, Paddle.ContactSide ContactSide, boolean bot, Color color) {
          this.xPos = x;
          this.height = height;
          this.yPos = GamePanel.SCREENHEIGHT/2;
          this.contactX = 0;
          this.bot = bot;
          this.color = color;

          if (ContactSide == Paddle.ContactSide.right) {
               contactX = 25;
          }
     }

     //public void setCursorPos(Point CursorPos) {this.CursorPos = CursorPos;}

     @Override
     public void paintComponent(Graphics g) {
          Graphics2D draw = (Graphics2D)g;

          draw.setColor(color);
          draw.fillRect(xPos, yPos, 25, height);
     }

     @Override
     public void run() {
          if (bot) {
              while (true) {

                 nextFrame();
              }
          }
          else {
               while (true) {
                    cursorPos = MouseInfo.getPointerInfo().getLocation();
                    yPos = cursorPos.y;
                    //System.out.print("(" + cursorPos.x + "," + cursorPos.y + "0");

                    nextFrame();
               }
          }
     }

     public void nextFrame() {repaint();}
}
