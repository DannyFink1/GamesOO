package at.fda.games.d_snowWorld.objects;

import org.newdawn.slick.geom.Shape;

public interface HitboxActor extends Actor{
    public Shape getCollissionShape();
}
