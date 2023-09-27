import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gamegui  {


JFrame frame;
Space space;


    public Gamegui() throws IOException {

        frame=new JFrame("Space Invader");
        space=new Space();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(space);
        frame.addKeyListener(space);

        frame.pack();
        frame.setLayout(null);
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
