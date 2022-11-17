package at.fda.games.AA1.objects;

import at.fda.games.snowworldAA2.objects.Actor;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor {
    private Random random = new Random();
    private float x,y,speed;
    private int width = random.nextInt(50);
    private int height = random.nextInt(50);

    public Ellipse(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void update(int delta) {
        if(this.y < 800)
            this.y+=(float) delta/this.speed;
        else
            this.y = 0;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x,this.y,this.width,this.height);
    }
}
