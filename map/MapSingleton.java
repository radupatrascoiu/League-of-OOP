package map;

public class MapSingleton {
    private static MapSingleton instace = null;
    private char[][] map;

    private MapSingleton() {}

    public void init(char[][] map) {
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    public static MapSingleton getInstance() {
        if(instace == null) {
            instace = new MapSingleton();
        }
        return instace;
    }
}
