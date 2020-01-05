package angels;

import main.LocationHistory;

public final class AngelFactory {
    private AngelFactory() {
    }

    public static Angel getAngel(final String angelType,
                                 final LocationHistory locationHistory) {
        // se creaza fiecare inger in functie de inputul primit
        if (angelType == null) {
            return null;
        }

        if (angelType.equalsIgnoreCase("DamageAngel")) {
            return new DamageAngel(locationHistory);
        } else if (angelType.equalsIgnoreCase("DarkAngel")) {
            return new DarkAngel(locationHistory);
        } else if (angelType.equalsIgnoreCase("Dracula")) {
            return new Dracula(locationHistory);
        } else if (angelType.equalsIgnoreCase("GoodBoy")) {
            return new GoodBoy(locationHistory);
        } else if (angelType.equalsIgnoreCase("LevelUpAngel")) {
            return new LevelUpAngel(locationHistory);
        } else if (angelType.equalsIgnoreCase("LifeGiver")) {
            return new LifeGiver(locationHistory);
        } else if (angelType.equalsIgnoreCase("SmallAngel")) {
            return new SmallAngel(locationHistory);
        } else if (angelType.equalsIgnoreCase("Spawner")) {
            return new Spawner(locationHistory);
        } else if (angelType.equalsIgnoreCase("TheDoomer")) {
            return new TheDoomer(locationHistory);
        } else if (angelType.equalsIgnoreCase("XPAngel")) {
            return new XPAngel(locationHistory);
        }

        return null;
    }
}
