import java.awt.*;
public class Lives extends Rectangle{
    static int width;
    static int height;
    int lives=3;
    Lives(int width, int height){
        Lives.width=width;
        Lives.height=height;
    }
    public  int getLife()
    {
        return lives;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));

        g.drawString(String.valueOf("Lives: "+lives),(width/2)-300, 25);
    }
}
