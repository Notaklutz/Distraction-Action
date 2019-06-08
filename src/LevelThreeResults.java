import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * Displays the results to level three
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 5, 2019 - Created LevelThreeResults
 */ 
class LevelThreeResults extends GameLevel {
  
    public LevelThreeResults(DistractionAction d) {
        game = d;
        initializeFontsAndLayout();
        setBackground(DistractionAction.GREY);
        printResults();
        setVisible(true);
        game.frame.revalidate();
    }

    /**
     * This method will display the results after the game is finished. It sets all of the elements of the game to invisible,
     * and depending on whether or not the user got less than 3 strikes, displays whether the player won or lost. If the player
     * wins, they are given the option to try again, go to the next level (full game), or return to the level selection (not full game).
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * result                   JLabel               The JLabel that will display whether or not the user won.
     * </pre>
     * </p>
     */
    protected void printResults() {
        JLabel result;
        JLabel documentsHandedIn;
        int docs = PlayerStatus.DOCUMENTS;
        String grade = "";
        
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
     *
     * @param e The ActionEvent that was triggered by a button press.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tryAgain) {
            game.playerScore = originalScore;
            game.levelThreeGame();
        } else if (game.fullGame == false && e.getSource() == nextLevelOrLevelSelection) {
            game.levelSelection();
        } else if (e.getSource() == nextLevelOrLevelSelection) {
            game.endScreen();
        }

    }

}
