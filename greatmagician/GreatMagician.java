package greatmagician;

import java.util.ArrayList;
import java.util.List;

public class GreatMagician {
    private static GreatMagician greatMagician = null;
    private static List<Notification> notifications;
    private static AngelHelpNotification angelHelpNotification;
    private static AngelHitNotification angelHitNotification;
    private static AngelKillNotification angelKillNotification;
    private static AngelReviveNotification angelReviveNotification;
    private static AngelSpawnNotification angelSpawnNotification;
    private static AngelXpNotification angelXpNotification;
    private static HeroKillNotification heroKillNotification;
    private static LevelUpNotification levelUpNotification;

    private GreatMagician() {
    }

    public static GreatMagician getInstance() {

        notifications = new ArrayList<>();
        angelHelpNotification = new AngelHelpNotification();
        angelHitNotification = new AngelHitNotification();
        angelKillNotification = new AngelKillNotification();
        angelReviveNotification = new AngelReviveNotification();
        angelSpawnNotification = new AngelSpawnNotification();
        angelXpNotification = new AngelXpNotification();
        heroKillNotification = new HeroKillNotification();
        levelUpNotification = new LevelUpNotification();

        notifications.add(angelHelpNotification);
        notifications.add(angelHitNotification);
        notifications.add(angelKillNotification);
        notifications.add(angelReviveNotification);
        notifications.add(angelSpawnNotification);
        notifications.add(angelXpNotification);
        notifications.add(heroKillNotification);
        notifications.add(levelUpNotification);

        if(greatMagician == null) {
            return new GreatMagician();
        }

        return greatMagician;
    }

    public static List<Notification> getNotifications() {
        return notifications;
    }

    public static AngelHelpNotification getAngelHelpNotification() {
        return angelHelpNotification;
    }

    public static AngelHitNotification getAngelHitNotification() {
        return angelHitNotification;
    }

    public static AngelKillNotification getAngelKillNotification() {
        return angelKillNotification;
    }

    public static AngelReviveNotification getAngelReviveNotification() {
        return angelReviveNotification;
    }

    public static AngelSpawnNotification getAngelSpawnNotification() {
        return angelSpawnNotification;
    }

    public static AngelXpNotification getAngelXpNotification() {
        return angelXpNotification;
    }

    public static HeroKillNotification getHeroKillNotification() {
        return heroKillNotification;
    }

    public static LevelUpNotification getLevelUpNotification() {
        return levelUpNotification;
    }
}
