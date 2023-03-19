import javax.swing.*;
import java.awt.*;

public class GameFrame {
 JFrame frame;
    Table table;
 GameFrame() {
     frame = new JFrame("Pong Game");
     table=new Table();
     table.setBackground(Color.black);
     frame.add(table);
     frame.setResizable(false);
     frame.setBackground(Color.black);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     frame.pack();
     frame.setLocationRelativeTo(null);
 }
}
