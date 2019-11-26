package heroes;


import common.Constants;
import main.LocationHistory;
import skills.Skill;

public abstract class Hero {
    private int xp;
    private int level;
    private int hp;
    private LocationHistory locationHistory;

    public Hero(LocationHistory locationHistory) {
        this.xp = Constants.INITIAL_XP;
        this.level = Constants.INITIAL_LEVEL;
        this.locationHistory = locationHistory;
        this.hp = 0;
    }

    public abstract void play(); // fac actiunea specifica jucatorului; imi dau seama ce visitor sa apelez

    public LocationHistory getLocationHistory() {
        return locationHistory;
    }

    public void setLocationHistory(LocationHistory locationHistory) {
        this.locationHistory = locationHistory;
    }

    public void move(char moveChar) {
        if(moveChar == 'L') {
            locationHistory.setY(locationHistory.getY()-1);
        } else if(moveChar == 'R') {
            locationHistory.setY(locationHistory.getY()+1);
        } else if(moveChar == 'U') {
            locationHistory.setX(locationHistory.getX()-1);
        } else if(moveChar == 'D') {
            locationHistory.setX(locationHistory.getX()+1);
        }
    }

    public abstract float getLandModifier();

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxHp() {
        return 0;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamageWithoutRaceModifiers() {
        return 0;
    }

    public void levelUp() {
    }

    public void increaseXp(Hero hero) {
        // this.hero va fi eroul care va castiga batalia
        this.xp += Math.max(0, Constants.XP_FORMULA_1 -
                (this.xp - hero.getXp()) * Constants.XP_FORMULA_2_);
    }

    public abstract void accept(Skill skill);

    @Override
    public String toString() {
        return "Hero{" +
                "xp=" + xp +
                ", level=" + level +
                ", locationHistory=" + locationHistory +
                '}';
    }
}
