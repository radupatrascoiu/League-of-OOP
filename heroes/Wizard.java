package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.Skill;
import skills.WizardSkills.Deflect;
import skills.WizardSkills.Drain;
import skills.Effects;

public class Wizard extends Hero {

    private Drain drainAttack;
    private Deflect deflectAttack;

    public Wizard(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.WIZARD_HP;
        this.priority = Constants.WIZARD_PRIORITY;
        this.damageReceived = 0;
    }

    @Override
    public int getMaxHp() {
        return Constants.WIZARD_HP + Constants.WIZARD_HP_INCREASE_PER_LEVEL *
                super.getLevel();
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void increaseDamage(int totalDamageReceived, Hero hero) {
        super.setAttacker(hero);
        this.damageReceived += totalDamageReceived;
        System.out.println("Wizard - daune suferite = " + this.damageReceived);
    }

    @Override
    public float getLandModifier() {
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'D') {
            return Constants.DESERT_MODIFIER;
        }

        return 1;
    }


    @Override
    public void play(Hero hero) {
        //TODO
        //TODO
        //TODO
        if(this.getHp() <= 0 || hero.getHp() <= 0) {
            System.out.println("Este mort");
            return;
        }
        System.out.println("Wizard ataca...");
        this.drainAttack = new Drain(this, hero);
        this.deflectAttack = new Deflect(this, hero);
        hero.accept(this.drainAttack);
        hero.accept(this.deflectAttack);

    }

    @Override
    public void accept(Skill skill) {
//        System.out.println("Wizard accepta skillul " + skill);
        skill.visit(this);
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }

    @Override
    public String displayRace() {
        return "W";
    }
}
