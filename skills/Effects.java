package skills;

public class Effects {
    private int levelLandDamage;
    private float criticalDamage;
    private int numberHits;
    private int totalDamage;

    public Effects() {
        this.levelLandDamage = 0;
        this.totalDamage = 0;
        this.criticalDamage = 1.5f;
        this.numberHits = 0;
    }

    public int getNumberHits() {
        return numberHits;
    }

    public void setNumberHits(int numberHits) {
        this.numberHits = numberHits;
    }

    public int getLevelLandDamage() {
        return levelLandDamage;
    }

    public void setLevelLandDamage(int levelLandDamage) {
        this.levelLandDamage = levelLandDamage;
    }

    public float getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(int criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }
}
