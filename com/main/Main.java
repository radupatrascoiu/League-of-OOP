package com.main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
	    GameInput gameInput = gameInputLoader.load();

        int numberOfLines =  gameInput.getNumberOfLines();
        int numberOfColumns = gameInput.getNumberOfColumns();
        char[][] map = gameInput.getMap();
        int numberOfHeroes = gameInput.getNumberOfHeroes();
        List<Character> heroes = gameInput.getHeroes();
        List<Direction> heroesPosition =  gameInput.getHeroesPositions();
        int numberOfRounds = gameInput.getNumberOfRounds();

        System.out.println(numberOfLines + " " + numberOfColumns);
        for(char i = 0; i < numberOfLines; ++i) {
            System.out.println(map[i]);
        }

        System.out.println(numberOfHeroes);
        System.out.println(heroes);
        System.out.println(numberOfRounds);
        System.out.println(heroesPosition);

        for(int i = 0; i < numberOfHeroes; ++i) {
            System.out.println(heroesPosition.get(i).getDirection());
        }
    }
}
