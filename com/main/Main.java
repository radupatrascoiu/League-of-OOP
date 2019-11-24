package com.main;

import com.heroes.Hero;
import com.heroes.HeroFactory;
import com.map.MapSingleton;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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
            System.out.println(map.getMap()[i]);
        }

        System.out.println(numberOfHeroes);


        List<Hero> heroList = new ArrayList<>();

        for(int i = 0; i < numberOfHeroes; ++i) {
            heroList.add(HeroFactory.getHero(heroes.get(i).toString(), locationHistories.get(i)));
        }


        for(Hero hero : heroList) {
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

        


    }
}
