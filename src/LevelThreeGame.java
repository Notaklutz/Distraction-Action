import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class LevelThreeGame extends Canvas implements Runnable{

    private boolean running = false;
    private Random r;
    private Thread thread;
    private Handler handler;
    private PlayerStatus status;

    public LevelThreeGame()
    {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        handler.add(new Player(400, 400, ID.Player));

        status = new PlayerStatus();
        r = new Random();

        for (int i = 0; i < 20; i++) {
            handler.add(new BasicDistraction(r.nextInt(1000), r.nextInt(800), ID.BasicDistraction));
        }
    }

    public synchronized void start(){
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        handler.tick();
        status.tick();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        do {
            do {
                Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                // You MUST clear the page before painting, bad things
                // happen otherwise
                g.setColor(new Color (64, 64 ,64));
                g.fillRect(0, 0, getWidth(), getHeight());
                handler.render(g);
                status.render(g);
                g.dispose();
            } while (bs.contentsRestored());
            bs.show();
        } while (bs.contentsLost());
    }

    public static int clamp(int val, int min, int max){
        if(val > max)
            val = max;
        else if(val < min)
            val = min;
        return val;
    }
}


