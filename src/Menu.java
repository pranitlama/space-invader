import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Space Invaders");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel to hold the menu items
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Create buttons for the menu options
        JButton startButton = new JButton("Start Game");
        JButton optionsButton = new JButton("Options");
        JButton exitButton = new JButton("Exit");

        // Add action listeners to the buttons
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to start the game here
                try {
                    Gamegui gui=new Gamegui();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // You can open a new game window or change the current panel to the game screen
//                JOptionPane.showMessageDialog(null, "Starting the game!");
            }
        });

        optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to open the options menu here
                // You can create a new window or dialog for changing game settings
                JOptionPane.showMessageDialog(null, "Opening options menu!");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the game here
                System.exit(0);
            }
        });

        // Add buttons to the panel
        panel.add(startButton);
        panel.add(optionsButton);
        panel.add(exitButton);

        // Add the panel to the frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }
}

