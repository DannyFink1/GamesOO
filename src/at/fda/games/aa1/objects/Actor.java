package at.fda.games.aa1.objects;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void update(int delta);
    public void render(Graphics graphics);
}
