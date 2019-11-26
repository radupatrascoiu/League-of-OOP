package main;


import heroes.Hero;

public class GameLogic {

    public static boolean existsconflict(Hero hero1, Hero hero2) {
        return (hero1.getLocationHistory().getX() ==
                hero2.getLocationHistory().getX() &&
                hero1.getLocationHistory().getY() ==
                        hero2.getLocationHistory().getY());
    }

}
