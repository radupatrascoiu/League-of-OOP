package main;

import common.Constants;
import fileio.FileSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameInputLoader {
    private final String inputPath;
    private final String outputPath;

    public GameInputLoader(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    /**
     * @return
     */
    public GameInput load() {

        int numberOfLines = 0;
        int numberOfColumns = 0;

        char[][] map = new char[Constants.MATRIX_DIMENSION][];
        char[][] moves = new char[Constants.MATRIX_DIMENSION][];
        int numberOfHeroes = 0;
        int numberOfRounds = 0;
        List<Character> heroes = new ArrayList<>();
        List<LocationHistory> locationHistories = new ArrayList<>();
        List<Integer> numberOfAngelPerRound = new ArrayList<>();
        List<String> angels = new ArrayList<>();
        List<LocationHistory> locationsAngels = new ArrayList<>();

        try {
            FileSystem fileSystem = new FileSystem(inputPath, outputPath);


            numberOfLines = fileSystem.nextInt();
            numberOfColumns = fileSystem.nextInt();
            map = new char[numberOfLines][numberOfColumns];

            for (int i = 0; i < numberOfLines; ++i) {
                char[] auxArray = fileSystem.nextWord().toCharArray();
                for (int j = 0; j < numberOfColumns; ++j) {
                    map[i][j] = auxArray[j];
                }
            }

            numberOfHeroes = fileSystem.nextInt();

            for (int i = 0; i < numberOfHeroes; ++i) {

                char[] hero = fileSystem.nextWord().toCharArray();
                heroes.add(hero[0]); // adaug in lista de eroi

                // pozitia initiala
                LocationHistory initialPosition = new LocationHistory(
                        fileSystem.nextInt(), fileSystem.nextInt());
                // adaug pozitia initala in lista de pozitii
                locationHistories.add(initialPosition);
            }

            numberOfRounds = fileSystem.nextInt();
            moves = new char[numberOfRounds][numberOfHeroes];


            for (int i = 0; i < numberOfRounds; ++i) {
                char[] auxMoves = fileSystem.nextWord().toCharArray();
                for (int j = 0; j < numberOfHeroes; ++j) {
                    moves[i][j] = auxMoves[j];
                }
            }

            for (int i = 0; i < numberOfRounds; ++i) {
                int numberOfAngels = fileSystem.nextInt();
                numberOfAngelPerRound.add(numberOfAngels);
                if (numberOfAngels != 0) {
                    for (int j = 0; j < numberOfAngels; ++j) {
                        String angel = fileSystem.nextWord();
                        String[] aux = angel.split(",");
                        angels.add(aux[0]);
                        LocationHistory locationCurrentAngel = new LocationHistory(
                                Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
                        locationsAngels.add(locationCurrentAngel);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(map,
                numberOfHeroes, heroes, locationHistories,
                numberOfRounds, moves, numberOfAngelPerRound, angels, locationsAngels);
    }
}
