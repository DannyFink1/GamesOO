package TdoT;

import org.newdawn.slick.geom.Shape;

public interface HitboxActor extends Actor {
    public Shape getCollisionShape();
}
