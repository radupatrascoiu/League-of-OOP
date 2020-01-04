package heroes;


import angels.Angel;
import common.Constants;
import common.StrategyConstans;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.Skill;
import strategies.DefensiveStrategy;
import strategies.OffensiveStrategy;

import java.io.IOException;

public class Knight extends Hero {

    private Execute executeAttack;
    private Slam slamAttack;

    public Knight(final LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
        this.priority = Constants.KNIGHT_PRIORITY;
        this.damageReceived = 0;
    }


    /**
     * @return
     */
    @Override
    public int getMaxHp() {
        return Constants.KNIGHT_HP + Constants.KNIGHT_HP_INCREASE_PER_LEVEL
                * super.getLevel();
    }

    /**
     * @return
     */
    // se obtine bunusul in functie de land
    @Override
    public float getLandModifier() {
        if (MapSingleton.getInstance().getMap()[getLocationHistory().getX()]
                [getLocationHistory().getY()] == 'L') {
            return Constants.LAND_MODIFIER;
        }

        return 1;
    }

    /**
     *
     */
    @Override
    public void applyStrategy() {
        if (this.hp > this.getMaxHp() / StrategyConstans.KNIGHT_FORMULA_1
                && this.hp < this.getMaxHp() / StrategyConstans.KNIGHT_FORMULA_2) {
            this.setStrategy(new OffensiveStrategy());
            this.strategy.execute(this, StrategyConstans.KNIGHT_OFFENSIVE_HP,
                    StrategyConstans.KNIGHT_OFFENSIVE_COEFFICIENTS);
        } else if (this.hp < this.getMaxHp() / StrategyConstans.KNIGHT_FORMULA_1) {
            this.setStrategy(new DefensiveStrategy());
            this.strategy.execute(this, StrategyConstans.KNIGHT_DEFENSIVE_HP,
                    StrategyConstans.KNIGHT_DEFENSIVE_COEFFICIENTS);
        }
    }

    /**
     * @param hero
     */
    // se apeleaza cele 2 atacuri pe eroul primit ca parametru
    @Override
    public void play(final Hero hero) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }

        this.executeAttack = new Execute(this);
        this.slamAttack = new Slam(this);
        hero.accept(this.executeAttack);
        hero.accept(this.slamAttack);
    }

    /**
     * @param angel
     * @throws IOException
     */
    @Override
    public void acceptAngel(final Angel angel) throws IOException {
        angel.visit(this);
    }

    /**
     * @param skill
     */
    @Override
    public void accept(final Skill skill) {
        skill.visit(this);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Knight " + this.getPosition();
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "K";
    }
}
