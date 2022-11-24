package at.fda.games.pingPong;

import at.fda.games.snake.objects.HitboxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player2 implements HitboxActor {

    private float y_Pos, speed;
    private Shape hitbox;
    public Player2() {
        this.y_Pos = 325.0f;
        this.speed = 1.0f;
        //this.hitbox = new Rectangle();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) && this.y_Pos > 10) {
            this.y_Pos -= (float) delta / speed;
        }


        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN) && this.y_Pos < 640) {
            this.y_Pos += (float) delta / speed;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(970 ,this.y_Pos,15,150);
    }

    @Override
    public Shape getCollisionShape() {
        return null;
    }
}
