import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class App extends JPanel{
	private BufferedImage buf;

    private PlayerSprite playerSprite;
    private BasicGroup basicEnemies;

    public App(JFrame frame){
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                buf = (BufferedImage)(createImage(getWidth(),getHeight()));
            }
        });
        setSize(frame.getWidth(), frame.getHeight());
        setBackground(Color.BLACK);


        playerSprite = new PlayerSprite(1.0, 0.5, 0.2);


        new Timer(16, e->{
            update();
            repaint();
        }).start();
    }
    
    public void update(){
        playerSprite.update();
    }

    @Override
    public void paint(Graphics window){
        if(buf == null) buf = (BufferedImage)(createImage(getWidth(),getHeight()));
        Graphics2D g = (Graphics2D) buf.getGraphics();

        //Clear bkgd
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        //Calc stuff
        final int SCALE = Math.min(getWidth() / 2, getHeight());
        g.translate(getWidth() / 2 - SCALE, (getHeight() - SCALE) / 2);

        //Draw everything

        playerSprite.draw(g, SCALE);

        ((Graphics2D) window).drawImage(buf, null, 0, 0);
    }
}
