package at.fda.games.pingPong;

import at.fda.games.movingObjects.objects.Oval;
import at.fda.games.snake.objects.HitboxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Ball implements HitboxActor {

    private float x_Pos, y_pos, speed;
    private Shape ballHitbox;
    private Random random;

    public Ball() {
        this.x_Pos = 500.0f;
        this.y_pos = 400.0f;
        this.speed = 3.0f;
        this.ballHitbox = new Circle(this.x_Pos, this.y_pos, 30,30);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x_Pos, this.y_pos, 18,18);
    }

    @Override
    public Shape getCollisionShape() {
        return ballHitbox;
    }
}
