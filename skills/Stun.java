package skills;

public class Stun {
    private boolean stun;
    private int time;

    public Stun(boolean stun, int time) {
        this.stun = stun;
        this.time = time;
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
