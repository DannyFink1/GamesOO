package at.fda.games.snowworldAA2;

import at.fda.games.snowworldAA2.objects.Actor;
import at.fda.games.snowworldAA2.objects.Snowflake;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class Main extends BasicGame {

    Random random = new Random();
    public enum SIZE {BIG, MEDIUM, SMALL};
    public ArrayList<Actor> actors;
    public Main(String title) {
        super(title);
    } 

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        SIZE size;
        actors = new ArrayList<Actor>();
        for (int i = 0; i < 100; i++) {
            if(i % 3 == 0)
                size = SIZE.BIG;
            else if(i % 3 == 1)
                size = SIZE.MEDIUM;
            else
                size = SIZE.SMALL;

            Snowflake snowflake = new Snowflake(size);
            actors.add(snowflake);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor: actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor: actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {

            AppGameContainer container = new AppGameContainer(new Main("snowworld"));
            container.setDisplayMode(800,800,false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
