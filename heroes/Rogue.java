package heroes;

import common.Constants;
import heroes.Hero;
import main.LocationHistory;
import map.MapSingleton;
import skills.RogueSkills.Backstab;
import skills.RogueSkills.Paralysis;
import skills.Skill;

public class Rogue extends Hero {

    private int hp;
    private Backstab backstabAttack;
    private Paralysis paralysisAttack;

    public Rogue(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.ROGUE_HP;
    }

    @Override
    public int getDamageWithoutRaceModifiers() {
        return super.getDamageWithoutRaceModifiers();
        //TODO
        //TODO
        //TODO
    }

    @Override
    public void play() {
        //TODO
        //TODO
        //TODO

    }

    @Override
    public int getMaxHp() {
        return Constants.ROGUE_HP + Constants.ROGUE_HP_INCREASE_PER_LEVEL *
                super.getLevel();
    }

    @Override
    public int getHp() {
        return this.getHp();
    }

    @Override
    public void levelUp() {
        int xpLevelUp = Constants.XP + super.getLevel() * Constants.XP_MULTIPLICATOR;
        int futureLevel = super.getLevel();

        if(xpLevelUp >= Constants.XP_LEVEL_1) {
            futureLevel++;
            this.hp += Constants.ROGUE_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_2) {
            futureLevel++;
            this.hp += Constants.ROGUE_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_3) {
            futureLevel++;
            this.hp += Constants.ROGUE_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_4) {
            futureLevel++;
            this.hp += Constants.ROGUE_HP_INCREASE_PER_LEVEL;
        }

        super.setLevel(futureLevel);
    }

    @Override
    public float getLandModifier() {
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'W') {
            return Constants.WOODS_MODIFIER;
        }

        return 1;
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
