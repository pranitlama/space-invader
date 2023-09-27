import javax.swing.*;
import java.awt.*;

public class Shipbullet {
    private int x;
    private int y;
    private int dy; // Vertical velocity

    private final int width = 5;
    private final int height = 10;

    Image image;

    public Shipbullet(int x, int y) {
        this.x = x;
        this.y = y;
        dy = -3; // Bullet moves upward with a negative vertical velocity
    }

    public void draw(Graphics g) {
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, width, height);

        Graphics2D g2d=(Graphics2D)g;
        image=new ImageIcon(getClass().getResource("bullet.png")).getImage();
        g2d.drawImage(image, x, y, null);
    }

    public void move() {
        y += dy;

        // Remove the bullet if it goes off-screen
        if (y < 0) {
            // You can remove bullets here or implement bullet recycling
        }
    }

    // Getter methods for bullet position and dimensions
    public int getX() {
        return x;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
