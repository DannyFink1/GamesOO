package at.fda.games.AA1.objects;

import at.fda.games.snowworldAA2.objects.Actor;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {

    private Random random = new Random();
    private float x,y,speed;
    private boolean dirLeft;

    private int width = random.nextInt(50);
    private int height = random.nextInt(50);

    public Rectangle(float x, float y, float speed, boolean directionLeft) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dirLeft = directionLeft;
    }

    @Override
    public void update(int delta) {
        if(this.dirLeft){
            if(this.x < 600)
                this.x+=(float) delta/this.speed;
            else
                this.dirLeft = false;
        }
        else {
            if(this.x > 100)
                this.x-=(float) delta/this.speed;
            else this.dirLeft = true;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.width,this.height);
    }
}
