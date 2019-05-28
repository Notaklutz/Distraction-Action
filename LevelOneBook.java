import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
@author Ryan Phan
@version 1 - May 14, 2019
<p>
This class will thank the user for playing the game.
</p>
*/
public class LevelOneBook extends TextOnly implements ActionListener {
    JLabel background = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\Library.jpg")));
    JLabel book = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\Book.png")));
    SpringLayout layout = new SpringLayout();
    boolean nextPressed; // true = next false = last
    JButton next;
    JButton last;
    JLabel[] text = new JLabel[6]; // NOTE: ARRAY SIZE MUST BE EVEN
    int currentPage = 2;

    /**
     * This constructor will create a Goodbye object. It will initialize the custom fonts
     * and register them to the Graphics environment as well as initialize the layout of the panel.
     * It will also call the printTitle() method, the printText() method, and the printFooter() method.
     */
    public LevelOneBook() {
        initializeFontsAndLayout();
        setLayout(layout);
        printText();
        updatePages();
        displayBook();
        add(background);
        setVisible(true);
    }

    private void displayBook() {
        add(book);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, book, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, book, 50, SpringLayout.NORTH, this);

        last = buttonCreator("<");
        layout.putConstraint(SpringLayout.WEST, last, 275, SpringLayout.WEST, this);
        next = buttonCreator(">");
        layout.putConstraint(SpringLayout.WEST, next,675, SpringLayout.WEST, this);
        add(next);
        add(last);
    }

    private JButton buttonCreator(String text) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        layout.putConstraint(SpringLayout.NORTH, button, 700, SpringLayout.NORTH, DistractionActionDriver.frame);
        button.addActionListener(this);
        return button;
    }

    public void printText() {
        text[0] = new JLabel("Lorem Ipsum");
        text[1] = new JLabel("Dolor sit");
        text[2] = new JLabel("amet, consectetur");
        text[3] = new JLabel("Phasellus mollis ");
        text[4] = new JLabel("auctor sapien");
        text[5] = new JLabel("Onto the Quiz");
        for (int i = 0; i < text.length; i++){
            add (text[i]);
            text[i].setVisible(false);
            text[i].setFont(defaultFont);
            text[i].setForeground(Color.BLUE);
        }
    }

    private void updatePages() {
        if (nextPressed && currentPage > 2)
        {
            text[currentPage - 4].setVisible(false);
            text[currentPage - 3].setVisible(false);
        }
        else if (!nextPressed && currentPage < 6)
        {
            text[currentPage + 1].setVisible(false);
            text[currentPage].setVisible(false);
        }

        text[currentPage - 2].setVisible(true);
        text[currentPage - 1].setVisible(true);
        layout.putConstraint(SpringLayout.NORTH, text[currentPage - 2], 150, SpringLayout.NORTH, DistractionActionDriver.frame);
        layout.putConstraint(SpringLayout.WEST, text[currentPage - 2], 120, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, text[currentPage - 1], 100, SpringLayout.NORTH, DistractionActionDriver.frame);
        layout.putConstraint(SpringLayout.WEST, text[currentPage - 1], 520, SpringLayout.WEST, this);
    }

    /**
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next && currentPage < 6) {
            currentPage+= 2;
            System.out.println(currentPage);
            nextPressed = true;
            updatePages();
        }
        else if (e.getSource() == last && currentPage > 2) {
            currentPage-=2;
            System.out.println(currentPage);
            nextPressed = false;
            updatePages();
        }
    }
}