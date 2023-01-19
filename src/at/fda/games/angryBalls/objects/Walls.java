package at.fda.games.angryBalls.objects;

import at.fda.actors.HitBoxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Walls implements HitBoxActor {
    private float upperWall_Y, lowerWall_Y, leftWall_X, rightWall_X, speed;
    private Shape upperWall, lowerWall, leftWall, rigthWall;
    private ArrayList<Shape> wallHitboxes;

    public Walls(float speed) {
        this.speed = speed;
        this.upperWall_Y = -600;
        this.lowerWall_Y = 600;
        this.leftWall_X = -800;
        this.rightWall_X = 800;

        this.upperWall = new Rectangle(0, upperWall_Y, 800, 600);
        this.lowerWall = new Rectangle(0, lowerWall_Y, 800, 600);
        this.leftWall = new Rectangle(leftWall_X, 0, 800, 600);
        this.rigthWall = new Rectangle(rightWall_X, 0, 800, 600);

        this.wallHitboxes = new ArrayList<Shape>();
        this.wallHitboxes.add(upperWall);
        this.wallHitboxes.add(lowerWall);
        this.wallHitboxes.add(leftWall);
        this.wallHitboxes.add(rigthWall);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.upperWall_Y+=(float)delta/speed;
        this.lowerWall_Y-=(float)delta/speed;
        this.leftWall_X+=(float)delta/speed;
        this.rightWall_X-=(float)delta/speed;

        this.upperWall.setY(this.upperWall_Y);
        this.lowerWall.setY(this.lowerWall_Y);
        this.leftWall.setX(this.leftWall_X);
        this.rigthWall.setX(this.rightWall_X);
    }

    @Override
    public void render(Graphics graphics) {
        //upperWall
        graphics.fillRect(0, upperWall_Y, 800, 600);

        //lowerWall
        graphics.fillRect(0, lowerWall_Y, 800, 600);

        //leftWall
        graphics.fillRect(leftWall_X, 0, 800, 600);

        //rightWall
        graphics.fillRect(rightWall_X, 0, 800, 600);

    }


    public ArrayList<Shape> getCollisionShape() {
        return this.wallHitboxes;
    }

    public void resetWallsDuePickUp() {
        this.upperWall_Y = -600;
        this.lowerWall_Y = 600;
        this.leftWall_X = -800;
        this.rightWall_X = 800;
        this.speed = this.speed* 0.9f;
    }
}
