package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.Skill;

public class Knight extends Hero {

    private int hp;
    private Execute executeAttack;
    private Slam slamAttack;
    private int damageReceived;

    public Knight(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
        this.damageReceived = 0;
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
    public void levelUp() {
        int xpLevelUp = Constants.XP + super.getLevel() * Constants.XP_MULTIPLICATOR;
        int futureLevel = super.getLevel();

        if(xpLevelUp >= Constants.XP_LEVEL_1) {
            futureLevel++;
            this.hp += Constants.KNIGHT_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_2) {
            futureLevel++;
            this.hp += Constants.KNIGHT_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_3) {
            futureLevel++;
            this.hp += Constants.KNIGHT_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_4) {
            futureLevel++;
            this.hp += Constants.KNIGHT_HP_INCREASE_PER_LEVEL;
        }

        super.setLevel(futureLevel);
    }

    @Override
    public float getLandModifier() {
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'L') {
            return Constants.LAND_MODIFIER;
        }

        return 1;
    }

    @Override
    public void play() {
        //TODO
        //TODO
        //TODO
//        System.out.println("Knight ataca");
        this.executeAttack = new Execute(this);
        this.slamAttack = new Slam(this);
        accept(this.executeAttack);
        accept(this.slamAttack);

    }

    // PLAY---> 2 INSTAINTE DE VISITOR, ADICA SKILLURILE LUI
    // apoi dau accept

    @Override
    public void accept(Skill skill) {
        System.out.println("Accept skillul " + skill);
        skill.visit(this);
    }


    @Override
    public void increaseDamage(int damageReceived) {
        this.damageReceived += damageReceived;
    }

    @Override
    public void calculateHp() {
        this.hp -= this.damageReceived;
        System.out.println("Hp ramas = " + this.hp);
    }

    @Override
    public void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
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
