package main;



import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.HeroFactory;
import map.MapSingleton;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	    GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
	    GameInput gameInput = gameInputLoader.load();
        int numberOfLines =  gameInput.getNumberOfLines(); // numar linii harte
        int numberOfColumns = gameInput.getNumberOfColumns(); // numar coloane harta
        MapSingleton map = MapSingleton.getInstance();
        map.init(gameInput.getMap()); // generare harta
        int numberOfHeroes = gameInput.getNumberOfHeroes();
        List<Character> heroes = gameInput.getHeroes();
        List<LocationHistory> locationHistories =  gameInput.getLocationHistories();
        int numberOfRounds = gameInput.getNumberOfRounds();
        char[][] moves = gameInput.getMoves();

        System.out.println(numberOfLines + " " + numberOfColumns);

        for(char i = 0; i < numberOfLines; ++i) {
            System.out.println(MapSingleton.getInstance().getMap()[i]);
        }

        System.out.println(numberOfHeroes);


        List<Hero> heroesList = new ArrayList<>();

        for(int i = 0; i < numberOfHeroes; ++i) {
            heroesList.add(HeroFactory.getHero(heroes.get(i).toString(), locationHistories.get(i)));
        }


        for(Hero hero : heroesList) {
            System.out.println(hero);
        }

        System.out.println(numberOfRounds);


        for(char i = 0; i < moves.length; ++i) {
            System.out.println(moves[i]);
        }

//        System.out.println("START");
//        System.out.println();
//        GameInfo gameInfo = GameInfo.getInstance();
//        gameInfo.init(gameInputLoader);
//        for(char i = 0; i < numberOfLines; ++i) {
//            System.out.println(gameInfo.getMap()[i]);
//        }
//
//        for(char i = 0; i < moves.length; ++i) {
//            System.out.println(gameInfo.getMoves()[i]);
//        }


        for(char i = 0; i < numberOfRounds; ++i) {

            System.out.println("---------- Runda " + (int)i + " ----------");
            for(char j = 0; j < numberOfHeroes; ++j) {
                if(heroesList.get(j).getStun().isStun()) {
                    heroesList.get(j).getStun().setTime(heroesList.get(j).getStun().getTime() - 1);
                    if(heroesList.get(j).getStun().getTime() == 0) {
                        heroesList.get(j).getStun().setStun(false);
                    }
                } else {
                    heroesList.get(j).move(moves[i][j]);
                }

                if(heroesList.get(j).getBuff().getTime() != 0) {
                    heroesList.get(j).getBuff().setTime(heroesList.get(j).getBuff().getTime() - 1);
                    System.out.println(heroesList.get(j).toString() + heroesList.get(j).getHp());
                    heroesList.get(j).setHp(heroesList.get(j).getHp() - heroesList.get(j).getBuff().getDamageOverTime());
                    System.out.println(heroesList.get(j).toString() + heroesList.get(j).getHp());
                }
            }

            for(int j = 0; j < numberOfHeroes; ++j) {
                for(int k = j+1; k < numberOfHeroes; ++k) {

                    if(GameLogic.existsConflict(heroesList.get(j), heroesList.get(k)) && j != k) {
//                        if(heroesList.get(j).getHp() < 0 || heroesList.get(k).getHp() < 0) {
//                            continue; // daca un jucator e mort, mergi mai departe
//                        }
                        if(heroesList.get(j).getPriority() >= heroesList.get(k).getPriority()) {
                            heroesList.get(j).play(heroesList.get(k));
                            heroesList.get(k).play(heroesList.get(j));
                        } else {
                            heroesList.get(k).play(heroesList.get(j));
                            heroesList.get(j).play(heroesList.get(k));
                        }
                    }
                }
            }

            for(char j = 0; j < numberOfHeroes; ++j) {
                heroesList.get(j).calculateHp();
                heroesList.get(j).setDamageReceived(0);
                heroesList.get(j).getEffects().setTotalDamage(0);
                heroesList.get(j).getEffects().setLevelLandDamage(0);
            }
        }


        FileWriter fileWriter = new FileWriter(args[1]);
        for(int i = 0; i < numberOfHeroes; ++i) {

            fileWriter.writeWord(heroesList.get(i).displayRace());
            fileWriter.writeWord(" ");
            if(heroesList.get(i).getHp() <= 0) {
                fileWriter.writeWord("dead");
            } else {
                fileWriter.writeInt(heroesList.get(i).getLevel());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(heroesList.get(i).getXp());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(heroesList.get(i).getHp());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(heroesList.get(i).getLocationHistory().getX());
                fileWriter.writeWord(" ");
                fileWriter.writeInt(heroesList.get(i).getLocationHistory().getY());
            }
            fileWriter.writeNewLine();
        }
        fileWriter.writeNewLine();

        fileWriter.close();

        





    }
}
