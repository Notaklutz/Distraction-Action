import java.util.Random;
/**
 * @author Ryan Phan
 * @version 3 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Controls the spawning of new objects on screen
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 4, 2019 - Created Spawner and added conditions for BasicDistraction
 * June 5, 2019 - Added conditions for FocusBoost 
 * June 8, 2019 - Added conditions for SlowBoost and DamageReductionBoost
 * </pre>
 * </p>
 */ 
public class Spawner {
    /**
     * Handles the objects present on screen
     */
    private Handler handler;
    /**
     * Player stats
     */
    private PlayerStatus status;
    /**
     * Used to access how much damage the player can take
     */
    private Player player;
    /**
     * Stores how long the user has been alive
     */
    private int timer;
   /**
    * Number of distractions on screen
    */
    private int distractionCount = 0;
   /**
    * Randomizes locations
    */
    private Random r = new Random();
   /**
    * Checks if a certain boost is on the screen
    */
    private boolean boostOnScreen = false;

    /**
     * Initializes variables to access values that affect spawn rates.
     * @param handler Handles the objects present on screen
     * @param status Current player stats
     * @param player The actual player object
     */
    public Spawner(Handler handler, PlayerStatus status, Player player) {
        this.handler = handler;
        this.status = status;
        this.player = player;
    }

    /**
     * Counts the distractions present on screen
     * @return number of distractions on screen
     */
    public int numOfDistractions(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);

            if (tempObj.getId() == ID.BasicDistraction) {
                distractionCount++;
            }
        }
        return distractionCount;
    }

    /**
     * Since only one of each type of boost can be on screen, this method checks for
     * focus boosts on the screen (water bottle)
     * @return if the boost is on screen
     */
   public boolean focusBoostOnScreen(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            boostOnScreen = tempObj.getId() == ID.FocusBoost;
            if (boostOnScreen)
              break;
        }

        return boostOnScreen;
    }

    /**
     * Since only one of each type of boost can be on screen, this method checks for
     * damage reduction boosts on the screen (headphones)
     * @return if the boost is on screen
     */
    public boolean dmgReductionOnScreen(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            boostOnScreen = tempObj.getId() == ID.DamageReductionBoost;
            if (boostOnScreen)
                break;
        }

        return boostOnScreen;
    }

    /**
     * Since only one of each type of boost can be on screen, this method checks for
     * distraction speed reduction boosts on the screen (hourglass)
     * @return if the boost is on screen
     */
    public boolean speedReductionOnScreen(){
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            boostOnScreen = tempObj.getId() == ID.SlowBoost;
            if (boostOnScreen)
                break;
        }

        return boostOnScreen;
    }

   /**
    * Every time the timer reaches the spawn point, this method checks for that to spawn based on the
    * current status of the game.
    */    
    public void tick() {
        timer++;

        if (timer >= PlayerStatus.TIMETILLSPAWN) {
            timer = 0;
            status.setSeconds(status.getSeconds() + 1);
            if (status.getSeconds() % 2 == 0 && numOfDistractions() <= 40) {
                for (int j = 0; j < 3; j++) {
                   handler.add(new BasicDistraction(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.BasicDistraction));
                }
            }
            
           if (status.getSeconds() % 3 == 0 && !focusBoostOnScreen()) {
               handler.add(new FocusBoost(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.FocusBoost));
                   boostOnScreen = true;
            }

            if (status.getSeconds() % 4 == 0 && !dmgReductionOnScreen()) {
                if (player.getDmgTaken() > 15)
                {
                    handler.add(new DamageReductionBoost(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.DamageReductionBoost));
                }
            }

            if (status.getSeconds() % 4 == 0 && !speedReductionOnScreen()) {
                        handler.add(new SlowBoost(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.SlowBoost));
            }
        }

    }
}
