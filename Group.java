import java.awt.Graphics2D;
import java.util.List;

public interface Group {
    public void update();
    public void draw(Graphics2D g, final int SCALE);
    public List<Sprite> getAllSprites();
}
