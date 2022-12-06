package at.fda.games.angryBalls;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

public class AngryBallMain extends BasicGame {

    private Player player;
    private Walls walls;
    private Raspberry raspberry;
    private String InputPuffer = "aSadadadaddwa";



    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.walls = new Walls(30);
        this.raspberry = new Raspberry();
        this.player = new Player(40,40, 1.5f, walls, raspberry);

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        player.update(gameContainer, i);
        walls.update(gameContainer, i);
        raspberry.update(gameContainer, i);
        if(player.checkIfDead())
        {
            gameContainer.exit();


        }
        //raspberry.getRaspberryHitbox();
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        player.render(graphics);
        raspberry.render(graphics);

        walls.render(graphics);



    }

    public AngryBallMain(String title) {
        super(title);
    }

    public static void main(String argv[]) {
        try {
            AppGameContainer container = new AppGameContainer(new AngryBallMain("angryBall"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
