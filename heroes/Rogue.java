package heroes;

import angels.Angel;
import common.Constants;
import common.StrategyConstans;
import main.LocationHistory;
import map.MapSingleton;
import skills.RogueSkills.Backstab;
import skills.RogueSkills.Paralysis;
import skills.Skill;
import strategies.DefensiveStrategy;
import strategies.OffensiveStrategy;

import java.io.IOException;

public class Rogue extends Hero {

    private Backstab backstabAttack;
    private Paralysis paralysisAttack;

    public Rogue(final LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.ROGUE_HP;
        this.priority = Constants.ROGUE_PRIORITY;
        this.damageReceived = 0;
    }


    /**
     * @param hero
     */
    @Override
    public void play(final Hero hero) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }

        this.backstabAttack = new Backstab(this);
        this.paralysisAttack = new Paralysis(this);
        hero.accept(this.backstabAttack);
        hero.accept(this.paralysisAttack);
    }

    /**
     * @return
     */
    @Override
    public int getMaxHp() {
        return Constants.ROGUE_HP + Constants.ROGUE_HP_INCREASE_PER_LEVEL
                * super.getLevel();
    }
    /**
     * @return
     */
    @Override
    public float getLandModifier() {
        if (MapSingleton.getInstance().getMap()[getLocationHistory().getX()]
                [getLocationHistory().getY()] == 'W') {
            return Constants.WOODS_MODIFIER;
        }

        return 1;
    }

    @Override
    public void applyStrategy() {
        if(this.hp > this.getMaxHp()/7 && this.hp < this.getMaxHp()/5) {
            this.setStrategy(new OffensiveStrategy());
            this.strategy.execute(this, StrategyConstans.ROGUE_OFFENSIVE_HP, StrategyConstans.ROGUE_OFFENSIVE_COEFFICIENTS);
        } else if(this.hp < this.getMaxHp()/7) {
            this.setStrategy(new DefensiveStrategy());
            this.strategy.execute(this, StrategyConstans.ROGUE_DEFENSIVE_HP, StrategyConstans.ROGUE_DEFENSIVE_COEFFICIENTS);
        }
    }

    /**
     * @param skill
     */
    @Override
    public void accept(final Skill skill) {
        skill.visit(this);
    }

    @Override
    public void acceptAngel(Angel angel) throws IOException {
        angel.visit(this);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Rogue " + this.position;
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "R";
    }
}
