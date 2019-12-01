package main;


import heroes.Hero;

public final class GameLogic {

    private GameLogic() {
    }
    // determina daca 2 eroi se afla in acelasi loc
    public static boolean existsConflict(final Hero hero1, final Hero hero2) {
        return (hero1.getLocationHistory().getX()
                == hero2.getLocationHistory().getX()
                && hero1.getLocationHistory().getY()
                == hero2.getLocationHistory().getY());
    }

}
