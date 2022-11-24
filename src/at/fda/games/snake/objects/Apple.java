package at.fda.games.snake.objects;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Apple implements HitboxActor {

    private Random random;
    private Image original;
    private Image image;
    private int x_Pos, y_Pos;
    private int points;
    private Snake snakeToCollideWith;
    private Rectangle myCollisionHitBox;




    public Apple(Snake snakeToCollideWith) throws SlickException {
        random = new Random();
        x_Pos = random.nextInt(700);
        y_Pos = random.nextInt(700);
        image = new Image("assets/apple.tga");
        image = image.getScaledCopy(50,50);
        this.snakeToCollideWith = snakeToCollideWith;
        this.myCollisionHitBox = new Rectangle(this.x_Pos, this.y_Pos, 50,50);
    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(this.myCollisionHitBox.intersects(snakeToCollideWith.getCollisionShape())){
            System.out.println("Hit");
            this.x_Pos = -100;
            this.y_Pos = -100;
        }
        myCollisionHitBox.setY(this.y_Pos);
        myCollisionHitBox.setX(this.x_Pos);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(myCollisionHitBox);
        image.draw(this.x_Pos,this.y_Pos);
    }

    @Override
    public Shape getCollisionShape() {
        return myCollisionHitBox;
    }

    public int getPoints() {
        return points;
    }
}