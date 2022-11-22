package at.fda.games.physicTest;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.CurveTest;

public class PhysicMain extends BasicGame {

    private float Pos_y, speed;
    private boolean isJumping;
    private boolean isBlocked;
    private int runTime;
    private int deltaRunTime;

    public PhysicMain(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.Pos_y = 200;
        this.speed = 2;
        this.isJumping = false;
        this.runTime = 0;
        this.deltaRunTime = 0;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        //runTime zählt hoch
        this.runTime += delta;

        if (this.Pos_y < 570) {

        }
        //Cooldown 0.2 Sekunden
        if (this.deltaRunTime % 1000 == 0 && this.isJumping) {
            this.isJumping = false;

        }


        //Jump
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && this.isBlocked == false) {
            this.isJumping = true;
            this.isBlocked = true;
            this.deltaRunTime = 0;
        }

        if (this.isBlocked){
            this.deltaRunTime += delta;
            if (deltaRunTime>2000){
                this.isBlocked = false;
                this.deltaRunTime = 0;
            }
        }

        if (this.isJumping) {
            this.Pos_y -= 1.2;


        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(400, this.Pos_y, 30, 30);
    }

    public static void main(String argv[]) {
        try {
            AppGameContainer container = new AppGameContainer(new PhysicMain("Physics"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
