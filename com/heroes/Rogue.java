package com.heroes;

import com.common.Constants;
import com.main.LocationHistory;
import com.skills.Skill;

public class Rogue extends Hero {

    private int hp;

    public Rogue(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.ROGUE_HP;
    }

    @Override
    public void levelUp() {
        super.levelUp();
    }

    @Override
    public void accept(Skill skill) {

    }

    @Override
    public String toString() {
        return "Rogue{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }
}
