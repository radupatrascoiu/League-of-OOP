package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.Skill;
import skills.WizardSkills.Deflect;
import skills.WizardSkills.Drain;

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
     * @param totalDamageReceived
     * @param hero
     */
    @Override
    public void increaseDamage(final int totalDamageReceived, final Hero hero) {
        super.setAttacker(hero);
        this.damageReceived += totalDamageReceived;
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
     * @return
     */
    @Override
    public String toString() {
        return "Wizard{"
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
        return "W";
    }
}
