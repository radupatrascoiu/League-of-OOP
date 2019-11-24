package com.heroes;

import com.common.Constants;
import com.main.LocationHistory;
import com.skills.Skill;

public class Wizard extends Hero {

    private int hp;

    public Wizard(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.WIZARD_HP;
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
        return "Wizard{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }
}
