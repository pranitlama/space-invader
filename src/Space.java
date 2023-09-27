

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
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

    File scoreFile;
    FileWriter fileWriter;
    int highscore;




    public Space() throws IOException {
        spaceship = new Spaceship();
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(15, this);
        timer.start();
        spawnEnemies();
        getHighScore();

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
            g.drawString("Game Over", 200, 300);
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


                if (spaceship.getBounds().intersects(enemy.getBounds())) {

//
                    enemyIterator.remove();
//                    System.out.println("game over");
                    gameOver=true; //gameover garcha
//
                        setHighscore(); //highscore set garcha

                }

                // Check if the enemy has crossed the bottom of the window
                if (enemy.getY() > getHeight()) {
                    enemyIterator.remove();
                    if(score.score>0) {
                        score.score = score.score - 5;
                    }
                }
            }


            Iterator<Shipbullet> bulletIterator = bullets.iterator();
            while (bulletIterator.hasNext()) {
                Shipbullet bullet = bulletIterator.next();
                bullet.move();

                // Check if the bullet has gone off the top or bottom of the window
                if (bullet.getY() < 0 || bullet.getY() > getHeight()) {
                    bulletIterator.remove();
                }
            }
            checkCollisions();
            spawnEnemiesIfNeeded();







            repaint();
        }
    }

    public void getHighScore() throws IOException {
        scoreFile = new File("score.txt");
        BufferedReader reader =new BufferedReader(new FileReader(scoreFile));
        String Int_line;
        Int_line = reader.readLine();
        int value = Integer.parseInt(Int_line);
        highscore = value;
        System.out.println(highscore);
    }


    public  void setHighscore(){

        int scorevalue=score.getscore();
        System.out.println(scorevalue);
        if( scorevalue> highscore)
        {
            try {

                scoreFile.delete();
                scoreFile.createNewFile();
                fileWriter = new FileWriter(scoreFile);
                fileWriter.write(scorevalue + "");
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            spaceship.setDx(0);
        }
    }

//    public static void main(String[] args) throws IOException {
//        JFrame frame = new JFrame("Space Invaders");
//        Space game = new Space();
//        frame.add(game);
//
//        frame.setSize(600, 700);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
