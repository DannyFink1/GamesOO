package at.fda.games.snowworldAA2.objects;

import at.fda.games.snowworldAA2.Main;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor{


    private Random random = new Random();
    private float x,y,speed,size;


    public Snowflake(Main.SIZE size) {
        this.y = random.nextInt(1000) - 1000;
        this.x = random.nextInt(780);

        if(size == Main.SIZE.BIG){
            this.size = 12;
            this.speed = 3;
        }
        if(size == Main.SIZE.MEDIUM){
            this.size = 6;
            this.speed = 6;
        }
        if(size == Main.SIZE.SMALL){
            this.size = 3;
            this.speed = 9;
        }
    }

    @Override
    public void update(int delta) {
        if(this.y < 800)
            this.y+=(float) delta/this.speed;
        else
            this.y = random.nextInt(600) - 600;
    }

    @Override
    public void render(Graphics graphics) {

        graphics.fillOval(this.x, this.y, this.size, this.size);
    }
}
