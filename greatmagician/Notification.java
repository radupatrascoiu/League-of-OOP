package greatmagician;

import angels.Angel;
import heroes.Hero;

import java.io.IOException;

public interface Notification {
    void update(Hero hero, Angel angel) throws IOException;
}
