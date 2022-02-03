import javax.swing.*;

public class main {
    public static  void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pong");

        window.add(gamePanel);

        window.pack();

        window.setVisible(true);
    }
}
