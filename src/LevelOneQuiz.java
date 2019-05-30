import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelOneQuiz extends TextOnly implements ActionListener {
  QuizQuestion[] questions = {
    new QuizQuestion("When studying, after how long should you take a short break?", 
                     "B", "30 minutes", "One hour", "You should never take a break"),
    new QuizQuestion("What should you do if your family is bothering you while you're working?", 
                     "A", "Ask them for some privacy", 
                     "Stop working and talk to them", "Yell at them to leave you alone"),
    new QuizQuestion("What should you do to your phone when studying or working?", 
                     "A", "Turn it off and put it away", 
                     "Keep it beside you but ignore it", 
                     "Chat about the latest tea"),
    new QuizQuestion("What kind of music should you listen to while studying?", 
                     "C", "Pop", "Rock and Roll", "Classical Music"),
    new QuizQuestion("What should you do if you're trying to study in a loud environment?", 
                     "B", "Blast loud music on speakers", "Move to another room", 
                     "Yell at whoever is being loud")
  };
  
  int questionNum;
  int score;
  int btnCount = -1;
  JButton buttonA, buttonB, buttonC, tryAgain, nextLevelOrLevelSelection;
  JLabel question;
  JLabel question2;
  JLabel question3;
  JLabel[] choices = new JLabel[3];
  static boolean buttonPressed = false;
  
  public LevelOneQuiz(DistractionAction d) 
  {
    game = d;
    initializeFontsAndLayout();
    setLayout(layout);
    setBackground(new Color(142, 40, 40));
    addButtons();
    printText(questionNum);
    setVisible(true);
  }
  
  public void startTest(QuizQuestion[] questions) {
    for (int i = 0; i < questions.length; i++) {
      
    }
  }
  
  public void printText() {
  }
  
  public void printText(int i) {
    if (i > 0) {
      question.setVisible(false);
      question2.setVisible(false);
      question3.setVisible(false);
      for (int j = 0; j < choices.length; j++) {
        remove(choices[j]);
      }
      revalidate();
      repaint();
    }
    
    /****************************Questions****************************/
    int indexOfFirstSpace = questions[i].getQuestion().substring(questions[i].getQuestion().length() / 3).indexOf(" ");
    int indexOfSecondSpace = questions[i].getQuestion().substring(questions[i].getQuestion().length() / 3 * 2).indexOf(" ");
    
    question = new JLabel((questionNum + 1) + "/5 " + questions[i].getQuestion().substring(0, questions[i].getQuestion().length() / 3 + indexOfFirstSpace));
    question2 = new JLabel(questions[i].getQuestion().substring(questions[i].getQuestion().length() / 3 + indexOfFirstSpace, questions[i].getQuestion().length() / 3 * 2 + indexOfSecondSpace));
    question3 = new JLabel(questions[i].getQuestion().substring(questions[i].getQuestion().length() / 3 * 2 + indexOfSecondSpace));
    
    question.setFont(quizFont);
    question.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.WEST, question, 50, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, question, 25, SpringLayout.NORTH, game.frame);
    
    question2.setFont(quizFont);
    question2.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.WEST, question2, 120, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, question2, 70, SpringLayout.NORTH, game.frame);
    
    question3.setFont(quizFont);
    question3.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.WEST, question3, 120, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, question3, 115, SpringLayout.NORTH, game.frame);
    
    
    /****************************Choices****************************/
    choices[0] = new JLabel(questions[i].getChoiceA());
    choices[1] = new JLabel(questions[i].getChoiceB());
    choices[2] = new JLabel(questions[i].getChoiceC());
    
    for (int j = 0; j < 3; j++) {
      choices[j].setFont(quizFont);
      choices[j].setForeground(Color.WHITE);
      
      layout.putConstraint(SpringLayout.WEST, choices[j], 50, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.NORTH, choices[j], j * 150 + 175, SpringLayout.NORTH, game.frame);
    }
    
    add(question);
    add(question2);
    add(question3);
    for (JLabel choice : choices) {
      add(choice);
    }
  }
  
  public void addButtons() {
    buttonA = buttonCreator("A");
    buttonB = buttonCreator("B");
    buttonC = buttonCreator("C");
    add(buttonA);
    add(buttonB);
    add(buttonC);
  }
  
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
  
  public void printResults()
  {
    String grade;
    
    question.setVisible(false);
    question2.setVisible(false);
    question3.setVisible(false);
    for (int j = 0; j < choices.length; j++) {
      remove(choices[j]);
    }
    remove(buttonA);
    remove(buttonB);
    remove(buttonC);
    
    revalidate();
    repaint();
    
    JLabel scoreLabel = new JLabel ("Score: " + score + "/5");
    
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
    
    JLabel gradeLabel = new JLabel ("Grade: " + grade);
    
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
  
  private JButton resultButtonCreator(String text)
  {
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
  
  public void checkAnswer(String userAnswer) {
    if (userAnswer.equals(questions[questionNum].getAnswer()))
      score++;
  }
  
  
  /**
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    String userAnswer = "";
    if (e.getSource() != tryAgain && e.getSource()!= nextLevelOrLevelSelection)
    {
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
      }
      else
        printResults();
    }
    else if (e.getSource() == tryAgain)
      game.quiz();
    else if (game.fullGame == false)
      game.levelSelection();
    else
      game.instructions(1); // CHANGE THIS WHEN LVL 2 IS DONE
  }
}

