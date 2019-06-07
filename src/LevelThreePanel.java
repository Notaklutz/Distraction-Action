import java.awt.*;
import javax.swing.*;
import java.io.*;

public class LevelThreePanel extends JPanel{
  public LevelThreeGame gameCanvas;
      
  public LevelThreePanel(DistractionAction d){
    gameCanvas = new LevelThreeGame(d);
    setLayout(new FlowLayout());
    setVisible(true);
    add(gameCanvas);
  }
}