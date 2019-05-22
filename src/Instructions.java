import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This class will instruct the user on how to play each room of the game.
</p>
*/
public class Instructions extends TextOnly
{
 /**
  * This constructor will create an Instructions object. It will initialize the custom fonts 
  * and register them to the Graphics environment as well as initialize the layout of the panel. 
  * It will also call the printTitle() method, the printText() method for the Panic Room, and the printFooter() method.
  * @param room An int parameter that is used to distinguish the correct constructor for the instructions of each room. 0 is for the deficiencies room, 1 is for the panic room, and any other int is for the escape room.
  */   
  public Instructions(int room)
  {
    initializeFontsAndLayout();
    ge.registerFont (bigTitle);
    ge.registerFont (smallTitle);
    ge.registerFont (defaultFont);
    this.setBackground(DistractionAction.grey);
    printTitle();
    if (room == 1)
      printText();
    else if (room == 2)
      printText(room);
    else
      printText("escape");
    printFooter();
  }
  
 /**
  * This method will print the instructions of the Deficiencies Room.
  */ 
  public void printText()
  {
   JLabel line1 = new JLabel ("In the Deficiencies Room, you will learn how to avoid distractions and stay focused."); 
   line1.setFont (defaultFont);
   line1.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, line1, 250, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, line1, 150, SpringLayout.SOUTH, DistractionAction.frame);
   this.add(line1);
   JLabel line2 = new JLabel ("Afterwards, you will take a quiz to test your knowledge. Simply move your character into");
   line2.setFont (defaultFont);
   line2.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, line2, 200, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, line2, 50, SpringLayout.SOUTH, line1);
   this.add(line2);
   JLabel line3 = new JLabel ("the answer of your choice to select it. Good luck!");
   line3.setFont (defaultFont);
   line3.setForeground(Color.white);
   layout.putConstraint(SpringLayout.WEST, line3, 280, SpringLayout.WEST, DistractionAction.frame);
   layout.putConstraint(SpringLayout.NORTH, line3, 50, SpringLayout.SOUTH, DistractionAction.frame);
   this.add(line3);
  }
  
 /**
  * This method will print the instructions of the Panic Room.
  * @param panic A throwaway int parameter that is used to distinguish the correct printText() method for the instructions of the Panic Room.
  */ 
  public void printText(int panic)
  {
   JLabel line1 = new JLabel ("In the Panic Room, you will have to jump to press the spacebar to jump and avoid distractions"); 
   line1.setFont (defaultFont);
   line1.setForeground(Color.white);
   line1.setLocation(400, 300);
   this.add(line1);
   JLabel line2 = new JLabel ("while collecting boosts. Try to avoid all the distractions and get as many boosts as you can so that");
   line2.setFont (defaultFont);
   line2.setForeground(Color.white);
   line2.setLocation(400, 400);
   this.add(line2);
   JLabel line3 = new JLabel ("you can get to the finish line. Good luck!");
   line3.setFont (defaultFont);
   line3.setForeground(Color.white);
   line3.setLocation(400, 500);
   this.add(line3);
  }
  
 /**
  * This method will print the instructions of the Escape Room.
  * @param escape A throwaway String parameter that is used to distinguish the correct printText() method for the instructions of the Escape Room.
  */ 
  public void printText(String escape)
  {
   JLabel line1 = new JLabel ("In the Escape Room, you will have to apply your knowledge of distractions and how to avoid them by using"); 
   line1.setFont (defaultFont);
   line1.setForeground(Color.white);
   line1.setLocation(400, 300);
   this.add(line1);
   JLabel line2 = new JLabel ("the WASD keys to avoid incoming distractions while collecting files in order to finish your essay. Try to");
   line2.setFont (defaultFont);
   line2.setForeground(Color.white);
   line2.setLocation(400, 400);
   this.add(line2);
   JLabel line3 = new JLabel ("get the highest mark possible. Good luck!");
   line3.setFont (defaultFont);
   line3.setForeground(Color.white);
   line3.setLocation(400, 500);
   this.add(line3);
  }
}