package at.fda.games.movingObjects.objects;

import at.fda.games.snowworldAA2.objects.HitboxActor;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Rectangle implements HitboxActor {


    private enum DIRECTION {RIGHT,LEFT,UP,DOWN};
    private float x;
    private float y;

    private org.newdawn.slick.geom.Rectangle hitBox;

    private DIRECTION objectDirection;
    private float speed;

    public Rectangle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.objectDirection = DIRECTION.RIGHT;
        this.hitBox = new org.newdawn.slick.geom.Rectangle(x,y,40,40);

    }

    public void render(Graphics graphics){
        graphics.draw(hitBox);
        graphics.drawRect(this.x,this.y,100,100);
    }

    public void update(int delta){

        if(this.objectDirection == DIRECTION.RIGHT) {
            if (this.x < 500)
                this.x += (float) delta / this.speed;
            else
                this.objectDirection = DIRECTION.DOWN;


        }
       // System.out.println(objectDirection);
        if(this.objectDirection == DIRECTION.DOWN) {

            if (this.y < 500)
                this.y += (float) delta / this.speed;
            else
                this.objectDirection = DIRECTION.LEFT;

        }

        if(this.objectDirection == DIRECTION.LEFT) {

            if (this.x > 200)
                this.x -= (float) delta / this.speed;
            else
                this.objectDirection = DIRECTION.UP;

        }

        if(this.objectDirection == DIRECTION.UP) {

            if (this.y > 200)
                this.y -= (float) delta / this.speed;
            else
                this.objectDirection = DIRECTION.RIGHT;

        }
        hitBox.setY(this.y);
        hitBox.setX(this.x);
    }


    @Override
    public Shape getCollissionShape() {

        return this.hitBox;
    }

}
