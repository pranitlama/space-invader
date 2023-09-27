

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.awt.Graphics;

public class Space extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private Spaceship spaceship;
    private List<Enemy> enemies;
    private List<Shipbullet> bullets;
    private boolean gameOver = false;
    private Image backgroundImage;
    Score score;


    public Space() {
        spaceship = new Spaceship();
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(15, this);
        timer.start();
        spawnEnemies();

        score = new Score(600, 700);
    }
    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        backgroundImage=new ImageIcon(getClass().getResource("background.jpg")).getImage();
        g2d.drawImage(backgroundImage, 0, 0, 600, 700, null);

        score.draw(g);
    }

    public void spawnEnemies() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(540);
            int y = rand.nextInt(100);
            Enemy newEnemy = new Enemy(x, y);

            boolean overlap = false;
            for (Enemy existingEnemy : enemies) {
                if (newEnemy.getBounds().intersects(existingEnemy.getBounds())) {
                    overlap = true;
                    break;
                }
            }

            // If there's no overlap, add the new enemy
            if (!overlap) {
                enemies.add(newEnemy);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameOver) {
            draw(g);
            spaceship.draw(g);
            for (Enemy enemy : enemies) {
                enemy.draw(g);
            }
            for (Shipbullet bullet : bullets) {
                bullet.draw(g);
            }
        } else {
            // Game over message
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over", 250, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            spaceship.move();

            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                enemy.move();

                // Check if the enemy has crossed the bottom of the window
                if (enemy.getY() > getHeight()) {
                    enemyIterator.remove();
                    if(score.score>0) {
                        score.score = score.score - 5;
                    }
                }
            }
//            for (Enemy enemy : enemies) {
//                enemy.move();
//
//            }
            for (Shipbullet bullet : bullets) {
                bullet.move();
            }
            checkCollisions();
            spawnEnemiesIfNeeded();



            // Check and spawn new enemies as needed



            repaint();
        }
    }

    public void spawnEnemiesIfNeeded() {
        // Check if there are fewer than a certain number of enemies on the screen
        if (enemies.size() < 8) { // Adjust the number as needed
            Random rand = new Random();
            int x = rand.nextInt(540);
            int y = rand.nextInt(100);
            enemies.add(new Enemy(x, y));
        }
    }

    public void checkCollisions() {
        Iterator<Shipbullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Shipbullet bullet = bulletIterator.next();
            Rectangle bulletBounds = bullet.getBounds();

            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                Rectangle enemyBounds = enemy.getBounds();

                if (bulletBounds.intersects(enemyBounds)) {
                    bulletIterator.remove();
                    enemyIterator.remove();
                    score.score = score.score + 10;
                }
            }
        }

        if (enemies.isEmpty()) {
            gameOver = true;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            spaceship.setDx(-2);
        }
        if (key == KeyEvent.VK_RIGHT) {
            spaceship.setDx(2);
        }
        if (key == KeyEvent.VK_SPACE) {
            bullets.add(new Shipbullet(spaceship.getX() + spaceship.getWidth() / 2, spaceship.getY()));
//            bullets.add(new Shipbullet(5,10));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            spaceship.setDx(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders");
        Space game = new Space();
        frame.add(game);
//        frame.setSize(800, 600);
        frame.setSize(600, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
