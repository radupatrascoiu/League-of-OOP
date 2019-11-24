package com.heroes;

import com.common.Constants;
import com.main.LocationHistory;
import com.skills.Skill;

public abstract class Hero {
    private int xp;
    private int level;
    private LocationHistory locationHistory;

    public Hero(LocationHistory locationHistory) {
        this.xp = Constants.INITIAL_XP;
        this.xp = Constants.INITIAL_LEVEL;
        this.locationHistory = locationHistory;
    }

    public LocationHistory getLocationHistory() {
        return locationHistory;
    }

    public void setLocationHistory(LocationHistory locationHistory) {
        this.locationHistory = locationHistory;
    }

    public int getXp() {
        return xp;
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

    public void levelUp() {
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
