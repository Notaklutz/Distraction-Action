import javax.swing.*;
import java.awt.*;

/**
 * @author Ryan Phan
 * @version 1 14.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This class will display splash screen of the program. This includes the Kodiak Red logo
 * and the game logo.
 * </p>
 */

/**
 * Change Log
 * May 22, 2019 - Created SplashScreen
 */ 
public class SplashScreen extends JPanel {

    /**
     * JFrame used to contain the splash screen.
     */
    private JFrame frame = new JFrame();

    /**
     * The company logo to be displayed.
     */
    private JLabel logo = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\SplashScreen2.png")));

    /**
     * The game logo to be displayed.
     */
    private JLabel logo2 = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\SplashScreen.png")));

    /**
     * Height of the game frame.
     */
    private final int windowHeight = 500;

    /**
     * Width of the game frame.
     */
    private final int windowWidth = 680;

    /**
     * <p>
     * The constructor method creates a JFrame with
     * a GridBagLayout. It calls draw() to display
     * both of the splash screens before closing
     * the frame.
     * </p>
     */
    public SplashScreen() {
        super(new GridBagLayout());
        draw();
        close();
    }

    /**
     * <p>
     * Description of draw()
     * This method customizes the JFrame to ensure the splash screen looks
     * proper. It first calls logoSplash() to display the company logo then
     * loadingSplash(), which contains the game logo.
     * </p>
     */
    private void draw() {
        frame.setUndecorated(true);//Turning off Title bar
        frame.setSize(windowWidth, windowHeight);//Setting size
        frame.setLocationRelativeTo(null);//Setting location to the center of screen
        this.setBackground(new Color(40, 40, 40));
        logoSplash();
        frame.setVisible(true);
        loadingSplash();
        frame.revalidate();
    }

    /**
     * <p>
     * Description of logoSplash()
     * This method adds the company logo to the JPanel and sets the panel as
     * the current content pane of the JFrame.
     * </p>
     *
     */
    private void logoSplash() {
        this.add(logo);
        frame.getContentPane().add(this);
    }

    /**
     * <p>
     * Description of logoSplash()
     * This method delays the removal of the company logo for 2500 milliseconds before
     * adding the game logo to the content pane.
     * </p>
     *
     */
    private void loadingSplash() {
        sleep(2500);
        this.removeAll();
        frame.getContentPane().removeAll();
        this.add(logo2);
        frame.getContentPane().add(this);
    }

    /**
     * <p>
     * Description of close()
     * Delayed close of the frame.
     * </p>
     */
    private void close() {
        sleep(2500);
        frame.dispose();
    }

    /**
     * <p>
     * Description of sleep(long delay)
     * This method delays the current thread for delay milliseconds.
     * </p>
     *
     * @param delay Used to pass in the amount of milliseconds to delay.
     *
     */
    private void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}

