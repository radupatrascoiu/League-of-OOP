package skills;

public class Effects {
    private int levelLandDamage;
    private int criticalDamage;
    private int totalDamage;

    public Effects() {
        this.levelLandDamage = 0;
        this.totalDamage = 0;
        this.criticalDamage = 0;
    }

    public int getLevelLandDamage() {
        return levelLandDamage;
    }

    public void setLevelLandDamage(int levelLandDamage) {
        this.levelLandDamage = levelLandDamage;
    }

    public int getCriticalDamage() {
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
