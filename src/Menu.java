import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Menu extends JFrame {
//    private Image backgroundImage;

Space space;

    {
        try {
            space = new Space();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Menu() throws SQLException, ClassNotFoundException {
        final JLabel highScoreLabel;

        setTitle("Space Invader Menu");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        getContentPane().setBackground(Color.BLUE); // Set frame background color

        // Create a panel for the centered box
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
//        centerPanel.setPreferredSize(new Dimension(600, 700));
        centerPanel.setBackground(Color.BLACK);

        // Create buttons
        JButton startButton = createMenuButton("Start Game");
        JButton descriptionButton = createMenuButton("Description");
        JButton exitButton = createMenuButton("Exit");


        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to start the game here
                try {
                    Gamegui gui=new Gamegui();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                // You can open a new game window or change the current panel to the game screen
//                JOptionPane.showMessageDialog(null, "Starting the game!");
            }
        });

        descriptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to open the options menu here
                // You can create a new window or dialog for changing game settings
                JOptionPane.showMessageDialog(null, "Move your spaceship left and right with arrow keys. Press Space Bar to shoot a bullet.");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the game here
                System.exit(0);
            }
        });

        // Create a label for displaying high score
//        highScoreLabel = new JLabel("High Score: 0", SwingConstants.CENTER);
        try {
            int highscore = space.getHighScore();


        highScoreLabel = new JLabel("Highscore: "+highscore, SwingConstants.CENTER);
//        highScoreLabel = new JLabel("High Score: 0");
        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        highScoreLabel.setForeground(Color.WHITE);
        highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons and high score label to the center panel
        centerPanel.add(Box.createVerticalStrut(200)); // Space at the top
        centerPanel.add(startButton);
        centerPanel.add(Box.createVerticalStrut(40)); // Space between buttons
        centerPanel.add(descriptionButton);
        centerPanel.add(Box.createVerticalStrut(40)); // Space between buttons
        centerPanel.add(exitButton);
        centerPanel.add(Box.createVerticalStrut(40)); // Space between buttons
        centerPanel.add(highScoreLabel);
        centerPanel.add(Box.createVerticalStrut(100)); // Space at the bottom

        // Add the center panel to the frame
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button text
        button.setFocusPainted(false);

        return button;
    }
//    public void draw(Graphics g){
//        Graphics2D g2d=(Graphics2D)g;
//        backgroundImage=new ImageIcon(getClass().getResource("background.jpg")).getImage();
//        g2d.drawImage(backgroundImage, 0, 0, 600, 700, null);
//    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Menu();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}


