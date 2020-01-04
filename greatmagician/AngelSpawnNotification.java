package greatmagician;

import angels.Angel;
import heroes.Hero;
import main.GameInputWriter;
import main.Main;

import java.io.IOException;

public class AngelSpawnNotification extends Notification {

    /**
     * @param hero
     * @param angel
     * @throws IOException
     */
    @Override
    public void update(final Hero hero, final Angel angel) throws IOException {
        GameInputWriter.write(Main.getArgs()[1], "\n");
        GameInputWriter.write(Main.getArgs()[1], "Angel " + angel + " was spawned at "
                + angel.getLocationHistory().getX() + " " + angel.getLocationHistory().getY());
    }
}
