package heroes;


import main.LocationHistory;

public final class HeroFactory {

    private HeroFactory() {
    }

    public static Hero getHero(final String heroType, final LocationHistory locationHistory) {
        if (heroType == null) {
            return null;
        }

        if (heroType.equalsIgnoreCase("K")) {
            return new heroes.Knight(locationHistory);
        } else if (heroType.equalsIgnoreCase("P")) {
            return new heroes.Pyromancer(locationHistory);
        } else if (heroType.equalsIgnoreCase("R")) {
            return new heroes.Rogue(locationHistory);
        } else if (heroType.equalsIgnoreCase("W")) {
            return new heroes.Wizard(locationHistory);
        }

        return null;
    }
}
