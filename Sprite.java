import java.awt.Graphics2D;

public interface Sprite {
    public Point<Double> getPos();
    public Point<Double> getVel();
    public void update();
    public void draw(Graphics2D g, final int SCALE);
}