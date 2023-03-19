import java.awt.*;

public class Score extends Rectangle {
    int GAME_WIDTH;
    int GAME_HEIGHT;
    int player1;
    int player2;
    Score(int GAME_WIDTH,int GAME_HEIGHT)
    {
        this.GAME_HEIGHT=GAME_HEIGHT;
        this.GAME_WIDTH=GAME_WIDTH;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString(String.valueOf(player1),GAME_WIDTH/2-80,100);
        g.drawString(String.valueOf(player2),GAME_WIDTH/2+20,100);
    }
}
