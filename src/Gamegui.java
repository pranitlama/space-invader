import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Gamegui  {

JFrame frame;
Space space;


    public Gamegui() throws IOException, SQLException, ClassNotFoundException {

        JFrame frame = new JFrame("Space Invaders");
        Space game = new Space();
            frame.add(game);

            frame.setSize(600, 700);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

//        frame=new JFrame("Space Invader");
//        space=new Space();
//
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(space);
//        frame.addKeyListener(space);
//
//        frame.pack();
//        frame.setLayout(null);
////        frame.setResizable(false);
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
    }

}
