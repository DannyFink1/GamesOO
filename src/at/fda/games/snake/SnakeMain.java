package at.fda.games.snake;

import at.fda.games.snake.objects.Actor;
import at.fda.games.snake.objects.Apple;
import at.fda.games.snake.objects.Snake;
import org.newdawn.slick.*;

import java.util.ArrayList;

public class SnakeMain extends BasicGame {

    private Image background;

    private ArrayList<Actor> actors;
    private int points;

    public SnakeMain(String title) {

        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("assets/background.tga");
        background = background.getScaledCopy(1600,900);
        actors = new ArrayList<Actor>();

        for (int i = 0; i < 1; i++) {
            Snake snake = new Snake();
            Apple apple = new Apple(snake);
            actors.add(apple);
            actors.add(snake);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        for( Actor actor : actors){
            actor.update(gameContainer, i);

        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw(0,0);

        for( Actor actor : actors){
            actor.render(graphics);
        }
        graphics.drawString("Punkte: " + points);
    }

    public static void main(String[] argv) {
        try {

            AppGameContainer container = new AppGameContainer(new SnakeMain("snake"));
            container.setDisplayMode(800,800,false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
