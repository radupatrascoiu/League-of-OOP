package skills;

import common.Constants;

public class Effects {
    private int levelLandDamage;
    private float criticalDamage;
    private int numberHits;
    private int totalDamage;

    public Effects() {
        this.levelLandDamage = 0;
        this.totalDamage = 0;
        this.criticalDamage = Constants.CRITICAL_DAMAGE;
        this.numberHits = 0;
    }

    /**
     * @return
     */
    public int getNumberHits() {
        return numberHits;
    }

    /**
     * @param numberHits
     */
    public void setNumberHits(final int numberHits) {
        this.numberHits = numberHits;
    }

    /**
     * @return
     */
    public int getLevelLandDamage() {
        return levelLandDamage;
    }

    /**
     * @param levelLandDamage
     */
    public void setLevelLandDamage(final int levelLandDamage) {
        this.levelLandDamage = levelLandDamage;
    }

    /**
     * @return
     */
    public float getCriticalDamage() {
        return criticalDamage;
    }

    /**
     * @param criticalDamage
     */
    public void setCriticalDamage(final int criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    /**
     * @return
     */
    public int getTotalDamage() {
        return totalDamage;
    }

    /**
     * @param totalDamage
     */
    public void setTotalDamage(final int totalDamage) {
        this.totalDamage = totalDamage;
    }
}
