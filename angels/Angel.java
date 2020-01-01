package angels;

import greatmagician.GreatMagician;
import greatmagician.Notification;
import heroes.*;
import main.LocationHistory;

import java.io.IOException;

public abstract class Angel extends Subjects {
    protected LocationHistory locationHistory;
    protected boolean abilityToRevive;

    public Angel(LocationHistory locationHistory) {
        this.locationHistory = locationHistory;
        this.abilityToRevive = false;
    }

    public LocationHistory getLocationHistory() {
        return locationHistory;
    }

    public boolean isAbilityToRevive() {
        return abilityToRevive;
    }

    public abstract void visit(Pyromancer pyromancer) throws IOException;
    public abstract void visit(Knight knight) throws IOException;
    public abstract void visit(Wizard wizard) throws IOException;
    public abstract void visit(Rogue rogue) throws IOException;


    public void register(Notification notification) {
        GreatMagician.getNotifications().add(notification);
    }

    public void unregister(Notification notification) {
        GreatMagician.getNotifications().remove(notification);
    }

    public void notifyObservers(Hero hero, Angel angel) throws IOException {
        for(Notification notification :  GreatMagician.getNotifications()) {
            notification.update(hero, angel);
        }
    }

    @Override
    public String toString() {
        return "Angel{" +
                "locationHistory=" + locationHistory +
                ", abilityToRevive=" + abilityToRevive +
                '}';
    }
}
