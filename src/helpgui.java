import javax.swing.*;
import java.awt.*;

public class helpgui {

    JFrame frame;
    JLabel label;

    public helpgui()
    {
        frame=new JFrame("SUDOKU");
        label=new JLabel("HELP");

        label.setBounds(250,120,150,70);


        Font labelFont = new Font("Arial", Font.PLAIN, 24);
        label.setFont(labelFont);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
