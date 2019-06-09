import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * June 8, 2019 - Scraped KeyAdapter and KeyListener, swapped with KeyBindings
 *                due to issues regarding component focus and JAR file issues.
 *                Renamed to PlayerMovement to better suit usage.
 */
public class PlayerMovement {
    /**
     * If the player is moving right
     */
    private Player p;
    /**
     * If the player is moving right
     */
    private LevelThreeGame g;
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
     * Initializes variables that will allow the user to control the player using the keyboard
     * @param p The player
     * @param g The game panel
     */
    public PlayerMovement(Player p, LevelThreeGame g) {
        this.g = g;
        this.p = p;
        playerMovement();
    }

    /**
     * Used to simplify code used to add KeyBindings for player movement in level three
     * @param component The component the player is within
     * @param p The player
     * @param keyCode The key to be used
     * @param id Identifies the key pressed
     * @param actionListener Action to be performed
     */
    private void addKeyBinding(JComponent component, Player p, int keyCode, String id, ActionListener actionListener){
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();


        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, false)
                , id);
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, true)
                , id + " released");


        actionMap.put(id, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });

        actionMap.put(id + " released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String releaseKey = id + " released";
                if (releaseKey.equals("UP released")){
                    up = false;
                    if (down) {
                        p.setVelY(6);
                    } else {
                        p.setVelY(0);
                    }
                }
                if (releaseKey.equals("LEFT released")) {
                    left = false;
                    if (right) {
                        p.setVelX(6);
                    } else {
                        p.setVelX(0);
                    }
                }
                if (releaseKey.equals("DOWN released")) {
                    down = false;
                    if (up) {
                        p.setVelY(-6);
                    } else {
                        p.setVelY(0);
                    }
                }
                if (releaseKey.equals("RIGHT released")) {
                    right = false;
                    if (left) {
                        p.setVelX(-6);
                    } else {
                        p.setVelX(0);
                    }
                }
            }
        });
    }

    /**
     * Adds player movement controls to be used in level three
     */
    private void playerMovement() {
        addKeyBinding(g, p, KeyEvent.VK_W, "UP",(actionEvent)-> {
            up = true;
            p.setVelY(-6);
        });
        addKeyBinding(g, p, KeyEvent.VK_A, "LEFT",(actionEvent)-> {
            left = true;
            p.setVelX(-6);
        });
        addKeyBinding(g, p, KeyEvent.VK_S, "DOWN",(actionEvent)-> {
            down = true;
            p.setVelY(6);
        });
        addKeyBinding(g, p, KeyEvent.VK_D, "RIGHT",(actionEvent)-> {
            right = true;
            p.setVelX(6);
        });
    }
}
