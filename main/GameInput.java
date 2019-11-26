package main;

import main.LocationHistory;

import java.util.Arrays;
import java.util.List;

public class GameInput {

    private int numberOfLines = 0;
    private int numberOfColumns = 0;
    private final char[][] map;
    private final char[][] moves;
    private int numberOfHeroes;
    private List<Character> heroes;
    private List<LocationHistory> locationHistories;
    private int numberOfRounds;

    public GameInput(int numberOfLines, int numberOfColumns, char[][] map, int numberOfHeroes, List<Character> heroes, List<LocationHistory> locationHistories, int numberOfRounds, char[][] moves) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
        this.numberOfHeroes = numberOfHeroes;
        this.heroes = heroes;
        this.locationHistories = locationHistories;
        this.numberOfRounds = numberOfRounds;
        this.moves = moves;
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

    public List<LocationHistory> getLocationHistories() {
        return locationHistories;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public char[][] getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "GameInput{" +
                "numberOfLines=" + numberOfLines +
                ", numberOfColumns=" + numberOfColumns +
                ", map=" + Arrays.toString(map) +
                ", moves=" + Arrays.toString(moves) +
                ", numberOfHeroes=" + numberOfHeroes +
                ", heroes=" + heroes +
                ", locationHistories=" + locationHistories +
                ", numberOfRounds=" + numberOfRounds +
                '}';
    }
}
