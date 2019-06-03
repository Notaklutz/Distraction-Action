import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ryan Phan
 * @version 1 14.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 *  Displays the quiz for the first level of the game.
 * </p>
 */
public class LevelOneQuiz extends TextOnly implements ActionListener {
    /**
     * Array used to contain the questions in the quiz
     */
    private QuizQuestion[] questions = {
            new QuizQuestion("When studying, after how long should you take a short break?",
                    "B", "30 minutes", "One hour", "You should never take a break"),
            new QuizQuestion("If you're being bothered while working, what should you do?",
                    "A", "Ask them for some privacy",
                    "Stop working and talk to them", "Yell at them to leave you alone"),
            new QuizQuestion("What should you do to your phone when studying or working?",
                    "A", "Turn it off and put it away",
                    "Keep it beside you but ignore it",
                    "Chat about the latest tea"),
            new QuizQuestion("What kind of music should you listen to while studying?",
                    "C", "Pop", "Rock and Roll", "Classical Music"),
            new QuizQuestion("In a loud environment, what should you do to focus?",
                    "B", "Blast loud music on speakers", "Move to another room",
                    "Yell at whoever is being loud")
    };
    /**
     * Stores the current question number.
     */
    private int questionNum;
    /**
     * Stores the players score.
     */
    private int score;
    /**
     * Stores the amount of buttons on the screen
     */
    private int btnCount = -1;
    /**
     * The various buttons present on the screen
     */
    private JButton buttonA, buttonB, buttonC, tryAgain, nextLevelOrLevelSelection;
    /**
     * Stores the two lines the question will lie on
     */
    private JLabel question, question2;
    /**
     * Stores the choices the user is allowed to choose
     */
    private JLabel[] choices = new JLabel[3];

    /**
     * <p>
     * The constructor method initializes the fonts and layout of the game,
     * setting the layout of the panel to SpringLayout. The background is set
     * here, along with the buttons that allow the user to make a choice.
     * The printText() method prints the question corresponding to the questionNum.
     * Finally the constructor sets the visibility of the JPanel to true.
     * </p>
     */
    public LevelOneQuiz(DistractionAction d) {
        game = d;
        initializeFontsAndLayout();
        setLayout(layout);
        setBackground(new Color(142, 40, 40));
        addButtons();
        printText(questionNum);
        setVisible(true);
    }

    /**
     * <p>
     * TextOnly requires this method to be implemented, however since the program
     * has no use for this method it remains empty.
     * </p>
     */
    public void printText() {
    }

    /**
     * <p>
     * Adds all of the text to the screen.
     * </p>
     *
     * @param i The current question to be outputted along with its options.
     *
     */
    private void printText(int i) {
        if (i > 0) {
            question.setVisible(false);
            question2.setVisible(false);

            for (int j = 0; j < choices.length; j++) {
                remove(choices[j]);
            }
            revalidate();
            repaint();
        }

        /****************************Questions****************************/
        int indexOfFirstSpace = questions[i].getQuestion().substring(0, 34).lastIndexOf(" ");

        question = new JLabel((questionNum + 1) + "/5 " + questions[i].getQuestion().substring(0, indexOfFirstSpace));
        question2 = new JLabel(questions[i].getQuestion().substring(indexOfFirstSpace));

        question.setFont(quizFont);
        question.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.WEST, question, 50, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, question, 25, SpringLayout.NORTH, game.frame);

        question2.setFont(quizFont);
        question2.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.WEST, question2, 120, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, question2, 70, SpringLayout.NORTH, game.frame);


        /****************************Choices****************************/
        choices[0] = new JLabel(questions[i].getChoiceA());
        choices[1] = new JLabel(questions[i].getChoiceB());
        choices[2] = new JLabel(questions[i].getChoiceC());

        for (int j = 0; j < 3; j++) {
            choices[j].setFont(choiceFont);
            choices[j].setForeground(Color.WHITE);

            layout.putConstraint(SpringLayout.WEST, choices[j], 50, SpringLayout.WEST, this);
            layout.putConstraint(SpringLayout.NORTH, choices[j], j * 150 + 175, SpringLayout.NORTH, game.frame);
        }

        /************************Adding the text**********************/
        add(question);
        add(question2);

        for (JLabel choice : choices) {
            add(choice);
        }
    }

    /**
     * <p>
     * Adds the buttons to the quiz panel.
     * </p>
     */
    private void addButtons() {
        buttonA = buttonCreator("A");
        buttonB = buttonCreator("B");
        buttonC = buttonCreator("C");
        add(buttonA);
        add(buttonB);
        add(buttonC);
    }

    /**
     * <p>
     * Used to create the buttons present in the quiz.
     * </p>
     *
     * @param text The string to be displayed on the button.
     * @return The created button.
     *
     */
    private JButton buttonCreator(String text) {
        LineBorder border = new LineBorder(Color.WHITE, 12);
        JButton button = new JButton(text);
        btnCount++;
        button.setBorder(border);
        button.setFont(buttonFont);
        button.setBackground(game.GREY);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(300, 200));
        layout.putConstraint(SpringLayout.WEST, button, btnCount * 333 + 14, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, button, 550, SpringLayout.NORTH, game.frame);
        button.addActionListener(this);
        return button;
    }

    /**
     * <p>
     * Prints the results of the quiz.
     * </p>
     */
    private void printResults() {
        String grade;

        question.setVisible(false);
        question2.setVisible(false);
        for (int j = 0; j < choices.length; j++) {
            remove(choices[j]);
        }
        remove(buttonA);
        remove(buttonB);
        remove(buttonC);

        revalidate();
        repaint();

        JLabel scoreLabel = new JLabel("Score: " + score + "/5");

        scoreLabel.setFont(smallTitle);
        scoreLabel.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scoreLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, scoreLabel, 250, SpringLayout.NORTH, game.frame);

        if (score == 5)
            grade = "A+";
        else if (score == 4)
            grade = "A";
        else if (score == 3)
            grade = "B";
        else if (score == 2)
            grade = "C";
        else if (score == 1)
            grade = "D";
        else
            grade = "F";

        JLabel gradeLabel = new JLabel("Grade: " + grade);

        gradeLabel.setFont(smallTitle);
        gradeLabel.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, gradeLabel, 350, SpringLayout.NORTH, game.frame);

        add(scoreLabel);
        add(gradeLabel);

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
     * <p>
     * Checks if the user answer is correct. If so, add one to the
     * score.
     * </p>
     *
     * @param userAnswer The answer to be checked
     *
     */
    private void checkAnswer(String userAnswer) {
        if (userAnswer.equals(questions[questionNum].getAnswer()))
            score++;
    }

    /**
     * <p>
     * Used to perform actions when a button is pressed.
     * </p>
     *
     * @param e The ActionEvent to be processed
     *
     */
    public void actionPerformed(ActionEvent e) {
        String userAnswer = "";
        if (e.getSource() != tryAgain && e.getSource() != nextLevelOrLevelSelection) {
            if (e.getSource() == buttonA) {
                userAnswer = "A";
            } else if (e.getSource() == buttonB) {
                userAnswer = "B";
            } else if (e.getSource() == buttonC) {
                userAnswer = "C";
            }
            checkAnswer(userAnswer);
            if (questionNum < questions.length - 1) {
                questionNum++;
                printText(questionNum);
            } else
                printResults();
        } else if (e.getSource() == tryAgain)
            game.quiz();
        else if (game.fullGame == false)
            game.levelSelection();
        else
            game.instructions(1); // CHANGE THIS WHEN LVL 2 IS DONE
    }
}

