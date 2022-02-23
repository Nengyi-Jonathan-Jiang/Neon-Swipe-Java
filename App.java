import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class App extends JPanel{
    private JFrame frame;

	private BufferedImage buf;

    public App(JFrame frame){
        this.frame = frame;
        setSize(frame.getWidth(), frame.getHeight());
        setBackground(Color.BLACK);

        new Timer(16, e->{
            repaint();
        }).start();

        
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                buf = (BufferedImage)(createImage(getWidth(),getHeight()));
            }
        });
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
        final int WIDTH = SCALE * 2;
        final int HEIGHT = SCALE;
        final int TOP = getWidth() / 2 - SCALE;
        final int LEFT = (getHeight() - SCALE) / 2;

        ((Graphics2D) window).drawImage(buf, null, 0, 0);
    }

    
}
