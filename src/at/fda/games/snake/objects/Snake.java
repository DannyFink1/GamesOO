package at.fda.games.snake.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Snake implements HitboxActor{


    private float x,y,speed;



    private enum DIRECTION {UP, DOWN, LEFT, RIGHT};
    private DIRECTION direction;
    private Image image;
    private Shape snakeHitbox;
    private Rectangle rectangle;

    public Snake() {

        this.x = this.y = 100;
        this.snakeHitbox = new Rectangle(x,y,50,50);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            direction = DIRECTION.DOWN;
            System.out.println("DOWN");
        }else if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            direction = DIRECTION.UP;
            System.out.println("UP");
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
            direction = DIRECTION.RIGHT;
            System.out.println("RIGHT");
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            direction = DIRECTION.LEFT;
            System.out.println("LEFT");
        }

        if(direction == DIRECTION.DOWN){
            y+=(float) delta/3;
        }else if (direction == DIRECTION.UP) {
            y-=(float) delta/3;
        }else if(direction == DIRECTION.RIGHT){
            x+=(float) delta/3;
        }else if(direction == DIRECTION.LEFT){
            x-=(float) delta/3;
        }

        this.snakeHitbox.setX(x);
        this.snakeHitbox.setY(y);

    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(snakeHitbox);
        graphics.fillRect(x,y,50,50);

    }

    @Override
    public Shape getCollisionShape() {
        return this.snakeHitbox;
    }
}
