package TdoT;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Pipe implements HitboxActor{

    //Hitboxes
    //TODO Add Colliding Actions in bird class (birdhitbox.intersects(...))
    private Shape upperHitbox, pointsTrigger, lowerHitbox;
    //For sliding Pipes
    private float x_Pos,speed;
    //Pipe Sizes
    private float upperPipe_Height, lowerPipe_Height, pipe_Width, pipe_spaceBetween;


    public Pipe() {
        this.x_Pos = 400;
        this.pipe_Width = 40;
        this.pipe_spaceBetween = 200;
        //TODO Add Randomizer for Pipe Height (need Minimum and Maximum)
        this.upperPipe_Height = 100;
        this.lowerPipe_Height = this.upperPipe_Height + this.pipe_spaceBetween;
        this.upperHitbox = new Rectangle(this.x_Pos, 0, this.pipe_Width, this.upperPipe_Height);
        this.lowerHitbox = new Rectangle(this.x_Pos, this.lowerPipe_Height , this.pipe_Width, 800);
        this.pointsTrigger = new Rectangle(this.x_Pos + this.pipe_Width/2.0f, this.upperPipe_Height, 1, 200);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        //TODO Add constant Pipe-Movement to the left
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x_Pos, 0, this.pipe_Width, this.upperPipe_Height);
        graphics.fillRect(this.x_Pos, this.lowerPipe_Height , this.pipe_Width, 800);
        graphics.draw(this.upperHitbox);
        graphics.draw(this.lowerHitbox);

        //TODO delete in the End
        graphics.draw(this.pointsTrigger);
    }


    public Shape getUpperCollisionShape() {
        return upperHitbox;
    }
    public Shape getLowerCollisionShape() {
        return lowerHitbox;
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }
}
