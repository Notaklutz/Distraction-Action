import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Ryan Phan
 * @version 1 - May 31, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This class will be the parent class of any classes that create the levels.
 * Here, there will be general methods that may apply to all three levels (such as
 * buttons).
 * </p>
 */
public class GameLevel extends TextOnly implements ActionListener
{
    /**
     * This JButton will allow the user to play the matching game again.
     */
    protected int level;
    /**
     * This JButton will allow the user to play the matching game again.
     */
    protected JButton tryAgain;
    /**
     * This JButton will allow the user to go to the next level or go back to level selection,
     * depending on whether or not the user is playing a full game.
     */
    protected JButton nextLevelOrLevelSelection;

    public GameLevel(int level){
        this.level = level;
    }

    public void createResultButtons(){
        tryAgain = resultButtonCreator("Try Again");
        tryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (level == 1)
                    game.quiz();
                else if (level == 2)
                    game.matchingGame();
            }
        });

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tryAgain, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, tryAgain, 550, SpringLayout.NORTH, game.frame);

        if (game.fullGame) {
            nextLevelOrLevelSelection = resultButtonCreator("Next Level");
            nextLevelOrLevelSelection.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (level == 1)
                        game.matchingGame();
                }
            });
        }
        else {
            nextLevelOrLevelSelection = resultButtonCreator("Level Selection");
            nextLevelOrLevelSelection.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.levelSelection();
                }
            });

        }

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nextLevelOrLevelSelection, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, nextLevelOrLevelSelection, 625, SpringLayout.NORTH, game.frame);

        add(tryAgain);
        add(nextLevelOrLevelSelection);
    }

    /**
     * <p>
     * Used to create the buttons in the results page.
     * </p>
     *
     * @param text The string to be displayed on the button.
     * @return The created button.
     *
     */
    public JButton resultButtonCreator(String text) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void printText()
    {
    }
}
