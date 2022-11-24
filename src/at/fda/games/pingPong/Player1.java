package at.fda.games.pingPong;

import at.fda.games.snake.objects.HitboxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player1 implements HitboxActor {

    private float y_Pos, speed;
    private Shape hitbox;
    public Player1() {
        this.y_Pos = 325.0f;
        this.speed = 1.0f;
        this.hitbox = new Rectangle(20,this.y_Pos,15,150);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


            if (gameContainer.getInput().isKeyDown(Input.KEY_W) && this.y_Pos > 10) {
                this.y_Pos -= (float) delta / speed;
            }


            if(gameContainer.getInput().isKeyDown(Input.KEY_S) && this.y_Pos < 640) {
                this.y_Pos += (float) delta / speed;
            }

            hitbox.setY(this.y_Pos);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(hitbox);
        graphics.fillRect(20,this.y_Pos,15,150);
    }

    @Override
    public Shape getCollisionShape() {
        return hitbox;
    }
}
