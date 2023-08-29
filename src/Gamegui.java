import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamegui implements ActionListener {


    JFrame frame;
    JLabel label;
    JButton start;
    JButton exit;

    JButton help;


    public Gamegui()
    {
           frame=new JFrame("SUDOKU");
           label=new JLabel("SUDOKU");
           start=new JButton("Start");
           help=new JButton("Help");
           exit=new JButton("Exit");



           label.setBounds(250,120,150,70);
           start.setBounds(225,200,150,70);
           start.setBackground(Color.lightGray);
        help.setBounds(225,300,150,70);
           help.setBackground(Color.lightGray);
        exit.setBounds(225,400,150,70);
           exit.setBackground(Color.lightGray);

        Font labelFont = new Font("Arial", Font.PLAIN, 24);
        label.setFont(labelFont);
           frame.add(label);
        frame.add(start);
        frame.add(help);
        frame.add(exit);
        start.addActionListener(this);
        help.addActionListener(this);
        exit.addActionListener(this);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(600,600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start)
        {
            System.out.println("inside start");
            frame.setVisible(false);
            maingame mg=new maingame();
        } else if (e.getSource()==help) {
            helpgui helpgui=new helpgui();

        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
    }
}
