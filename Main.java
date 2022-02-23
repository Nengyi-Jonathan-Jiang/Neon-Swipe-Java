import javax.swing.JFrame;
import java.awt.event.*;
import java.util.*;

/**
 * This file is complete. You don't need to do anything to it, but
 * it is where you'll run your project when you're ready to see
 * your maze. 
 */
public class Main extends JFrame {
    public boolean full_fullscreen = false;
    public Map<String, Boolean> heldKeys = new TreeMap<>();

    public Main() {
        super("Neon Swipe");
        setSize(800,400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().add(new App(this));
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowFocusListener( new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                for(String key : heldKeys.keySet()){
                    heldKeys.put(key, false);
                }
            }
            @Override
            public void windowGainedFocus(WindowEvent e) { }
        });;

        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                heldKeys.put(KeyEvent.getKeyText(e.getKeyCode()), true);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                heldKeys.put(KeyEvent.getKeyText(e.getKeyCode()), false);

                //Handle f11 (toggle fullscreen)
                if(KeyEvent.getKeyText(e.getKeyCode()).equals("F11")){
                    dispose();
                    setUndecorated(full_fullscreen = !full_fullscreen);
                    setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args){new Main();}
}