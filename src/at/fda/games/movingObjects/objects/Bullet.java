package at.fda.games.movingObjects.objects;

import at.fda.games.snowworldAA2.objects.Actor;
import at.fda.games.snowworldAA2.objects.HitboxActor;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Bullet implements Actor {
    private Rectangle rectangleToCollideWith;
    private Shape myCollissionShape;
    private boolean isHit = false;

    public Bullet(Rectangle rectangleToCollideWith) {
        this.rectangleToCollideWith = rectangleToCollideWith;
        this.myCollissionShape =new Circle(150,150,100);
    }

    @Override
    public void update(int delta) {
        if (!isHit && this.myCollissionShape.intersects(rectangleToCollideWith.getCollissionShape())){
            System.out.println("Collission");
            isHit=true;
        }
        if (!this.myCollissionShape.intersects(rectangleToCollideWith.getCollissionShape())){

            isHit=false;
        }


    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(myCollissionShape);
        graphics.drawRect(100,100,140,140);
    }


}
