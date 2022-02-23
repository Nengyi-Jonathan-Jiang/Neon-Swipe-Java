import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class BasicGroup implements Group {
    private List<Sprite> sprites;

    public BasicGroup(){
        sprites = new ArrayList<>();
    }
    public void add(Sprite ...sprites){
        for(Sprite s : sprites) this.sprites.add(s);
    }

    @Override
    public void draw(Graphics2D g, final int SCALE) {
        for(Sprite s : sprites) s.draw(g, SCALE);
    }

    @Override
    public List<Sprite> getAllSprites() {
        return sprites;
    }

    @Override
    public void update() {
        for(Sprite s : sprites) s.update();
    }   
}
