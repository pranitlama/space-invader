import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spaceship extends JPanel  {

    public  int xpos=160;
    public  int ypos=590;




    Image image;

    public  void draw(Graphics g)
    {
        System.out.println("inside spaceship");
        Graphics2D g2d=(Graphics2D)g;
        image=new ImageIcon(getClass().getResource("empire-ship.png")).getImage();
//        System.out.println(image);



                g2d.drawImage(image, xpos, ypos, null);






    }

    public  void move(int speed){
        System.out.println(xpos);
        xpos=xpos+speed;
    }


}
