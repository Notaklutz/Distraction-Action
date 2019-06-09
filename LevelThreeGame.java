import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This class serves as the main class for Level Three. Created by watching RealTutsGML's
 * "Let's Build a Game in Java" tutorial on Youtube, which was very helpful in the
 * creation of this portion of our game.
 * </p>
 */

/**
 * Change Log
 * June 1, 2019 - Created LevelThreeGame
 * June 2, 2019 - Added clamp() method to keep the GameObjects from leaving the frame and to keep
 *                the health bar (focus bar) confined into one rectangle.
 * June 4, 2019 - Added a Spawner object to LevelThreeGame to control spawn rate of distractions,
 *                boosts, and documents.
 * June 6, 2019 - Revamped LevelThreeGame to work with the rest of the game. Initially, LevelThreeGame
 *                extended Canvas (as used in the tutorial), causing several issues when adding it to
 *                our game, as our game uses JPanels to display different screens. The render() method
 *                was rendered useless as it cannot render to a JPanel.
 *                Thus, render() has been replaced by paintComponent() and
 *                LevelThreeGame now extends GameLevel.
 */
public class LevelThreeGame extends GameLevel implements Runnable {
    /**
     * Stores if the game is currently running or not.
     */
    private boolean running = false;
    /**
     * Stores the game thread
     */
    private Thread thread;
    /**
     * Handles the objects present on screen
     */
    private Handler handler;
    /**
     * Stores the current status of the Player and various information displayed to the
     * user.
     */
    private PlayerStatus status;
    /**
     * Controls the spawning of objects in the level
     */
    private Spawner spawner;

    /**
     * This constructor will create a LevelThreeGame object. It will initialize some the essential components
     * of the game and display the initial state of the game.
     *
     * @param d The DistractionAction object that contains the frame that game will be displayed on.
     */
    public LevelThreeGame(DistractionAction d) {
        // Variable initialization
        game = d;
        handler = new Handler();
        Player player = new Player(DistractionAction.WIDTH / 2, DistractionAction.HEIGHT / 2, ID.Player, handler);
        status = new PlayerStatus();
        spawner = new Spawner(handler, status, player);

        // Sets player movement
        new PlayerMovement(player, this);
        handler.add(player);

        // Sets initial state of the game
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            handler.add(new BasicDistraction(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.BasicDistraction));
        }
        handler.add(new FocusBoost(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.FocusBoost));

        handler.add(new Document(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.Document));
    }

    /**
     * Starts the thread
     */
    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Ends the thread
     */
    public synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs level three
     */
    public void run() {
        /*
         * Automatically places the frame in "focus" so the user doesn't have to
         * click on the frame
         */
        this.requestFocus();

        /*
         * Variables that store time in the loop
         */
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        /*
         * Game loop
         * (Taken from RealTutsGML's "Java Programming: Let's Build a Game #1")
         */
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                this.paintImmediately(0, 0, 1000, 800); // Redraw the visuals in the game

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }
        }
        stop(); // Ends the thread
    }

    /**
     * Updates the game
     */
    private void tick() {
        handler.tick();
        status.tick();
        spawner.tick();
        printResults();
    }

    /**
     * Draws the background and the UI elements (Health/Focus bar, documents collected, etc.)
     * @param graphics Used to draw to the screen
     */
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(new Color(107, 40, 40));
        g.fillRect(0, 0, getWidth(), getHeight());
        handler.paintComponent(g);
        status.paintComponent(g);
        g.dispose();
    }

    /**
     * Used to ensure objects stay within their given area
     * (health stays in health bar, player stays in frame, etc.)
     * @param val The value to keep kept between a range
     * @param min Min value of range
     * @param max Max value of range
     * @return The clamped value
     */
    public static int clamp(int val, int min, int max) {
        if (val > max)
            val = max;
        else if (val < min)
            val = min;
        return val;
    }

    /**
     * Checks when the thread should stop and displays the results page
     */
    @Override
    protected void printResults() {
        if (PlayerStatus.FOCUS <= 0 || PlayerStatus.DOCUMENTS >= 10) {
            JPanel resultsScreen = new LevelThreeResults(game);
            game.frame.setContentPane(resultsScreen);
            resultsScreen.updateUI();
            status.resetStats();
            stop();
        }
    }

    /**
     * Overridden as GameLevel implements ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


