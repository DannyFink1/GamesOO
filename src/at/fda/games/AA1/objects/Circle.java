package at.fda.games.AA1.objects;

import at.fda.games.snowworldAA2.objects.Actor;
import org.newdawn.slick.Graphics;

public class Circle implements Actor {

    private float x,y,speed, diameterGrowth;
    private float diameter = 20;


    public Circle(float x, float y, float speed, float diameterGrowth) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.diameterGrowth = diameterGrowth;
    }

    @Override
    public void update(int delta) {
        if(this.x < 800)
            this.x+=(float) delta/this.speed;
        else{
            this.x = 0;
            this.diameter = 20;
        }


    }

    @Override
    public void render(Graphics graphics) {
        this.diameter = (float) (this.diameter+diameterGrowth/10000);
        graphics.drawOval(this.x,this.y,this.diameter, this.diameter);
    }
}
