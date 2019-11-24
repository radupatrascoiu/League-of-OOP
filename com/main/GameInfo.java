package com.main;


import com.map.MapSingleton;

public class GameInfo {

    private static GameInfo instace = null;
    private char[][] map;
    private char[][] moves;


    private GameInfo() {}

    public void init(GameInputLoader gameInputLoader) {
        GameInput gameInput = gameInputLoader.load();
        MapSingleton map = MapSingleton.getInstance();
        this.moves = gameInput.getMoves();
        this.map = map.getMap();
    }

    public char[][] getMap() {
        return map;
    }

    public static GameInfo getInstance() {
        if(instace == null) {
            instace = new GameInfo();
        }
        return instace;
    }

    public char[][] getMoves() {
        return moves;
    }
}
