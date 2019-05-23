import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class provides a GUI for DistractionAction
 */
public class MainMenu extends TextOnly
implements ActionListener, KeyListener
{
	private int btnCount;
	JLabel gameTitle = new JLabel ("DISTRACTION ACTION");
	JLabel startGame = new JLabel ("> START GAME");
	JLabel selectGame = new JLabel ("SELECT LEVEL");
	JLabel tutorial = new JLabel ("TUTORIAL");
	JLabel highScores = new JLabel ("HIGH SCORES");
	JLabel exitButton = new JLabel ("EXIT");

    /**
     *
     *
     */
    public MainMenu()
    {
    	initializeFontsAndLayout();
    	ge.registerFont (bigTitle);
    	ge.registerFont (smallTitle);
    	ge.registerFont (defaultFont);
    	printTitle();
    	printText();
    	printFooter();
    	this.setBackground(GREY);
    	this.setVisible(true);

    }

    public void printText(){
    	JButton start = buttonCreator ("START GAME");
    	this.add(start);

		JButton selectLvl = buttonCreator ("SELECT LEVEL");
		this.add(selectLvl);

		JButton tutorial = buttonCreator ("TUTORIAL");
		this.add(tutorial);

		JButton highScores = buttonCreator ("HIGH SCORES");
		this.add(highScores);

		JButton exit = buttonCreator ("EXIT");
		this.add(exit);
    }

    private JButton buttonCreator (String text){
    	JButton button = new JButton(text);
    	btnCount++;
		button.setFont (buttonFont);
		button.setForeground(Color.white);
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, button, btnCount * 120, SpringLayout.NORTH, DistractionActionDriver.frame);
		return button;
	}

    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e)
    {
    }

    /**
     *
     * @param ke
     */
    public void keyTyped(KeyEvent ke) {}

    /**
     *
     * @param ke
     */
    public void keyPressed(KeyEvent ke)
    {

    }

    /**
     *
     * @param ke
     */
    public void keyReleased(KeyEvent ke) {}

}
