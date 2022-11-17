package at.fda.games.aa1.objects;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor{

    private float x,y,speed;

    public Rectangle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void update(int delta) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
