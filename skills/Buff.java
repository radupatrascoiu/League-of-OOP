package skills;

public class Buff {
    private int damageOverTime;
    private int time;

    public Buff() {
        this.damageOverTime = 0;
        this.time = 0;
    }

    public int getDamageOverTime() {
        return damageOverTime;
    }

    public void setDamageOverTime(int damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
