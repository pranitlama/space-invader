import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shipbullet extends JPanel implements ActionListener {
    private int bulletX;
    private int bulletY;
    private Timer timer;

    public Shipbullet(int x, int y) {
        bulletX = x;
        bulletY = y;
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawBullet(g);
    }

    private void drawBullet(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(bulletX, bulletY, 5, 10); // Adjust the size and color as needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
        bulletY -= 5; // Adjust the bullet speed as needed

        if (bulletY < 0) {
            timer.stop();
        }

        repaint();
    }
}