package heroes;


import angels.Angel;
import common.Constants;
import common.StrategyConstans;
import main.LocationHistory;
import map.MapSingleton;
import skills.Skill;
import skills.WizardSkills.Deflect;
import skills.WizardSkills.Drain;
import strategies.DefensiveStrategy;
import strategies.OffensiveStrategy;

import java.io.IOException;

public class Wizard extends Hero {

    private Drain drainAttack;
    private Deflect deflectAttack;

    public Wizard(final LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.WIZARD_HP;
        this.priority = Constants.WIZARD_PRIORITY;
        this.damageReceived = 0;
    }

    /**
     * @return
     */
    @Override
    public int getMaxHp() {
        return Constants.WIZARD_HP + Constants.WIZARD_HP_INCREASE_PER_LEVEL
                * super.getLevel();
    }

    /**
     * @return
     */
    @Override
    public int getHp() {
        return this.hp;
    }
    /**
     * @return
     */
    @Override
    public float getLandModifier() {
        if (MapSingleton.getInstance().getMap()[getLocationHistory().getX()]
                [getLocationHistory().getY()] == 'D') {
            return Constants.DESERT_MODIFIER;
        }

        return 1;
    }

    /**
     *
     */
    @Override
    public void applyStrategy() { // se alege strategia in functie de confitii
        if (this.hp > this.getMaxHp() / StrategyConstans.WIZARD_FORMULA_1
                && this.hp < this.getMaxHp() / StrategyConstans.WIZARD_FORMULA_2) {
            this.setStrategy(new OffensiveStrategy());
            this.strategy.execute(this, StrategyConstans.WIZARD_OFFENSIVE_HP,
                    StrategyConstans.WIZARD_OFFENSIVE_COEFFICIENTS);
        } else if (this.hp < this.getMaxHp() /  StrategyConstans.WIZARD_FORMULA_1) {
            this.setStrategy(new DefensiveStrategy());
            this.strategy.execute(this, StrategyConstans.WIZARD_DEFENSIVE_HP,
                    StrategyConstans.WIZARD_DEFENSIVE_COEFFICIENTS);
        }
    }

    /**
     * @param hero
     */
    @Override
    public void play(final Hero hero) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }

        this.drainAttack = new Drain(this, hero);
        this.deflectAttack = new Deflect(this, hero);
        hero.accept(this.drainAttack);
        hero.accept(this.deflectAttack);
    }

    /**
     * @param skill
     */
    @Override
    public void accept(final Skill skill) {
        skill.visit(this);
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
     * @return
     */
    @Override
    public String toString() {
        return "Wizard " + this.position;
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "W";
    }
}
