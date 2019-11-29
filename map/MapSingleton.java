package map;

public final class MapSingleton {
    private static MapSingleton instace = null;
    private char[][] map;

    private MapSingleton() {
    }

    public void init(final char[][] mapGenerated) {
        this.map = mapGenerated;
    }

    public char[][] getMap() {
        return map;
    }

    public static MapSingleton getInstance() {
        if (instace == null) {
            instace = new MapSingleton();
        }
        return instace;
    }
}
