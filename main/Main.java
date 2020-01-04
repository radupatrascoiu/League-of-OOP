package main;

import angels.Angel;
import angels.AngelFactory;
import greatmagician.GreatMagician;
import heroes.Hero;
import heroes.HeroFactory;
import map.MapSingleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() {
    }

    private static String[] savedArgs;
    public static String[] getArgs() {
        return savedArgs;
    }

    public static void main(final String[] args) throws IOException {
        savedArgs = args;
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        MapSingleton map = MapSingleton.getInstance();
        map.init(gameInput.getMap()); // generare harta
        int numberOfHeroes = gameInput.getNumberOfHeroes();
        List<Character> heroes = gameInput.getHeroes();
        List<LocationHistory> locationHistories =  gameInput.getLocationHistories();
        int numberOfRounds = gameInput.getNumberOfRounds();
        char[][] moves = gameInput.getMoves();
        List<Hero> heroesList = new ArrayList<>();
        List<Integer> numberOfAngelPerRound = gameInput.getNumberOfAngelPerRound();
        List<Angel> angels = new ArrayList<>();

        for (int i = 0; i < numberOfHeroes; ++i) { // creare eroi
            heroesList.add(HeroFactory.getHero(heroes.get(i).toString(), locationHistories.get(i)));
            heroesList.get(i).setPosition(i);
        }

        int index = 0;


        for (int i = 0; i < numberOfRounds; ++i) {
            GameInputWriter.write(args[1], "~~ Round " + (i + 1) + " ~~");

            for (int  j = 0; j < numberOfHeroes; ++j) {

                // se verifica damage-ul overtime
                if (heroesList.get(j).getBuff().getTime() != 0) {
                    heroesList.get(j).getBuff().setTime(heroesList.get(j).
                            getBuff().getTime() - 1);

                    heroesList.get(j).setHp(heroesList.get(j).getHp()
                            - heroesList.get(j).getBuff().getDamageOverTime());
                    if (heroesList.get(j).getHp() <= 0) {
                        heroesList.get(j).setDeathOvertime(true);
                    }
                } else {
                    heroesList.get(j).getBuff().setDamageOverTime(0);
                }

                if (!heroesList.get(j).getStun().isStun()) {
                    heroesList.get(j).applyStrategy();
                }

                // se verifica daca eroul are stun
                if (heroesList.get(j).getStun().isStun()) {
                    heroesList.get(j).getStun().setTime(heroesList.get(j).getStun().getTime() - 1);
                    if (heroesList.get(j).getStun().getTime() == 0) {
                        heroesList.get(j).getStun().setStun(false);
                    }
                } else {
                    // daca are hp, se muta
                    if (heroesList.get(j).getHp() > 0) {
                        heroesList.get(j).move(moves[i][j]);
                    }
                }
            }

            for (int j = 0; j < numberOfHeroes; ++j) {
                for (int k = j + 1; k < numberOfHeroes; ++k) {
                    // eroii se ataca doar daca exista conflic
                    if (GameLogic.existsConflict(heroesList.get(j), heroesList.get(k)) && j != k) {
                        if (heroesList.get(j).getPriority() >= heroesList.get(k).getPriority()) {
                            // wizard va fi fortat sa atace al doilea
//                            System.out.println("Ataca primul");
                            heroesList.get(j).play(heroesList.get(k));
                            heroesList.get(k).play(heroesList.get(j));
                        } else {
//                            System.out.println("Ataca al doilea");
                            heroesList.get(k).play(heroesList.get(j));
                            heroesList.get(j).play(heroesList.get(k));
                        }
                    }
                }
            }


            for (int j = numberOfHeroes - 1; j >= 0; j--) {

                if (!heroesList.get(j).isDeathOvertime() || heroesList.get(j).getHp() >= 0) {
                    // se calculeaza hp-ul doar daca este in viata
                    heroesList.get(j).calculateHp();
                } else {
                    continue;
                }
                // la sfarsit de runda se seteaza damage-ul dat si primit la 0
                heroesList.get(j).setDamageReceived(0);
                heroesList.get(j).getEffects().setTotalDamage(0);
                heroesList.get(j).getEffects().setLevelLandDamage(0);
            }

            if (numberOfAngelPerRound.get(i) != 0) {
                for (int j = index; j < numberOfAngelPerRound.get(i) + index; ++j) {
                    // creare ingeri
                    angels.add(AngelFactory.getAngel(gameInput.getAngels().get(j), gameInput.
                            getLocationsAngels().get(j)));
                }
            }

            for (int j = index; j < numberOfAngelPerRound.get(i) + index; ++j) {
                angels.get(j).notifyUpdate(GreatMagician.getAngelSpawnNotification(), null,
                        angels.get(j));
                for (int k = 0; k < numberOfHeroes; ++k) {
                    if (GameLogic.existsConflict(angels.get(j), heroesList.get(k))) {
                        if (heroesList.get(k).getHp() > 0
                                || (heroesList.get(k).getHp() <= 0
                                        && angels.get(j).isAbilityToRevive())) {
                            heroesList.get(k).acceptAngel(angels.get(j));
                        }
                    }
                }
            }

            index += numberOfAngelPerRound.get(i);
//            angels.removeAll(angels);
            GameInputWriter.write(args[1], "\n");
            GameInputWriter.write(args[1], "\n");
        }

        GameInputWriter.write(args[1], "~~ Results ~~");
        GameInputWriter.write(args[1], "\n");

            for (int i = 0; i < numberOfHeroes; ++i) {

                GameInputWriter.write(args[1], heroesList.get(i).displayRace());
                GameInputWriter.write(args[1], " ");
                if (heroesList.get(i).getHp() <= 0) {
                    GameInputWriter.write(args[1], "dead");
                } else {
                    GameInputWriter.write(args[1], String.valueOf(heroesList.get(i).getLevel()));
                    GameInputWriter.write(args[1], " ");
                    GameInputWriter.write(args[1], String.valueOf(heroesList.get(i).getXp()));
                    GameInputWriter.write(args[1], " ");
                    GameInputWriter.write(args[1], String.valueOf(heroesList.get(i).getHp()));
                    GameInputWriter.write(args[1], " ");
                    GameInputWriter.write(args[1], String.valueOf(heroesList.get(i).
                            getLocationHistory().getX()));
                    GameInputWriter.write(args[1], " ");
                    GameInputWriter.write(args[1], String.valueOf(heroesList.get(i).
                            getLocationHistory().getY()));
                }
                GameInputWriter.write(args[1], "\n");
            }
//        GameInputWriter.write(args[1], "\n");
    }
}
