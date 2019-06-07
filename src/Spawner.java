import java.util.Random;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 4, 2019 - Created Spawner
 */ 
public class Spawner {

    private Handler handler;
    private PlayerStatus status;
    private int timer;
    private int distractionCount = 0;
    private Random r = new Random();
    private boolean boostOnScreen = false;


    public Spawner(Handler handler, PlayerStatus status) {
        this.handler = handler;
        this.status = status;
    }

    public int numOfDistractions(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);

            if (tempObj.getId() == ID.BasicDistraction) {
                distractionCount++;
            }
        }
        return distractionCount;
    }

   public boolean boostOnScreen(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            boostOnScreen = tempObj.getId() == ID.HealthBoost;
            if (boostOnScreen)
              return boostOnScreen;
        }

        return boostOnScreen;
    }
        
    public void tick() {
        timer++;

        if (timer >= PlayerStatus.TIMETILLSPAWN) {
            timer = 0;
            status.setSeconds(status.getSeconds() + 1);
            if (status.getSeconds() % 2 == 0 && numOfDistractions() <= 30) {
                for (int j = 0; j < 5; j++) {
                    handler.add(new BasicDistraction(r.nextInt(900), r.nextInt(700), ID.BasicDistraction, handler));
                }
            }
            
           if (status.getSeconds() % 3 == 0 && !boostOnScreen()) {
                   handler.add(new FocusBoost(r.nextInt(900), r.nextInt(700), ID.HealthBoost, handler));
                   boostOnScreen = true;
            }                    
        }

    }
}
