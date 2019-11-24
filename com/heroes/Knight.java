package com.heroes;

import com.common.Constants;
import com.main.LocationHistory;
import com.skills.Skill;

public class Knight extends Hero {

    private int hp;

    public Knight(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
    }

    @Override
    public void levelUp() {
        int xpLevelUp = Constants.XP + getLevel() * Constants.XP_MULTIPLICATOR;
        int futureLevel = getLevel();

        if(xpLevelUp >= Constants.XP_LEVEL_1) {
            futureLevel++;
            this.hp += 80;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_2) {
            futureLevel++;
            this.hp += 80;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_3) {
            futureLevel++;
            this.hp += 80;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_4) {
            futureLevel++;
            this.hp += 80;
        }
    }


    @Override
    public void accept(Skill skill) {

    }

    @Override
    public String toString() {
        return "Knight{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }
}
