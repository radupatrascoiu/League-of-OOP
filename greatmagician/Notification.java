package greatmagician;

import angels.Angel;
import heroes.Hero;

import java.io.IOException;

public abstract class Notification {
    protected Angel angel;
    public abstract void update(Hero hero, Angel angel) throws IOException;
}
