package skills;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Stun {
    private boolean stun;
    private int time;

    public Stun(final boolean stun, final int time) {
        this.stun = stun;
        this.time = time;
    }

    /**
     * @return
     */
    public boolean isStun() {
        return stun;
    }

    /**
     * @param stun
     */
    public void setStun(final boolean stun) {
        this.stun = stun;
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
}
