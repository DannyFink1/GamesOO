package at.fda.games.angryBalls;


import at.fda.games.angryBalls.objects.Player;
import at.fda.games.angryBalls.objects.Raspberry;
import at.fda.games.angryBalls.objects.Walls;
import org.newdawn.slick.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AngryBallMain extends BasicGame {

    private Player player;
    private Walls walls;
    private Raspberry raspberry;
    private String InputPuffer = "aSadadadaddwa";
    private FileWriter fw;
    private FileReader fr;

    String text = "";


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
            try {
                FileWriter fw = new FileWriter("C://File//scores.txt");
                FileReader fr = new FileReader("C://File/scores.txt");
                if(player.getPoints() > (int)fr.read())
                {
                    fw.write("" + player.getPoints());
                    System.out.println("Du hast den Highscore geknackt!");
                }
                fr.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
