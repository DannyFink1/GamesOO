package at.fda.games.f_angryBalls.objects;

import at.fda.actors.HitBoxActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Raspberry implements HitBoxActor {


    private Image originalSprite;
    private Image raspberry;
    private Shape raspberryHitbox;
    private float x_Pos, y_Pos;
    private Random random;
    public Raspberry() throws SlickException {
        this.originalSprite = new BigImage("at/fda/games/f_angryBalls/objects/raspberry.tga", Image.FILTER_NEAREST, 512);
        this.raspberry  = this.originalSprite.getScaledCopy(40,40);
        this.random = new Random();
        this.x_Pos = random.nextInt(700-100)+100;
        this.y_Pos = random.nextInt(500-100)+100;
        this.raspberryHitbox = new Circle(this.x_Pos+20,this.y_Pos+20,17);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.raspberryHitbox.setX(this.x_Pos);
        this.raspberryHitbox.setY(this.y_Pos);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(this.raspberry, this.x_Pos, this.y_Pos);
        //graphics.draw(this.raspberryHitbox);
    }

    public Shape getRaspberryHitbox(){
        return raspberryHitbox;
    }

    public void relocateBerry(){
        this.x_Pos = random.nextInt(700-100)+100;
        this.y_Pos = random.nextInt(500-100)+100;
    }

}
