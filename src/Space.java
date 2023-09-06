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


    Space(){
        spaceship=new Spaceship();

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);



    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;
        System.out.println("inside space");

        spaceship.draw(g2d);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if(movingright)
        {
            System.out.println("moving right");
            if(spaceship.xpos<=330) {
                spaceship.move(3);


            }
        } else if (movingleft) {
            System.out.println("moving left");
            if(spaceship.xpos>=-3) {
                spaceship.move(-3);


            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()==37)
        {
    spaceship.move(-3);
    repaint();
            movingleft=true;



        } else if (e.getKeyCode()==39) {

            spaceship.move(3);
            repaint();
            movingright = true;


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==37)
        {
            movingleft=false;
            repaint();



        } else if (e.getKeyCode()==39) {

            movingright=false;
repaint();

        }
    }
}
