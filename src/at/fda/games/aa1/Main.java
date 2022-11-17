package at.fda.games.aa1;
import at.fda.games.aa1.objects.Actor;
import at.fda.games.aa1.objects.Rectangle;
import org.newdawn.slick.*;

import java.util.ArrayList;

public class Main extends BasicGame {

    private ArrayList<Actor> actors;
    public Main(String title) {
        super(title);
        this.actors = new ArrayList<Actor>();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        for (int i = 0; i < 50; i++) {
            Rectangle rectangle = new Rectangle()
        }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Aufgabe 1"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
