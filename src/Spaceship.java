import javax.swing.*;
import java.awt.*;

public class Spaceship {
    private int x;
    private int y;
    private int dx;

    private final int width = 40;
    private final int height = 20;

    Image image;

    public Spaceship() {
//        x = 380; // Initial player position
        x = 300; // Initial player position
//        y = 500; // Initial player position
        y = 600; // Initial player position
    }

    public void draw(Graphics g) {
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, width, height);

        Graphics2D g2d=(Graphics2D)g;
        image=new ImageIcon(getClass().getResource("hero.png")).getImage();
        g2d.drawImage(image, x, y, null);
    }

    public void move() {
        x += dx;

        // Ensure the player stays within the screen bounds
        if (x < 0) {
            x = 0;
//        } else if (x > 760) {
        } else if (x > 525) {
//            x = 760;
            x = 525;
        }
    }

    // Getter methods for player position and dimensions
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

    // Setter method for horizontal velocity
    public void setDx(int dx) {
        this.dx = dx;
    }
}
