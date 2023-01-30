package at.fda.games.angryBalls.objects;

import at.fda.actors.HitBoxActor;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Player implements HitBoxActor {

    private float pos_X, pos_Y, width, height, speed;
    private Walls walls;
    private Raspberry raspberry;
    private Shape myCollisionShape;
    private boolean isDead;
    private int points;
    private Image originalSprite;
    private Image player;

    public Player(float width, float height, float speed, Walls walls, Raspberry raspberry) throws SlickException {
        this.width = width;
        this.height = height;
        this.pos_X = 400;
        this.pos_Y = 300;
        this.speed = speed;
        this.walls = walls;
        this.myCollisionShape = new Circle(this.pos_X+this.width/2,
                this.pos_Y+this.height/2,this.width/2);
        this.isDead = false;
        this.raspberry = raspberry;
        this.points = 0;
        this.originalSprite = new BigImage("at/fda/games/angryBalls/objects/talHair.tga", Image.FILTER_NEAREST, 512);
        this.player  = this.originalSprite.getScaledCopy(40,40);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.myCollisionShape.setY(this.pos_Y);
        this.myCollisionShape.setX(this.pos_X);
        if(gameContainer.getInput().isKeyDown(Input.KEY_W) || gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.pos_Y-=(float) delta/this.speed;
        }

        if(gameContainer.getInput().isKeyDown(Input.KEY_S) || gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            this.pos_Y+=(float) delta/this.speed;
        }

        if(gameContainer.getInput().isKeyDown(Input.KEY_A) || gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.pos_X-=(float) delta/this.speed;
        }

        if(gameContainer.getInput().isKeyDown(Input.KEY_D) || gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            this.pos_X+=(float) delta/this.speed;
        }

        for(Shape shape: walls.getCollisionShape())
        {
            if(this.myCollisionShape.intersects(shape))
            {
                //System.out.println("hit");
                this.isDead = true;
            }
        }
        if(this.myCollisionShape.intersects(this.raspberry.getRaspberryHitbox())){
            this.raspberry.relocateBerry();
            this.points++;
            System.out.println("Punkteanzahl: " + this.points);
            this.walls.resetWallsDuePickUp();

        }

    }

    @Override
    public void render(Graphics graphics) {
        //graphics.fillOval(this.pos_X, this.pos_Y, this.width, this.height);
        graphics.drawImage(this.player, this.pos_X, this.pos_Y);
        //graphics.draw(myCollisionShape);

    }


    public Shape getCollisionShape() {
        return null;
    }

    public boolean checkIfDead(){

        if(isDead)
            return true;
        else
            return false;

    }

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }

    public int getPoints() {
        return points;
    }
}


