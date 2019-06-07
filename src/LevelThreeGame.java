import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * @author Ryan Phan
 * @version 1 - May 14, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This abstract class will be the parent class of any classes that are mostly text-based,
 * with a method to print the title and an abstract method to print text. It extends JPanel.
 * </p>
 */
public class LevelThreeGame extends JPanel implements Runnable {

    private boolean running = false;
    private Random r;
    private Thread thread;
    private Handler handler;
    private PlayerStatus status;
    private Spawner spawner;
    private DistractionAction game;

    public LevelThreeGame(DistractionAction d) {
        game = d;

        setDoubleBuffered(true);

        handler = new Handler();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyInput(handler));

        status = new PlayerStatus();
        spawner = new Spawner(handler, status);

        handler.add(new Player(400, 400, ID.Player, handler));

        r = new Random();
        for (int i = 0; i < 5; i++) {
            handler.add(new BasicDistraction(r.nextInt(1000), r.nextInt(800), ID.BasicDistraction, handler));
        }
        handler.add(new FocusBoost(r.nextInt(900), r.nextInt(700), ID.HealthBoost, handler));
        handler.add(new Document(r.nextInt(900), r.nextInt(700), ID.Document, handler));
    }

    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

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

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                 this.paintImmediately(0, 0, 1000, 800);
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        status.tick();
        spawner.tick();

        if (PlayerStatus.FOCUS <= 0 || PlayerStatus.DOCUMENTS >= 10) {
            JPanel resultsScreen = new LevelThreeResults(game);
            game.frame.setContentPane(resultsScreen);
            resultsScreen.updateUI();
            status.resetStats();
            stop();
        }

    }

    public void paintComponent(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
            g.setColor(new Color(107, 40, 40));
            g.fillRect(0, 0, getWidth(), getHeight());
            handler.paintComponent(g);
            status.paintComponent(g);
            g.dispose();
    }

    public static int clamp(int val, int min, int max) {
        if (val > max)
            val = max;
        else if (val < min)
            val = min;
        return val;
    }
}


