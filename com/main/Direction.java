package com.main;

import java.util.ArrayList;
import java.util.List;

public class Direction {
    private int x;
    private int y;
    private List<Character> direction;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
        direction = new ArrayList<>();
    }

    public List<Character> getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}