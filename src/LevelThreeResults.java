import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This class displays the results from level three.
 * </p>
 */

/**
 * Change Log
 * June 5, 2019 - Created LevelThreeResults
 */ 
public class LevelThreeResults extends GameLevel {
    /**
     * This constructor will create a LevelThreeResults object. It will initialize the fonts and layout of the game,
     * sets the background colour, and makes the panel visible.
     *
     * @param d The DistractionAction object that contains the frame that game will be displayed on.
     */
    public LevelThreeResults(DistractionAction d) {
        game = d;
        initializeFontsAndLayout();
        setBackground(DistractionAction.GREY);
        printResults();
        setVisible(true);
        game.frame.revalidate();
    }

    /**
     * This method will display the results after the game is finished. If the player
     * wins, they are given the option to try again, go to the next level (full game),
     * or return to the level selection (not full game).
     *
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * result                   JLabel               The JLabel that will display whether or not the user won.
     * documentsHandedIn        JLabel               The JLabel that will display how many docs were collected.
     * docs                     int                  Stores the total number of documents that can be collected.
     * grade                    String               Stores the users grade level, based on how many docs were collected.
     * gradeLevel               JLabel               The JLabel the users grade level, based on how many docs were collected.
     * </pre>
     * </p>
     */
    protected void printResults() {
        JLabel result, documentsHandedIn;
        int docs = PlayerStatus.DOCUMENTS;
        String grade;
        
        originalScore = game.playerScore;
        
        game.addScore(docs * 4);
        
        if (docs >= 10) {
            result = new JLabel("You finished your essay!");
        } else {
            result = new JLabel("You lost your focus!");
        }
        documentsHandedIn = new JLabel("You collected " + docs + "/10 documents.");

        if (docs == 10)
            grade = "A+";
        else if (docs == 9)
            grade = "A";
        else if (docs == 8)
            grade = "B+";
        else if (docs == 7)
            grade = "B";
        else if (docs == 6)
            grade = "C";
        else if (docs == 5)
            grade = "D";
        else
            grade = "F";

        JLabel gradeLabel = new JLabel("Grade: " + grade);

        gradeLabel.setFont(smallTitle);
        gradeLabel.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, gradeLabel, 325, SpringLayout.NORTH, game.frame);

        add(gradeLabel);
        
        documentsHandedIn.setFont(documentsCollectedFont);
        documentsHandedIn.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, documentsHandedIn, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, documentsHandedIn, 50, SpringLayout.VERTICAL_CENTER, this);

        if (docs < 10)
            result.setFont(dodgingResultFont);
        else
            result.setFont(dodgingResultFont);

        result.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, result, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, result, 250, SpringLayout.NORTH, game.frame);

        tryAgain = resultButtonCreator("Try Again");

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tryAgain, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, tryAgain, 550, SpringLayout.NORTH, game.frame);

        if (game.fullGame == true)
            nextLevelOrLevelSelection = resultButtonCreator("Continue");
        else
            nextLevelOrLevelSelection = resultButtonCreator("Level Selection");

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nextLevelOrLevelSelection, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, nextLevelOrLevelSelection, 625, SpringLayout.NORTH, game.frame);

        add(tryAgain);
        add(result);
        add(documentsHandedIn);
        add(nextLevelOrLevelSelection);

        revalidate();
    }

    /**
     * This method will perform different functions depending on the JButton that is pressed.
     *
     * @param e The ActionEvent that was triggered by a button press.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tryAgain) {
            game.playerScore = originalScore;
            game.levelThreeGame();
        } else if (!game.fullGame && e.getSource() == nextLevelOrLevelSelection) {
            game.levelSelection();
        } else if (e.getSource() == nextLevelOrLevelSelection) {
            game.endScreen();
        }

    }

}
