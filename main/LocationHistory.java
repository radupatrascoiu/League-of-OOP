package main;

public class LocationHistory {
    private int x;
    private int y;

    public LocationHistory(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "LocationHistory{"
               + "x=" + x
               + ", y=" + y
               + '}';
    }
}
