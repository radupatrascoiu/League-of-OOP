package heroes;

import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.RogueSkills.Backstab;
import skills.RogueSkills.Paralysis;
import skills.Skill;
import skills.Effects;

public class Rogue extends Hero {

    private int hp;
    private Backstab backstabAttack;
    private Paralysis paralysisAttack;
    private int priority;
    private int damageReceived;


    public Rogue(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.ROGUE_HP;
        this.priority = Constants.ROGUE_PRIORITY;
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
    public void play(Hero hero) {
        //TODO
        //TODO
        //TODO

    }

    @Override
    public int getMaxHp() {
        return Constants.ROGUE_HP + Constants.ROGUE_HP_INCREASE_PER_LEVEL *
                super.getLevel();
    }

    @Override
    public int getHp() {
//        return this.getHp();
        //TODO
        //TODO
        //TODO
        //TODO

        return 0;
    }

    @Override
    public void increaseDamage(int damageReceived, Hero hero) {
//        this.getEffects().setTotalDamage(this.getEffects().getTotalDamage() + totalDamageReceived);
//        this.getEffects().setLevelLandDamage(this.getEffects().getLevelLandDamage() + levelLandDamageReceived);
        this.damageReceived += damageReceived;
        System.out.println("Rogue hp ramas = " + this.hp);
//        if(this.hp < 0) {
//            System.out.println("mort");
//            super.getAttacker().levelUp(this);
//        }
    }

    @Override
    public void calculateHp() {
        this.hp -= damageReceived;
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
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'W') {
            return Constants.WOODS_MODIFIER;
        }

        return 1;
    }

    @Override
    public void accept(Skill skill) {
        skill.visit(this);
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }

    @Override
    public String displayRace() {
        return "R";
    }
}
