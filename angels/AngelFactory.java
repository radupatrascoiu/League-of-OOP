package angels;

import main.LocationHistory;

public class AngelFactory {
    private AngelFactory() {
    }

    public static Angel getAngel(final String angelType,
                                 final LocationHistory locationHistory) {
        if(angelType == null) {
            return null;
        }

        if(angelType.equalsIgnoreCase("DamageAngel")) {
            return new DamageAngel();
        } else if(angelType.equalsIgnoreCase("DarkAngel")) {
            return new DarkAngel();
        } else if(angelType.equalsIgnoreCase("Dracula")) {
            return new Dracula();
        } else if(angelType.equalsIgnoreCase("GoodBoy")) {
            return new GoodBoy();
        } else if(angelType.equalsIgnoreCase("LevelUpAngel")) {
            return new LevelUpAngel();
        } else if(angelType.equalsIgnoreCase("LifeGiver")) {
            return new LifeGiver();
        } else if(angelType.equalsIgnoreCase("SmallAngel")) {
            return new SmallAngel();
        } else if(angelType.equalsIgnoreCase("Spawner")) {
            return new Spawner();
        } else if(angelType.equalsIgnoreCase("TheDoomer")) {
            return new TheDoomer();
        } else if(angelType.equalsIgnoreCase("XPAngel")) {
            return new XPAngel();
        }

        return null;
    }
}
