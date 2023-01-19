package at.fda.games.d_snowWorld.factory;

import at.fda.actors.Actor;
import at.fda.games.d_snowWorld.Main;
import at.fda.games.d_snowWorld.objects.Snowflake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomActorFactory {
    private List actorList;
    private Random random;
    public RandomActorFactory() {
        this.actorList = new ArrayList<>();
        this.random = new Random();
    }

    public List getActors(int quantity) {

        for (int i = 0; i < quantity; i++) {
            actorList.add(new Snowflake(randomSize()));
        }
        System.out.println(actorList);
        return actorList;
    }

    private Main.SIZE randomSize() {
        int pick = new Random().nextInt(Main.SIZE.values().length);
        return Main.SIZE.values()[pick];
    }
}
