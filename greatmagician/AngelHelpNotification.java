package greatmagician;

import angels.Angel;
import heroes.Hero;
import main.GameInputWriter;
import main.Main;

import java.io.IOException;

public class AngelHelpNotification extends Notification {

    @Override
    public void update(Hero hero, Angel angel) throws IOException {
        GameInputWriter.write(Main.getArgs()[1], "\n");
        GameInputWriter.write(Main.getArgs()[1], angel + " helped " + hero);
    }
}
