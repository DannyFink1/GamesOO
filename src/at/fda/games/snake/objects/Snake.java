package at.fda.games.snake.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Snake implements HitboxActor{


    private float snakeX,snakeY,snakeSpeed;



    private enum DIRECTION {UP, DOWN, LEFT, RIGHT};
    private DIRECTION direction;
    private Image image;
    private Shape snakeHitbox;
    private Apple appleHitbox;
    private int points;
    private boolean isHit;

    public Snake(Apple apple) {

        this.snakeX = this.snakeY = 100;
        this.snakeHitbox = new Rectangle(snakeX,snakeY,50,50);
        this.appleHitbox = apple;
        this.points = 0;
        this.isHit = false;

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            direction = DIRECTION.DOWN;
            //System.out.println("DOWN");
        }else if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            direction = DIRECTION.UP;
            //System.out.println("UP");
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
            direction = DIRECTION.RIGHT;
            //System.out.println("RIGHT");
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            direction = DIRECTION.LEFT;
            //System.out.println("LEFT");
        }

        if(direction == DIRECTION.DOWN){
            snakeY+=(float) delta/3;
        }else if (direction == DIRECTION.UP) {
            snakeY-=(float) delta/3;
        }else if(direction == DIRECTION.RIGHT){
            snakeX+=(float) delta/3;
        }else if(direction == DIRECTION.LEFT){
            snakeX-=(float) delta/3;
        }

        this.snakeHitbox.setX(snakeX);
        this.snakeHitbox.setY(snakeY);

        if(snakeHitbox.intersects(appleHitbox.getCollisionShape()) && !isHit){
            System.out.println("Hit");
            this.points++;
            this.isHit = true;
            this.appleHitbox.gotDestroyed();
        }

        if(isHit && !snakeHitbox.intersects(appleHitbox.getCollisionShape())){
            this.isHit = false;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(snakeHitbox);
        graphics.fillRect(this.snakeX,this.snakeY,50,50);
        graphics.drawString("Points: " + this.points, 400,100);
    }

    @Override
    public Shape getCollisionShape() {
        return this.snakeHitbox;
    }
}
