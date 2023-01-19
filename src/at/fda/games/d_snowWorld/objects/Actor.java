package at.fda.games.d_snowWorld.objects;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void update(int delta);
    public void render(Graphics graphics);
}
