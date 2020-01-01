package heroes;


import angels.Angel;
import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.PyromancerSkills.Fireblast;
import skills.PyromancerSkills.Ignite;
import skills.Skill;

import java.io.IOException;

public class Pyromancer extends Hero {

    private Fireblast fireblastAttack;
    private Ignite igniteAttack;

    public Pyromancer(final LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.PYROMANCER_HP;
        this.damageReceived = 0;
        this.priority = Constants.PYROMANCER_PRIORITY;
    }


    /**
     * @return
     */
    @Override
    public int getMaxHp() {
        return Constants.PYROMANCER_HP
                + Constants.PYROMANCER_HP_INCREASE_PER_LEVEL * super.getLevel();
    }

    /**
     * @param hero
     */
    @Override
    public void play(final Hero hero) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }
        this.fireblastAttack = new Fireblast(this);
        this.igniteAttack = new Ignite(this);
        hero.accept(this.fireblastAttack);
        hero.accept(this.igniteAttack);
    }
    /**
     * @return
     */
    @Override
    public float getLandModifier() {
        if (MapSingleton.getInstance().getMap()[getLocationHistory().getX()]
                [getLocationHistory().getY()] == 'V') {
            return Constants.VOLCANIC_MODIFIER;
        }

        return 1f;
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
        return "Pyromancer " + this.position;
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "P";
    }
}
