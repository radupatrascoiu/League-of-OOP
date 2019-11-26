package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.PyromancerSkills.Fireblast;
import skills.PyromancerSkills.Ignite;
import skills.Skill;

public class Pyromancer extends Hero {

    private int hp;
    private Fireblast fireblastAttack;
    private Ignite igniteAttack;

    public Pyromancer(LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.PYROMANCER_HP;
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
    public void play() {
        //TODO
        //TODO
        //TODO

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
            this.hp += Constants.PYROMANCER_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_2) {
            futureLevel++;
            this.hp += Constants.PYROMANCER_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_3) {
            futureLevel++;
            this.hp += Constants.PYROMANCER_HP_INCREASE_PER_LEVEL;
        }

        if(xpLevelUp >= Constants.XP_LEVEL_4) {
            futureLevel++;
            this.hp += Constants.PYROMANCER_HP_INCREASE_PER_LEVEL;
        }

        super.setLevel(futureLevel);
    }

    @Override
    public float getLandModifier() {
        if(MapSingleton.getInstance().getMap()[getLocationHistory().getX()][getLocationHistory().getY()] == 'V') {
            return Constants.VOLCANIC_MODIFIER;
        }

        return 1;
    }

    @Override
    public void accept(Skill skill) {

    }

    @Override
    public String toString() {
        return "Pyromancer{" +
                "hp=" + hp +
                ", location: x = " + getLocationHistory().getX() +
                ", y = " + getLocationHistory().getY() +
                '}';
    }
}
