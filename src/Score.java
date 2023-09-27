import java.awt.*;

public class Score extends Rectangle{
    static int width;
    static int height;
    int score;

    Score(int width, int height){
        Score.width=width;
        Score.height=height;
    }

    public  int getscore()
    {
        return score;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));

        g.drawString(String.valueOf("Score: "+score),(width/2)-300, 60);
    }

}
