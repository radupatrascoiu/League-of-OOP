package skills;

public class Buff {
    private int damageOverTime;
    private int time;

    public Buff() {
        this.damageOverTime = 0;
        this.time = 0;
    }

    /**
     * @return
     */
    public int getDamageOverTime() {
        return damageOverTime;
    }

    /**
     * @param damageOverTime
     */
    public void setDamageOverTime(final int damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    /**
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(final int time) {
        this.time = time;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Buff{"
                + "damageOverTime=" + damageOverTime
                + ", time=" + time
                + '}';
    }
}
