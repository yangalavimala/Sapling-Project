import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Table extends JPanel implements Runnable {
    int GAME_WIDTH=1000;
    int GAME_HEIGHT=(int)(1000*(0.555));
    Dimension SCREEN_SIZE=new Dimension(GAME_WIDTH,GAME_HEIGHT);
     int BALL_DIAMETER=20;
     int PADDLE_HEIGHT=100;
     int PADDLE_WIDTH=25;
     Image image;
      Ball ball;
      Graphics graphics;
      Thread gameThread;
      Paddle paddlel;
      Paddle paddle2;
      Score score=new Score(GAME_WIDTH,GAME_HEIGHT);
    Table()
    {
        this.setPreferredSize(SCREEN_SIZE);
        gameThread =new Thread(this);
        gameThread.start();
        this.setFocusable(true);
        this.addKeyListener((KeyListener) new MyKeys());
        newBall();
        newPaddle();
    }

    private void newPaddle() {
        paddlel=new Paddle(0,GAME_HEIGHT/2-PADDLE_HEIGHT/2,PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2=new Paddle(GAME_WIDTH-PADDLE_WIDTH,GAME_HEIGHT/2-PADDLE_HEIGHT/2,PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    private void newBall(){
        Random random=new Random();
       ball=new Ball(GAME_WIDTH/2,random.nextInt(GAME_HEIGHT),BALL_DIAMETER,BALL_DIAMETER);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        image=createImage(getWidth(),getHeight());
        graphics= image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    private void draw(Graphics graphics)
    {
        ball.draw(graphics);
        paddlel.draw(graphics);
        paddle2.draw(graphics);
        score.draw(graphics);
    }
    public void move()
    {
        ball.move();
        paddlel.move();
        paddle2.move();

    }
    public void Collision() {

        if (ball.y <= 0) {
            ball.yVelocity = -ball.yVelocity;
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.yVelocity = -ball.yVelocity;
        }

        if (ball.intersects(paddlel) || ball.intersects(paddle2)) {
            ball.xVelocity = -ball.xVelocity;
        }
        if (ball.x<0)
        {
            newPaddle();
           newBall();
           score.player2++;
        }
        if(ball.x>=GAME_WIDTH)
        {
            newPaddle();
            newBall();
            score.player1++;
        }

        if(paddlel.y>=GAME_HEIGHT-PADDLE_HEIGHT)
        {
           paddlel.yVelocity=-paddlel.yVelocity;
        }
        if(paddlel.y<0)
        {
            paddlel.yVelocity=-paddlel.yVelocity;
        }
        if(paddle2.y>=GAME_HEIGHT-PADDLE_HEIGHT)
        {
            paddle2.yVelocity=-paddle2.yVelocity;
        }
        if(paddle2.y<0)
        {
            paddle2.yVelocity=-paddle2.yVelocity;
        }
    }
    @Override
    public void run()
    {
        long LastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns =1000000000/amountOfTicks;
        double delta=0;
        while (true)
        {
            long now=System.nanoTime();
            delta+=(now-LastTime)/ns;
            LastTime=now;
            if(delta>=1)
            {
                move();
                repaint();
                Collision();
                delta--;
            }
        }
    }
    public class MyKeys  extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {
           paddlel.keyPressed(e);
           paddle2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddlel.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }

}
