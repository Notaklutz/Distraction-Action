import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
public class LevelOneQuiz extends GameLevel {
  /**
   * Array used to contain the questions in the quiz
   */
  private QuizQuestion[] questions = {
    new QuizQuestion("What can reduce attention and memory, even when not in use?",
                     "A", "Phone", "Vacuum", "Kitchen Sink"),
    new QuizQuestion("What kind of music can hinder test performance?",
                     "A", "Music with lyrics", "Classical music", "Instrumental Jazz"),
    new QuizQuestion("Out of the following, where is the worst place to study?",
                     "A", "Loud party", "Quiet library", "Cozy living room"),
    new QuizQuestion("Study groups can be detrimental to your learning when they:",
                     "A", "Come unprepared", "Don't bring #2 pencils", 
                     "Do practice tests"),
    new QuizQuestion("What's a study habit that can cause you to become distracted?",
                     "A", "Studying a subject for too long", "Taking short breaks",
                     "Studying with a hot beverage")
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
  private JButton buttonA, buttonB, buttonC;
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
    setBackground(new Color(76, 121, 166));
    randomizeQuestionsAndChoice();
    addButtons();
    printText(questionNum);
    setVisible(true);
  }
  
  private void randomizeQuestionsAndChoice()
  {
    for (int x = 0; x < 3; x++)
    {
      int index = (int)(Math.random() * 3);
      
      QuizQuestion q = questions[index];
      questions[index] = questions[x];
      questions[x] = q;
    }
    
    for (int x = 0; x < questions.length; x++)
    {
      ArrayList<String> choices = new ArrayList<String>(3);
      choices.add(questions[x].getChoiceA());
      choices.add(questions[x].getChoiceB());
      choices.add(questions[x].getChoiceC());
      
      String ans = questions[x].getChoiceA();
      
      for (int y = 0; y < choices.size(); y++)
      {
        int index = (int)(Math.random() * choices.size());
        
        String temp = choices.get(index);
        choices.set(index, choices.get(y));
        choices.set(y, temp);
      }
      
      questions[x].setChoiceA(choices.get(0));
      questions[x].setChoiceB(choices.get(1));
      questions[x].setChoiceC(choices.get(2));
      
      if (ans.equals(choices.get(0)))
        ans = "A";
      else if (ans.equals(choices.get(1)))
        ans = "B";
      else
        ans = "C";
      
      questions[x].setAnswer(ans);
    }
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
    choices[0] = new JLabel("A." + questions[i].getChoiceA());
    choices[1] = new JLabel("B." + questions[i].getChoiceB());
    choices[2] = new JLabel("C." +  questions[i].getChoiceC());
    
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
  protected void printResults() {
    
    game.addScore(score * 6); // Adding to score
    
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
    
    scoreLabel.setFont(quizResultFont);
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
    
    gradeLabel.setFont(quizResultFont);
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
    {
     game.playerScore = originalScore; 
     game.quiz();
    }
    else if (game.fullGame == false)
      game.levelSelection();
    else
      game.instructions(1);
  }
  }

