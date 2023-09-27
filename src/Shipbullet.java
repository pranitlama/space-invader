import javax.swing.*;
import java.awt.*;

public class Shipbullet {
    private int x;
    private int y;
    private int dy;

    private final int width = 5;
    private final int height = 10;

    Image image;

    public Shipbullet(int x, int y) {
        this.x = x;
        this.y = y;
        dy = -3;
    }

    public void draw(Graphics g) {


        Graphics2D g2d=(Graphics2D)g;
        image=new ImageIcon(getClass().getResource("bullet.png")).getImage();
        g2d.drawImage(image, x, y, null);
    }

    public void move() {
        y += dy;


    }



    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public int getY() {
        return y;
    }


}
