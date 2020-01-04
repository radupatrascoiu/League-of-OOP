package main;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class GameInputWriter {
    private GameInputWriter() {
    }

    public static void write(final String file, final String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(content);

        writer.close();
    }
}
