package at.fda.games.e_UntitledDimeGame;

import org.newdawn.slick.*;


public class Main extends BasicGame {

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer g) throws SlickException {

    }

    @Override
    public void update(GameContainer g, int d) throws SlickException {

    }

    @Override
    public void render(GameContainer ga, Graphics gr) throws SlickException {
        if(ga.getInput().isKeyPressed(Input.KEY_F)) {
            ga.setFullscreen(!ga.isFullscreen());
        }
    }

    public static void main(String[] argv) {
        try {

            AppGameContainer container = new AppGameContainer(new Main("UntitledDimeGame"));
            container.setDisplayMode(800,800, true);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
