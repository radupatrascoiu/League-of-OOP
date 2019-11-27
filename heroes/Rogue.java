package heroes;

import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.RogueSkills.Backstab;
import skills.RogueSkills.Paralysis;
import skills.Skill;
import skills.Effects;

public class Rogue extends Hero {

    private Backstab backstabAttack;
    private Paralysis paralysisAttack;

    public Rogue(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.ROGUE_HP;
        this.priority = Constants.ROGUE_PRIORITY;
        this.damageReceived = 0;
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
        System.out.println("Rogue ataca...");
        this.backstabAttack = new Backstab(this);
        this.paralysisAttack = new Paralysis(this);
        hero.accept(this.backstabAttack);
        hero.accept(this.paralysisAttack);

    }

    @Override
    public int getMaxHp() {
        return Constants.ROGUE_HP + Constants.ROGUE_HP_INCREASE_PER_LEVEL *
                super.getLevel();
    }


    @Override
    public void increaseDamage(int damageReceived, Hero hero) {
        super.setAttacker(hero);
        this.damageReceived += damageReceived;
        System.out.println("Rogue - daune suferite = " + this.damageReceived);
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
