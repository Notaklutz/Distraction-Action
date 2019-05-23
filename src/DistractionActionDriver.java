import java.awt.*;
import javax.swing.*;

/*
@author Ryan Phan
@version 1 - May 14, 2019
<p>
Driver class for Distraction Action
</p>
*/
public class DistractionActionDriver {
    public static JFrame frame;

    /**
     * Plays the GUI version of DistractionAction.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        //new SplashScreen();
        frame = new JFrame("Distraction Action");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        MainMenu m = new MainMenu();
        frame.setContentPane(m);
        frame.revalidate();
        frame.setVisible(true);
    }
}
