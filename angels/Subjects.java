package angels;

import greatmagician.Notification;
import heroes.Hero;

import java.io.IOException;

public abstract class Subjects {
    public void notifyUpdate(Notification notification, Hero hero, Angel angel) throws IOException {
        notification.update(hero, angel);
    }
}
