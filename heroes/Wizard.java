package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.Skill;
import skills.WizardSkills.Deflect;
import skills.WizardSkills.Drain;
import skills.Effects;

public class Wizard extends Hero {

    private int hp;
    private Drain drainAttack;
    private Deflect deflectAttack;
    private int priority;
    private int damageReceived;


    public Wizard(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.WIZARD_HP;
        this.priority = Constants.WIZARD_PRIORITY;
        this.damageReceived = 0;
    }

    @Override
    public int getDamageReceived() {
        return damageReceived;
    }

    @Override
    public void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
    }

    @Override
    public Effects getEffects() {
        return super.getEffects();
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int getDamageWithoutRaceModifiers() {
        return super.getDamageWithoutRaceModifiers();
        //TODO
        //TODO
        //TODO
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
//        System.out.println("Vechiul " + this.getEffects().getLevelLandDamage());
//        this.getEffects().setTotalDamage(this.getEffects().getTotalDamage() + totalDamageReceived);
//        this.getEffects().setLevelLandDamage(this.getEffects().getLevelLandDamage() + levelLandDamageReceived);
//        System.out.println("Noul " + this.getEffects().getLevelLandDamage());
        super.setAttacker(hero);
        this.damageReceived += totalDamageReceived;
        System.out.println("Wizard - daune suferite = " + this.damageReceived);
    }

    @Override
    public void calculateHp() {
        this.hp -= damageReceived;
        System.out.println("Wizard hp ramas = " + this.hp);
        if(this.hp < 0) {
            System.out.println("mort");
            super.getAttacker().levelUp(this);
        }
    }


    @Override
    public void levelUp(Hero loser) {
        super.increaseXp(loser);
        System.out.println(this.getXp());

//        int xpLevelUp = Constants.XP + super.getLevel() * Constants.XP_MULTIPLICATOR;
        int xpLevelUp = this.getXp() + super.getLevel() * Constants.XP_MULTIPLICATOR;

        if(this.getXp() >= Constants.XP_LEVEL_1) {
            setLevel(1);
            this.hp = this.getMaxHp();

        }

        if(this.getXp() >= Constants.XP_LEVEL_2) {
            setLevel(2);
            this.hp = this.getMaxHp();

        }

        if(this.getXp() >= Constants.XP_LEVEL_3) {
            setLevel(3);
            this.hp = this.getMaxHp();

        }

        if(this.getXp() >= Constants.XP_LEVEL_4) {
            setLevel(4);
            this.hp = this.getMaxHp();
        }

        System.out.println("level actual = " + getLevel());
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
