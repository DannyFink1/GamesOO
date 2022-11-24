package TdoT;

import org.newdawn.slick.*;

public class TestMain extends BasicGame {


    public Pipe pipe;
    public TestMain(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.pipe = new Pipe();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        pipe.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        pipe.render(graphics);
    }

    public static void main(String[] argv) {
        try {

            AppGameContainer container = new AppGameContainer(new TestMain("flabbyByrrd"));
            container.setDisplayMode(800, 800, false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
