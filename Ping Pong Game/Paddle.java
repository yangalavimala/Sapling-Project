import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    int id;
    int yVelocity;
    Paddle(int x,int y,int PADDLE_WIDTH,int PADDLE_HEIGHT,int id)
    {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }
    public void draw(Graphics g)
    {
        if(id==1) {
            g.setColor(Color.red);
        }
        if(id==2){
        g.setColor(Color.blue);
    }
        g.fillRect(x,y,width,height);
    }
    public void move()
    {
        y+=yVelocity;
    }
    public void keyReleased(KeyEvent e)
    {
        switch (id) {
            case 1:   if (e.getKeyCode() == KeyEvent.VK_UP) {
                yVelocity = 0;
            }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yVelocity = 0;
                }
                break;
            case 2:if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                yVelocity=0;
            }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    yVelocity=0;
                }
        }
    }
    public void keyPressed(KeyEvent e)
    {
        switch (id) {
         case 1:   if (e.getKeyCode() == KeyEvent.VK_UP) {
                yVelocity = -5;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                yVelocity = 5;
            }
            break;
            case 2:if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                yVelocity=5;
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                yVelocity=-5;
            }
        }
    }
}
