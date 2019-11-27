package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.PyromancerSkills.Fireblast;
import skills.PyromancerSkills.Ignite;
import skills.Skill;
import skills.Effects;

public class Pyromancer extends Hero {

    private Fireblast fireblastAttack;
    private Ignite igniteAttack;

    public Pyromancer(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.PYROMANCER_HP;
        this.damageReceived = 0;
        this.priority = Constants.PYROMANCER_PRIORITY;
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
        if(this.getHp() <= 0 || hero.getHp() <= 0) {
            System.out.println("Este mort");
            return;
        }
        System.out.println("Pyromancer ataca...");
        this.fireblastAttack = new Fireblast(this);
        this.igniteAttack = new Ignite(this);
        hero.accept(this.fireblastAttack);
        hero.accept(this.igniteAttack);
    }


    @Override
    public void increaseDamage(int totalDmageReceived, Hero hero) {
        super.setAttacker(hero);
        this.damageReceived += totalDmageReceived;
        System.out.println("Pyromancer - daune suferite = " + this.damageReceived);

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
