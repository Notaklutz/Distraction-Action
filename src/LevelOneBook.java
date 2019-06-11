import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Ryan Phan
 * @version 1 14.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Displays Distractions 101, a book that teaches the user about various
 * distractions and some ways to avoid them.
 * </p>
 */
public class LevelOneBook extends Screen implements ActionListener {
    /**
     * The background image of the panel. Displays a library setting.
     */
    private JLabel background = new JLabel(new ImageIcon(DistractionAction.class.getClassLoader().getResource("Book/Library.jpg")));
    /**
     * The book to be displayed. Labeled Distractions 101, and is empty. Will be filled though the use
     * of JLabels.
     */
    private JLabel book = new JLabel(new ImageIcon(DistractionAction.class.getClassLoader().getResource("Book/Book.png")));
    /**
     * Button used to advance the page.
     */
    private JButton next;
    /**
     * Button used to go back a page.
     */
    private JButton last;
    /**
     * Stores the current page the user is viewing
     */
    private int currentPage = 2;
    /**
     * Stores the lines of text to be displayed in the book.
     */
    private JLabel[][] lines = new JLabel[6][9];

    /**
     * <p>
     * This constructor will create a LevelOneBook object. It will initialize the custom fonts
     * and initialize the layout of the panel. printText() is called to output text to the current
     * page of the book. updatePages() updates the JLabels being displayed to the book.
     * </p>
     *
     * @param d The game frame
     */
    public LevelOneBook(DistractionAction d) {
        game = d;
        initializeFontsAndLayout();
        setLayout(layout);
        printText();
        updatePages();
        displayBook();
        add(background);
        setVisible(true);
    }

    /**
     * <p>
     * This adds the book and the arrows used to turn the pages.
     * </p>
     */
    private void displayBook() {
        add(book);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, book, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, book, 50, SpringLayout.NORTH, this);

        last = buttonCreator("<");
        layout.putConstraint(SpringLayout.WEST, last, 275, SpringLayout.WEST, this);
        next = buttonCreator(">");
        layout.putConstraint(SpringLayout.WEST, next, 675, SpringLayout.WEST, this);
        add(next);
        add(last);
    }

    /**
     * <p>
     * Used to create the buttons used to turn the page.
     * </p>
     *
     * @param text The string to be displayed on the button.
     * @return The created button.
     */
    private JButton buttonCreator(String text) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        layout.putConstraint(SpringLayout.NORTH, button, 700, SpringLayout.NORTH, game.frame);
        button.addActionListener(this);
        return button;
    }

    /**
     * <p>
     * Initializes the JLabels containing each line of text inside the book.
     * </p>
     */
    public void printText() {
        lines[0][0] = new JLabel("In today's modern world,");
        lines[0][1] = new JLabel("phones are a big distraction");
        lines[0][2] = new JLabel("for students. Studies have");
        lines[0][3] = new JLabel("shown that phones can reduce");
        lines[0][4] = new JLabel("attention and memory when");
        lines[0][5] = new JLabel("studying or learning, even");
        lines[0][6] = new JLabel("when not actively used.");

        lines[1][0] = new JLabel("Feeling musical? Be careful");
        lines[1][1] = new JLabel("what you listen to while");
        lines[1][2] = new JLabel("studying! Music with lyrics");
        lines[1][3] = new JLabel("can actually be distracting.");
        lines[1][4] = new JLabel("Despite many students saying");
        lines[1][5] = new JLabel("that music helps them study,");
        lines[1][6] = new JLabel("research actually shows that");
        lines[1][7] = new JLabel("music with lyrics hinders");
        lines[1][8] = new JLabel("test performance.");

        lines[2][0] = new JLabel("Studying in a loud");
        lines[2][1] = new JLabel("environment is one of the");
        lines[2][2] = new JLabel("worst things you can do");
        lines[2][3] = new JLabel("while studying. Research");
        lines[2][4] = new JLabel("shows that exposure to loud");
        lines[2][5] = new JLabel("noises can have a negative");
        lines[2][6] = new JLabel("effect on information");
        lines[2][7] = new JLabel("retention and testing");
        lines[2][8] = new JLabel("outcomes.");

        lines[3][0] = new JLabel("Do you study with friends or");
        lines[3][1] = new JLabel("classmates? While study");
        lines[3][2] = new JLabel("groups can be helpful, they");
        lines[3][3] = new JLabel("can also be distracting.");
        lines[3][4] = new JLabel("When study groups are");
        lines[3][5] = new JLabel("unprepared and meet without");
        lines[3][6] = new JLabel("a clear goal, the study");
        lines[3][7] = new JLabel("session can actually be more");
        lines[3][8] = new JLabel("hurtful than helpful.");

        lines[4][0] = new JLabel("Are you someone who studies");
        lines[4][1] = new JLabel("one subject continuously");
        lines[4][2] = new JLabel("without taking breaks? While");
        lines[4][3] = new JLabel("this might seem like a good");
        lines[4][4] = new JLabel("a habit, it's actually been");
        lines[4][5] = new JLabel("shown that students who");
        lines[4][6] = new JLabel("don't take breaks and keep");
        lines[4][7] = new JLabel("studying the same subject");
        lines[4][8] = new JLabel("get distracted more often.");

        lines[5][0] = new JLabel("Now it's time for a quiz!");
        lines[5][1] = new JLabel("Go to the next page to test");
        lines[5][2] = new JLabel("your knowledge, or go back");
        lines[5][3] = new JLabel("and review some more.");

        for (int x = 0; x < lines.length; x++) {
            for (JLabel j : lines[x]) {
                try {
                    add(j);
                    j.setVisible(false); // Ensures they don't all show up at once
                    j.setFont(bookFont);
                    j.setForeground(BROWN);
                } catch (NullPointerException e) {
                }
            }
        }

        InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Next Page");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Previous Page");
        ActionMap action = this.getActionMap();
        action.put("Next Page", new AbstractAction()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (currentPage < 6)
                        {
                            currentPage += 2;
                            updatePages();
                        }
                        else
                        {
                            game.quiz();
                        }
                    }
                }
        );
        action.put("Previous Page", new AbstractAction()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (currentPage > 2)
                        {
                            currentPage -= 2;
                            updatePages();
                        }
                    }
                }
        );
    }

    /**
     * <p>
     * Updates the book pages every time the button is pressed.
     * </p>
     */
    private void updatePages() {
        for (int x = 0; x < lines.length; x++) {
            for (JLabel j : lines[x]) {
                try {
                    j.setVisible(false);
                } catch (NullPointerException e) {
                }
            }
        }

        if (currentPage - 2 == 0) {
            for (int x = 0; x < lines[0].length; x++) {
                try {
                    lines[0][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[0][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[0][x], 120, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }
                try {
                    lines[1][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[1][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[1][x], 520, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }
            }
        } else if (currentPage - 2 == 2) {
            for (int x = 0; x < lines[0].length; x++) {
                try {
                    lines[2][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[2][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[2][x], 120, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }

                try {
                    lines[3][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[3][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[3][x], 520, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }
            }
        } else if (currentPage - 2 == 4) {
            for (int x = 0; x < lines[0].length; x++) {
                try {
                    lines[4][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[4][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[4][x], 120, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }
                try {
                    lines[5][x].setVisible(true);
                    layout.putConstraint(SpringLayout.NORTH, lines[5][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
                    layout.putConstraint(SpringLayout.WEST, lines[5][x], 520, SpringLayout.WEST, this);
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /**
     * <p>
     * Used to perform actions when a button is pressed.
     * </p>
     *
     * @param e The ActionEvent to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next && currentPage < 6) {
            currentPage += 2;
            updatePages();
        } else if (e.getSource() == last && currentPage > 2) {
            currentPage -= 2;
            updatePages();
        } else if (currentPage == 6) {
            game.quiz();
        }
    }
}