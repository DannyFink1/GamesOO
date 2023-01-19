package at.fda.games.b_AA1;
import at.fda.games.d_snowWorld.objects.Actor;
import at.fda.games.b_AA1.objects.Circle;
import at.fda.games.b_AA1.objects.Ellipse;
import at.fda.games.b_AA1.objects.Rectangle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class Main extends BasicGame {
    Random random = new Random();

    private ArrayList<Actor> actors;
    public Main(String title) {
        super(title);
        this.actors = new ArrayList<Actor>();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        for (int i = 0; i <= 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(800), random.nextInt(800), random.nextInt(10), random.nextBoolean());
            Circle circle = new Circle(random.nextInt(800), random.nextInt(800), random.nextInt(10), random.nextInt(100));
            Ellipse ellipse = new Ellipse(random.nextInt(800), random.nextInt(800), random.nextInt(10));
            this.actors.add(rectangle);
            this.actors.add(circle);
            this.actors.add(ellipse);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        for(Actor actor: actors){
            actor.update(i);
        }
    }
    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for(Actor actor: actors){
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new Main("Aufgabe 1"));
            container.setDisplayMode(800,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
