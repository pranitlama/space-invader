import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private int dy; // Vertical velocity

    private final int width = 20;
    private final int height = 20;

    Image image;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        dy = 1; // Vertical velocity (change this value to control the speed of descent)
    }

    public void draw(Graphics g) {
//        g.setColor(Color.RED);
//        g.fillRect(x, y, width, height);

        Graphics2D g2d=(Graphics2D)g;
        image=new ImageIcon(getClass().getResource("enemy.png")).getImage();
        g2d.drawImage(image, x, y, null);
    }

    public void move() {
        // Move downward
        y += dy;

        // You can add logic here to check if enemies reach the bottom of the screen
        // and handle the game-over condition or other behaviors as needed.
    }

    // Getter methods for enemy position and dimensions
    public int getX() {
        return x;
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


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


}