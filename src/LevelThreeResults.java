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
public class LevelThreeResults extends TextOnly implements ActionListener {
    JButton tryAgain;
    JButton nextLevelOrLevelSelection;

    public LevelThreeResults(DistractionAction d) {
        game = d;
        initializeFontsAndLayout();
        setBackground(DistractionAction.GREY);
        printResults();
        setVisible(true);
        game.frame.revalidate();
    }

    /**
     * This method will create a JButton which will be used in the results screen of the game.
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * button                   JButton              The JButton that will be used in the results screen.
     * </pre>
     * </p>
     *
     * @param text The String to be displayed on the button.
     * @return The JButton that will be used in the results screen.
     */
    private JButton resultButtonCreator(String text) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.addActionListener(this);
        return button;
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
    private void printResults() {
        JLabel result;
        JLabel documentsHandedIn;
        int docs = PlayerStatus.DOCUMENTS;
        String grade = "";

        if (docs >= 10) {
            result = new JLabel("You finished your essay!!!");
        } else {
            result = new JLabel("You lose all your focus and hand in what you have.");
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
        layout.putConstraint(SpringLayout.NORTH, gradeLabel, 350, SpringLayout.NORTH, game.frame);

        add(gradeLabel);

        if (PlayerStatus.DOCUMENTS < 10)
            result.setFont(choiceFont);
        else
            result.setFont(buttonFont);

        result.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, result, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, result, 250, SpringLayout.NORTH, game.frame);

        tryAgain = resultButtonCreator("Try Again");

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tryAgain, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, tryAgain, 550, SpringLayout.NORTH, game.frame);

        if (game.fullGame == true)
            nextLevelOrLevelSelection = resultButtonCreator("Next Level");
        else
            nextLevelOrLevelSelection = resultButtonCreator("Level Selection");

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nextLevelOrLevelSelection, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, nextLevelOrLevelSelection, 625, SpringLayout.NORTH, game.frame);

        add(tryAgain);
        add(result);
        add(documentsHandedIn);

        if (PlayerStatus.DOCUMENTS == 10) {
            add(nextLevelOrLevelSelection);
        }

        revalidate();
    }

    @Override
    public void printText() {

    }


    /**
     * This method will perform different functions depending on the JButton that is pressed. When playing the game,
     * it will add and remove buttons from currentCard1 and currentCard2. It will also check for matching cards as well
     * as distractions. Finally, it will check for the win condition (matches == 5) and invoke the printResults() method.
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * x                        int                  An int that will be used to go through each element in backCards and faceCards. It is incremented by one each time the while loop executes.
     * stop                     boolean              A boolean that will act as one of the end conditions of the while loop.
     * </pre>
     * </p>
     *
     * @param e The ActionEvent that was triggered by a button press.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tryAgain) {
            game.levelThreeGame();
        } else if (game.fullGame == false && e.getSource() == nextLevelOrLevelSelection) {
            game.levelSelection();
        } else if (e.getSource() == nextLevelOrLevelSelection) {
            game.mainMenu();
        }

    }

}
