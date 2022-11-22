package at.fda.games.snowworldAA2.objects;

import org.newdawn.slick.geom.Shape;

public interface HitboxActor extends Actor{
    public Shape getCollissionShape();
}
