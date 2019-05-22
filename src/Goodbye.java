import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This class will thank the user for playing the game.
</p>
*/
public class Goodbye extends TextOnly
{
 /**
  * This constructor will create a Goodbye object. It will initialize the custom fonts 
  * and register them to the Graphics environment as well as initialize the layout of the panel.
  * It will also call the printTitle() method, the printText() method, and the printFooter() method.
  */   
  public Goodbye()
  {
    initializeFontsAndLayout();
    ge.registerFont (bigTitle);
    ge.registerFont (smallTitle);
    ge.registerFont (defaultFont);
    printTitle();
    printText();
    printFooter();
    this.setBackground(DistractionAction.grey);
    this.setVisible(true);
  }
  
 /**
  * This method will print a goodbye message to the user.
  */   
  public void printText()
  {
   JLabel goodbye = new JLabel ("GOODBYE!", JLabel.CENTER); 
   goodbye.setFont (defaultFont);
   goodbye.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, goodbye, 400, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, goodbye, 70, SpringLayout.NORTH, DistractionAction.frame);
   this.add(goodbye);
   JLabel thank = new JLabel ("THANK YOU FOR PLAYING", JLabel.CENTER);
   thank.setFont (defaultFont);
   thank.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, thank, 250, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, thank, 100, SpringLayout.SOUTH, goodbye);
   this.add(thank);
   JLabel learned = new JLabel ("WE HOPE YOU LEARNED SOMETHING", JLabel.CENTER);
   learned.setFont (defaultFont);
   learned.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, learned, 200, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, learned, 50, SpringLayout.SOUTH, thank);
   this.add(learned);
   JLabel play = new JLabel ("PLAY AGAIN ANYTIME!", JLabel.CENTER);
   play.setFont (defaultFont);
   play.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, play, 280, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, play, 50, SpringLayout.SOUTH, learned);
   this.add(play);
  }
}