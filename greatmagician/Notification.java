package greatmagician;

import angels.Angel;
import heroes.Hero;

import java.io.IOException;

public abstract class Notification {
    public abstract void update(Hero hero, Angel angel) throws IOException;
}
