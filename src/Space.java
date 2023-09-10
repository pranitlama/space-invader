import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Space extends JPanel implements ActionListener, KeyListener {

    private int width=400;
    private  int height=700;
    private boolean movingleft=false;
    private boolean movingright=false;
    Spaceship spaceship;

    Shipbullet shipbullet;
    boolean moved=false;

    int bulletx=160;
    int bullety=590;


    //smooth ko lagi
    private Timer timer;


    Space(){
        spaceship=new Spaceship();

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);

        timer =new Timer(1,this);

        timer.start();



    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;


        spaceship.draw(g2d);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(movingright)
        {

            if(spaceship.xpos<=330) {
                spaceship.move(3);
                bulletx=bulletx+3;
               moved=true;


            }
        } else if (movingleft) {

            if(spaceship.xpos>=-3) {
                spaceship.move(-3);
                bulletx=bulletx-3;

moved=true;

            }
        }

        if(moved)

        {
            repaint();
            moved=true;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()==37)
        {


            movingleft=true;




        } else if (e.getKeyCode()==39) {



            movingright = true;



        } else if ((e.getKeyCode()==KeyEvent.VK_SPACE)) {
                shipbullet=new Shipbullet(100,bullety);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()==37)
        {


            movingleft=false;




        } else if (e.getKeyCode()==39) {

            movingright=false;


        }
    }
}
