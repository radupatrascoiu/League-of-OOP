package com.heroes;

import com.main.LocationHistory;

public class HeroFactory {

    private HeroFactory() {}

    public static Hero getHero(String heroType, LocationHistory locationHistory) {
        if(heroType == null) {
            return null;
        }

        if(heroType.equalsIgnoreCase("K")) {
            return new Knight(locationHistory);
        } else if(heroType.equalsIgnoreCase("P")) {
            return new Pyromancer(locationHistory);
        } else if(heroType.equalsIgnoreCase("R")) {
            return new Rogue(locationHistory);
        } else if(heroType.equalsIgnoreCase("W")) {
            return new Wizard(locationHistory);
        }

        return null;
    }
}
