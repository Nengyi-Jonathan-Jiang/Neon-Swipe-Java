import javax.swing.JFrame;

/**
 * This file is complete. You don't need to do anything to it, but
 * it is where you'll run your project when you're ready to see
 * your maze. 
 */
public class Main extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    public Main() {
        super("Maze Builder");
        setSize(WIDTH, HEIGHT);
        // getContentPane().add(

        // ); 
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Main(); 
    }
}
