package at.fda.games.pingPong;

import at.fda.games.physicTest.PhysicMain;
import org.newdawn.slick.*;

public class PinkPongMain extends BasicGame {

    private Ball ball;
    private Player1 player1;
    private  Player2 player2;
    public PinkPongMain(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.ball = new Ball();
        this.player1 = new Player1();
        this.player2 = new Player2();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        ball.update(gameContainer, i);
        player1.update(gameContainer, i);
        player2.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        ball.render(graphics);
        player1.render(graphics);
        player2.render(graphics);
    }

    public static void main(String argv[]) {
        try {
            AppGameContainer container = new AppGameContainer(new PinkPongMain("PingPongUltra"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
