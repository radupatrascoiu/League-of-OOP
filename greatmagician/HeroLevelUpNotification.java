package greatmagician;

import angels.Angel;
import heroes.Hero;
import main.GameInputWriter;
import main.Main;

import java.io.IOException;

public class HeroLevelUpNotification implements Notification {
    /**
     * @param hero
     * @param angel
     * @throws IOException
     */
    @Override
    public void update(final Hero hero, final Angel angel) throws IOException {
        GameInputWriter.write(Main.getArgs()[1], "\n");
        GameInputWriter.write(Main.getArgs()[1], hero + " reached level " + hero.getLevel());
    }
}
