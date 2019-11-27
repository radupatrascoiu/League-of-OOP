package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.Skill;
import skills.Effects;

public class Knight extends Hero {

    private Execute executeAttack;
    private Slam slamAttack;

    public Knight(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
        this.priority = Constants.KNIGHT_PRIORITY;
        this.damageReceived = 0;
    }


    @Override
    public int getMaxHp() {
        return Constants.KNIGHT_HP + Constants.KNIGHT_HP_INCREASE_PER_LEVEL
                * super.getLevel();
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
        if(this.getHp() <= 0 || hero.getHp() <= 0) {
            System.out.println("Este mort");
            return;
        }
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
        super.setAttacker(hero);
        this.damageReceived += damageReceived;
        System.out.println("Knight - daune suferite = " + this.damageReceived);

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
