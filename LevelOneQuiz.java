import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LevelOneQuiz extends TextOnly implements ActionListener {
    //  QuizQuestion(String question, String answer, String choiceA, String choiceB, String choiceC)
    QuizQuestion[] questions = {
            new QuizQuestion("Question 1", "A", "X", "O", "O"),
            new QuizQuestion("Question 2", "B", "O", "X", "O"),
            new QuizQuestion("Question 3", "C", "O", "O", "X")
    };

    int questionNum;
    int score;
    int btnCount = -1;
    JButton buttonA, buttonB, buttonC;
    JLabel question;
    JLabel[] choices = new JLabel[questions.length];

    public LevelOneQuiz() {
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
            for (int j = 0; j < choices.length; j++) {
                remove(choices[j]);
            }
            revalidate();
        }

        /****************************Questions****************************/
        question = new JLabel(questions[i].getQuestion());
        question.setFont(defaultFont);
        question.setForeground(Color.WHITE);
        layout.putConstraint(SpringLayout.WEST, question, 50, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, question, 25, SpringLayout.NORTH, DistractionActionDriver.frame);


        /****************************Choices****************************/
        choices[0] = new JLabel(questions[i].getChoiceA());
        choices[1] = new JLabel(questions[i].getChoiceB());
        choices[2] = new JLabel(questions[i].getChoiceC());

        for (int j = 0; j < 3; j++) {
            choices[j].setFont(defaultFont);
            choices[j].setForeground(Color.WHITE);

            layout.putConstraint(SpringLayout.WEST, choices[j], 50, SpringLayout.WEST, this);
            layout.putConstraint(SpringLayout.NORTH, choices[j], j * 150 + 125, SpringLayout.NORTH, DistractionActionDriver.frame);
        }

        add(question);
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
        button.setBackground(GREY);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(300, 200));
        layout.putConstraint(SpringLayout.WEST, button, btnCount * 333 + 14, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, button, 550, SpringLayout.NORTH, DistractionActionDriver.frame);
        button.addActionListener(this);
        return button;
    }

    public void checkAnswer(String userAnswer) {
        if (userAnswer.equals(questions[questionNum].getAnswer())) {
            System.out.println("Yay you are smart kinda");
            score++;
        } else {
            System.out.println("no it was " + questions[questionNum].getAnswer() +
                    " not " + userAnswer + " you twit");
        }
    }


    /**
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String userAnswer = "";
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
        }
        printText(questionNum);
    }
}

