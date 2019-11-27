package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.PyromancerSkills.Fireblast;
import skills.PyromancerSkills.Ignite;
import skills.Skill;
import skills.Effects;

public class Pyromancer extends Hero {

    private int hp;
    private Fireblast fireblastAttack;
    private Ignite igniteAttack;
    private int damageReceived;
    private int priority;

    public Pyromancer(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.PYROMANCER_HP;
        this.damageReceived = 0;
        this.priority = Constants.PYROMANCER_PRIORITY;
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
        return Constants.PYROMANCER_HP +
                Constants.PYROMANCER_HP_INCREASE_PER_LEVEL * super.getLevel();
    }

    @Override
    public void play(Hero hero) {
        //TODO
        //TODO
        //TODO
        System.out.println("Pyromancer ataca...");
        this.fireblastAttack = new Fireblast(this);
        this.igniteAttack = new Ignite(this);
        hero.accept(this.fireblastAttack);
        hero.accept(this.igniteAttack);
    }




    @Override
    public void increaseDamage(int totalDmageReceived, Hero hero) { // trebuie sa retin cat damage da
//        System.out.println("Damage Pyromancer total vechi = " + this.getEffects().getTotalDamage());
//        this.getEffects().setTotalDamage(this.getEffects().getTotalDamage() + totalDamageReceived);
//        this.getEffects().setLevelLandDamage(this.getEffects().getLevelLandDamage() + levelLandDamageReceived);
//        System.out.println("Damage Pyromancer total nou = " + this.getEffects().getTotalDamage());
        this.damageReceived += totalDmageReceived;
        System.out.println("Pyromancer - daune suferite = " + this.damageReceived);

    }

    @Override
    public void calculateHp() {
        this.hp -= damageReceived;
//        System.out.println("Damage total primit de Pyromancer este = " + this.getEffects().getTotalDamage());
        System.out.println("Pyromancer hp ramas = " + this.hp);
//        if(this.hp < 0) {
//            System.out.println("mort");
//            super.getAttacker().levelUp(this);
//        }
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void levelUp(Hero loser) { // ??????????????

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
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'V') {
            return Constants.VOLCANIC_MODIFIER;
        }

        return 1f;
    }

    @Override
    public void accept(Skill skill) {
//        System.out.println("Pyromancer accepta skillul " + skill);
        skill.visit(this);
    }

    @Override
    public String toString() {
        return "Pyromancer{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }

    @Override
    public String displayRace() {
        return "P";
    }
}
