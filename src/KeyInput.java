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
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created PlayerStatus
 */ 
public class KeyInput extends KeyAdapter {
   /**
    * PLACEHOLDER
    */
    private Handler handler;
   /**
    * PLACEHOLDER
    */
    private boolean up = false;
   /**
    * PLACEHOLDER
    */
    private boolean down = false;
   /**
    * PLACEHOLDER
    */	
    private boolean left = false;
   /**
    * PLACEHOLDER
    */
    private boolean right = false;

   /**
    * PLACEHOLDER
    */
    public KeyInput(Handler handler) {
        this.handler = handler;
    }

   /**
    * PLACEHOLDER
    */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            if (tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    up = true;
                    tempObj.setVelY(-5);
                }
                if (key == KeyEvent.VK_A) {
                    left = true;
                    tempObj.setVelX(-5);
                }
                if (key == KeyEvent.VK_S) {
                    down = true;
                    tempObj.setVelY(5);
                }
                if (key == KeyEvent.VK_D) {
                    right = true;
                    tempObj.setVelX(5);
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

   /**
    * PLACEHOLDER
    */	
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);
            if (tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    up = false;
                    if (down) {
                        tempObj.setVelY(5);
                    } else {
                        tempObj.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_A) {
                    left = false;
                    if (right) {
                        tempObj.setVelX(5);
                    } else {
                        tempObj.setVelX(0);
                    }
                }
                if (key == KeyEvent.VK_S) {
                    down = false;
                    if (up) {
                        tempObj.setVelY(-5);
                    } else {
                        tempObj.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_D) {
                    right = false;
                    if (left) {
                        tempObj.setVelX(-5);
                    } else {
                        tempObj.setVelX(0);
                    }
                }
            }
        }
    }
}
