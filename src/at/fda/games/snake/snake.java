package at.fda.games.snake;

import at.fda.games.snowworldAA2.Main;
import org.newdawn.slick.*;

public class snake extends BasicGame {

    Image background = new Image("assets/background.png");
    public snake(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    public static void main(String[] argv) {
        try {

            AppGameContainer container = new AppGameContainer(new snake("snake"));
            container.setDisplayMode(800,800,false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
