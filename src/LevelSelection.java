import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This class will allow the user to select any one of the rooms to play.
</p>
*/
public class LevelSelection extends TextOnly
{
 /**
  * This constructor will create a LevelSelection object. It will initialize
  * the custom fonts and register them to the Graphics environment as well as initialize
  * the layout of the panel. It will also call the printTitle(), printText(), and printFooter() methods.
  */ 
  public LevelSelection()
  {
    initializeFontsAndLayout();
    ge.registerFont (bigTitle);
    ge.registerFont (smallTitle);
    ge.registerFont (defaultFont);
    printTitle();
    printText();
    printFooter();
  }
  
 /**
  * This method will print the options that the user will have to choose from
  * in the LevelSelection screen.
  */ 
  public void printText()
  {
   JLabel deficiencies = new JLabel ("LEVEL 1: DEFICIENCIES"); 
   deficiencies.setFont (defaultFont);
   deficiencies.setForeground(Color.white);
   deficiencies.setLocation(400, 300);
   this.add(deficiencies);
   JLabel panic = new JLabel ("LEVEL 2: PANIC");
   panic.setFont(defaultFont);
   panic.setForeground(Color.white);
   panic.setLocation(400, 400);
   this.add(panic);
   JLabel escape = new JLabel ("LEVEL 3: ESCAPE");
   escape.setFont (defaultFont);
   escape.setForeground(Color.white);
   escape.setLocation(400, 500);
   this.add(escape);
   JLabel mainMenu = new JLabel ("MAIN MENU");
   mainMenu.setFont (defaultFont);
   mainMenu.setForeground(Color.white);
   mainMenu.setLocation(400, 600);
   this.add(mainMenu);
  }
}