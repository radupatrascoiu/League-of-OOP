package main;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameInputWriter {

    public static void write(String file, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(content);

        writer.close();
    }
}
