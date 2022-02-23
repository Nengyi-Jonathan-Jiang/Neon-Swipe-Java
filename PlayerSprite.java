import java.awt.*;

public class PlayerSprite implements Sprite{
    private Point<Double> pos;
    private double speed;
    private double angle;


    public PlayerSprite(double x, double y, double speed){
        pos = new Point<>(x, y);
        this.speed = speed;
        this.angle = Math.random() * Math.PI * 2;
    }

    private int getDrawX(final int SCALE){return (int)(pos.x * SCALE);}
    private int getDrawY(final int SCALE){return (int)(pos.y * SCALE);}

    @Override
    public Point<Double> getPos() {
        return pos;
    }
    @Override
    public Point<Double> getVel() {
        return new Point<>(speed * Math.cos(angle), speed * Math.sin(angle));
    }
    @Override
    public void draw(Graphics2D g, final int SCALE) {
        g.setStroke(new BasicStroke(SCALE / 640));
        g.setColor(new Color(0, 255, 255, 255));
        g.drawOval(getDrawX(SCALE), getDrawY(SCALE), SCALE / 40, SCALE / 40);
        g.setColor(new Color(0, 255, 255, 127));
        g.drawOval((int)(SCALE * pos.x), (int)(SCALE * pos.y), SCALE / 40 + SCALE / 320, SCALE / 40 + SCALE / 320);
        g.setColor(new Color(0, 255, 255, 63));
        g.drawOval((int)(SCALE * pos.x) - SCALE / 2, (int)(SCALE * pos.y), SCALE / 40 + 2 * SCALE / 320, SCALE / 40 + 2 * SCALE / 320);
    }
    @Override
    public void update(){

    }
}
