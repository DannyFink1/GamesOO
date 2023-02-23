package at.fda.games.f_angryBalls;


import at.fda.games.f_angryBalls.objects.Player;
import at.fda.games.f_angryBalls.objects.Raspberry;
import at.fda.games.f_angryBalls.objects.Walls;
import org.newdawn.slick.*;

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
            char[] chars = new char[2];
            try {
                FileReader fr = new FileReader("C://File/scores.txt");
                int x = fr.read();
                chars[0] = 'c';
                chars[1] = '2';
                System.out.println(chars[0]);
                System.out.println(player.getPoints());
                fr.close();
                FileWriter fw = new FileWriter("C://File//scores.txt");

                if(player.getPoints() > x)
                {
                    if(player.getPoints() < 10)
                        fw.write("0" + player.getPoints());
                    else
                        fw.write("" + player.getPoints());
                    System.out.println("Du hast den Highscore geknackt!");
                }
                else {
                    fw.write(x);
                    System.out.println("Schade");
                }

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
