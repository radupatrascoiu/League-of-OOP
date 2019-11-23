package com.main;

import java.util.Arrays;
import java.util.List;

public class GameInput {

    private int numberOfLines = 0;
    private int numberOfColumns = 0;
    private final char[][] map;
    private int numberOfHeroes;
    private List<Character> heroes;
    private List<Direction> heroesPositions;
    private int numberOfRounds;

    public GameInput(int numberOfLines, int numberOfColumns, char[][] map, int numberOfHeroes, List<Character> heroes, List<Direction> heroesPositions, int numberOfRounds) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
        this.numberOfHeroes = numberOfHeroes;
        this.heroes = heroes;
        this.heroesPositions = heroesPositions;
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public char[][] getMap() {
        return map;
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public List<Character> getHeroes() {
        return heroes;
    }

    public List<Direction> getHeroesPositions() {
        return heroesPositions;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    @Override
    public String toString() {
        return "GameInput{" +
                "numberOfLines=" + numberOfLines +
                ", numberOfColumns=" + numberOfColumns +
                ", map=" + Arrays.toString(map) +
                ", numberOfHeroes=" + numberOfHeroes +
                ", heroes=" + heroes +
                ", heroesPositions=" + heroesPositions +
                ", numberOfRounds=" + numberOfRounds +
                '}';
    }
}
