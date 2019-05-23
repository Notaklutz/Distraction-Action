import javax.swing.*;
import java.awt.*;

/*
@author Ryan Phan
@version 1 - May 14, 2019
<p>
This class will display both the Kodiak Red logo and the game logo when Distraction
Action is first opened.
</p>
*/
public class SplashScreen extends JPanel {

    /**
     * JFrame used to contain the splash screen.
     */
    JFrame frame = new JFrame();

    /**
     * The company logo to be displayed.
     */
    JLabel logo = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\SplashScreen2.png")));

    /**
     * The game logo to be displayed.
     */
    JLabel logo2 = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\SplashScreen.png")));

    /**
     * Height of the game frame.
     */
    private final int windowHeight = 500;

    /**
     * Width of the game frame.
     */
    private static final int windowWidth = 680;

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
     */
    public SplashScreen() {
        super(new GridBagLayout());
        draw();
        close();
    }

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
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

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
     */
    private void logoSplash() {
        this.add(logo);
        frame.getContentPane().add(this);
    }

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
     */
    private void loadingSplash() {
        sleep(2500);
        this.removeAll();
        frame.getContentPane().removeAll();
        this.add(logo2);
        frame.getContentPane().add(this);
    }

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
     */
    private void close() {
        sleep(2500);
        frame.dispose();
    }

    /*
     * This constructor will create a SplashScreen object. It will call the draw() method
     * and the the close() method.
     */
    private void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}

