package heroes;

import angels.Angel;
import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.RogueSkills.Backstab;
import skills.RogueSkills.Paralysis;
import skills.Skill;

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
    public void play(final Hero hero, final Angel angel) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }
        this.backstabAttack = new Backstab(this);
        this.paralysisAttack = new Paralysis(this);
        hero.accept(this.backstabAttack);
        hero.accept(this.paralysisAttack);
        if(angel != null) {
            hero.acceptAngel(angel);
        }

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

    /**
     * @param skill
     */
    @Override
    public void accept(final Skill skill) {
        skill.visit(this);
    }

    @Override
    public void acceptAngel(Angel angel) {
        angel.visit(this);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Rogue{"
                + "hp=" + hp
                + ", location: x = " + getLocationHistory().getX()
                + ", y = " + getLocationHistory().getY()
                + '}';
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "R";
    }
}
