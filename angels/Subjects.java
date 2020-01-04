package angels;

import greatmagician.Notification;
import heroes.Hero;

import java.io.IOException;

public abstract class Subjects {
    public final void notifyUpdate(final Notification notification, final Hero hero,
                                   final Angel angel) throws IOException {
        notification.update(hero, angel);
    }
}
