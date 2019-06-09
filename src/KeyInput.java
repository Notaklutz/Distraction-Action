import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * Used to handle keyboard input in level three.
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created KeyInput (Implemented all movement-based actions)
 * June 3, 2019 - Added directional variables to fix movement delay bug
 */
public class KeyInput extends KeyAdapter {
   /**
    * Used to determine what object is the player
    */
    private Handler handler;
   /**
    * If the player is moving up
    */
    private boolean up = false;
    /**
     * If the player is moving down
     */
    private boolean down = false;
    /**
     * If the player is moving left
     */
    private boolean left = false;
    /**
     * If the player is moving right
     */
    private boolean right = false;

    /**
     * Initializes a handler object to determine what object is on screen and what action
     * should be performed to that specific object.
     * @param handler Used to determine what object is the player
     */
    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    /**
     * Called when the key is pressed.
     * @param e Stores the KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            if (tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    up = true;
                    tempObj.setVelY(-6);
                }
                if (key == KeyEvent.VK_A) {
                    left = true;
                    tempObj.setVelX(-6);
                }
                if (key == KeyEvent.VK_S) {
                    down = true;
                    tempObj.setVelY(6);
                }
                if (key == KeyEvent.VK_D) {
                    right = true;
                    tempObj.setVelX(6);
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    /**
     * Called when the key is released.
     * @param e Stores the KeyEvent
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            if (tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    up = false;
                    if (down) {
                        tempObj.setVelY(6);
                    } else {
                        tempObj.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_A) {
                    left = false;
                    if (right) {
                        tempObj.setVelX(6);
                    } else {
                        tempObj.setVelX(0);
                    }
                }
                if (key == KeyEvent.VK_S) {
                    down = false;
                    if (up) {
                        tempObj.setVelY(-6);
                    } else {
                        tempObj.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_D) {
                    right = false;
                    if (left) {
                        tempObj.setVelX(-6);
                    } else {
                        tempObj.setVelX(0);
                    }
                }
            }
        }
    }
}
