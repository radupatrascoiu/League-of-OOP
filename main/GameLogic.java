package main;


import heroes.Hero;

public final class GameLogic {

    private GameLogic() {
    }

    public static boolean existsConflict(final Hero hero1, final Hero hero2) {
        return (hero1.getLocationHistory().getX()
                == hero2.getLocationHistory().getX()
                && hero1.getLocationHistory().getY()
                == hero2.getLocationHistory().getY());
    }

}
