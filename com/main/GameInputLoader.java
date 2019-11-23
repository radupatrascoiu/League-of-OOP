package com.main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameInputLoader {
    private final String inputPath;
    private final String outputPath;

    public GameInputLoader(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public GameInput load() {

        int numberOfLines = 0;
        int numberOfColumns = 0;

        char[][] map = new char[100][];
        int numberOfHeroes = 0;
        int numberOfRounds = 0;
        List<Character> heroes = new ArrayList<>();
        List<Direction> heroesPositions = new ArrayList<>();

        try {
            FileSystem fileSystem = new FileSystem(inputPath, outputPath);

            numberOfLines = fileSystem.nextInt();
            numberOfColumns = fileSystem.nextInt();
            map = new char[numberOfLines][numberOfColumns];

            for(int i = 0; i < numberOfLines; ++i) {
                char[] auxArray = fileSystem.nextWord().toCharArray();
                for(int j = 0; j < numberOfColumns; ++j) {
                    map[i][j] = auxArray[j];
                }
            }

            numberOfHeroes = fileSystem.nextInt();

            for(int i = 0; i < numberOfHeroes; ++i) {

                char[] hero = fileSystem.nextWord().toCharArray();
                heroes.add(hero[0]); // adaug in lista de eroi

                Direction initialPosition = new Direction(fileSystem.nextInt(),fileSystem.nextInt());
                // pozitia initiala
                heroesPositions.add(initialPosition); // adaug pozitia initala in lista de pozitii
            }

            numberOfRounds = fileSystem.nextInt();

            for(int i = 0; i < numberOfRounds; ++i) {

                char[] movementsForHero = fileSystem.nextWord().toCharArray();
                for(int j = 0; j < numberOfHeroes; ++j) {
                    heroesPositions.get(j).getDirection().add(movementsForHero[j]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(numberOfLines, numberOfColumns, map, numberOfHeroes, heroes, heroesPositions, numberOfRounds);
    }
}