package heroes;
import main.LocationHistory;

public final class HeroFactory {

    private HeroFactory() {
    }

    // se creaza hero-ul specific inputului
    public static Hero getHero(final String heroType, final LocationHistory locationHistory) {
        if (heroType == null) {
            return null;
        }

        if (heroType.equalsIgnoreCase("K")) {
            return new Knight(locationHistory);
        } else if (heroType.equalsIgnoreCase("P")) {
            return new Pyromancer(locationHistory);
        } else if (heroType.equalsIgnoreCase("R")) {
            return new Rogue(locationHistory);
        } else if (heroType.equalsIgnoreCase("W")) {
            return new Wizard(locationHistory);
        }

        return null;
    }
}
