package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInput {

    private final char[][] map;
    private final char[][] moves;
    private int numberOfHeroes;
    private List<Character> heroes;
    private List<LocationHistory> locationHistories;
    private int numberOfRounds;
    private List<Integer> numberOfAngelPerRound = new ArrayList<>();
    private List<String> angels = new ArrayList<>();
    private List<LocationHistory> locationsAngels = new ArrayList<>();

    /**
     * @param map
     * @param numberOfHeroes
     * @param heroes
     * @param locationHistories
     * @param numberOfRounds
     * @param moves
     */
    public GameInput(final char[][] map, final int numberOfHeroes,
                     final List<Character> heroes,
                     final List<LocationHistory> locationHistories,
                     final int numberOfRounds, final char[][] moves,
                     final List<Integer> numberOfAngelPerRound, final List<String> angels,
                     final List<LocationHistory> locationsAngels) {
        this.map = map;
        this.numberOfHeroes = numberOfHeroes;
        this.heroes = heroes;
        this.locationHistories = locationHistories;
        this.numberOfRounds = numberOfRounds;
        this.moves = moves;
        this.numberOfAngelPerRound = numberOfAngelPerRound;
        this.angels = angels;
        this.locationsAngels = locationsAngels;
    }

    /**
     * @return
     */
    public char[][] getMap() {
        return map;
    }

    /**
     * @return
     */
    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    /**
     * @return
     */
    public List<Character> getHeroes() {
        return heroes;
    }

    /**
     * @return
     */
    public List<LocationHistory> getLocationHistories() {
        return locationHistories;
    }

    /**
     * @return
     */
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    /**
     * @return
     */
    public char[][] getMoves() {
        return moves;
    }

    /**
     * @return
     */
    public List<Integer> getNumberOfAngelPerRound() {
        return numberOfAngelPerRound;
    }

    /**
     * @return
     */
    public List<String> getAngels() {
        return angels;
    }

    /**
     * @return
     */
    public List<LocationHistory> getLocationsAngels() {
        return locationsAngels;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "GameInput{"
                + ", map=" + Arrays.toString(map)
                + ", moves=" + Arrays.toString(moves)
                + ", numberOfHeroes=" + numberOfHeroes
                + ", heroes=" + heroes
                + ", locationHistories=" + locationHistories
                + ", numberOfRounds=" + numberOfRounds
                + '}';
    }
}
