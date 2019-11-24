package com.heroes;

import com.common.Constants;
import com.main.LocationHistory;
import com.skills.Skill;

public class Pyromancer extends Hero{

    private int hp;

    public Pyromancer(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.PYROMANCER_HP;
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
        return "Pyromancer{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }
}
