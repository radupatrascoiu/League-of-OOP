package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.Skill;
import skills.Effects;

public class Knight extends Hero {

    private int hp;
    private Execute executeAttack;
    private Slam slamAttack;
    private int priority;
    private int damageReceived;

    public Knight(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
        this.priority = Constants.KNIGHT_PRIORITY;
        this.damageReceived = 0;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public Effects getEffects() {
        return super.getEffects();
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
        return Constants.KNIGHT_HP + Constants.KNIGHT_HP_INCREASE_PER_LEVEL
                * super.getLevel();
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void levelUp(Hero loser) {
        super.increaseXp(loser);
        System.out.println(this.getXp());

//        int xpLevelUp = Constants.XP + super.getLevel() * Constants.XP_MULTIPLICATOR;
        int xpLevelUp = this.getXp() + super.getLevel() * Constants.XP_MULTIPLICATOR;
        System.out.println("da" + xpLevelUp);

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
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'L') {
            return Constants.LAND_MODIFIER;
        }

        return 1;
    }

    @Override
    public void play(Hero hero) {
        //TODO
        //TODO
        //TODO
        System.out.println("Knight ataca...");
        this.executeAttack = new Execute(this);
        this.slamAttack = new Slam(this);
        hero.accept(this.executeAttack);
        hero.accept(this.slamAttack);

    }

    @Override
    public void accept(Skill skill) {
//        System.out.println("Knight accepta skillul " + skill);
        skill.visit(this);
    }

    @Override
    public void increaseDamage(int damageReceived, Hero hero) {
//        this.damageReceived += damageReceived;
//        System.out.println("Damage Knight total vechi = " + this.getEffects().getTotalDamage());
//        this.getEffects().setTotalDamage(this.getEffects().getTotalDamage() + totalDamageReceived);
//        this.getEffects().setLevelLandDamage(this.getEffects().getLevelLandDamage() + levelLandDamageReceived);
        this.damageReceived += damageReceived;
//        System.out.println("Damage Knight total nou = " + this.getEffects().getTotalDamage());

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
    public void calculateHp() {
        this.hp -= damageReceived;
//        if(this.hp < 0) {
//            System.out.println("mort");
//            super.getAttacker().levelUp(this);
//        }
    }

    @Override
    public String toString() {
        return "Knight{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }

    @Override
    public String displayRace() {
        return "K";
    }
}
