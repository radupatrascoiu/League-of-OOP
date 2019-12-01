package heroes;


import common.Constants;
import main.LocationHistory;
import map.MapSingleton;
import skills.KnightSkills.Execute;
import skills.KnightSkills.Slam;
import skills.Skill;

public class Knight extends Hero {

    private Execute executeAttack;
    private Slam slamAttack;

    public Knight(final LocationHistory locationHistory) {
        super(locationHistory);
        this.hp = Constants.KNIGHT_HP;
        this.priority = Constants.KNIGHT_PRIORITY;
        this.damageReceived = 0;
    }


    /**
     * @return
     */
    @Override
    public int getMaxHp() {
        return Constants.KNIGHT_HP + Constants.KNIGHT_HP_INCREASE_PER_LEVEL
                * super.getLevel();
    }

    /**
     * @return
     */
    // se obtine bunusul in functie de land
    @Override
    public float getLandModifier() {
        if (MapSingleton.getInstance().getMap()[getLocationHistory().getX()]
                [getLocationHistory().getY()] == 'L') {
            return Constants.LAND_MODIFIER;
        }

        return 1;
    }

    /**
     * @param hero
     */
    // se apeleaza cele 2 atacuri pe eroul primit ca parametru
    @Override
    public void play(final Hero hero) {
        if (this.getHp() <= 0 || hero.getHp() <= 0) {
            return;
        }
        this.executeAttack = new Execute(this);
        this.slamAttack = new Slam(this);
        hero.accept(this.executeAttack);
        hero.accept(this.slamAttack);
    }

    /**
     * @param skill
     */
    @Override
    public void accept(final Skill skill) {
        skill.visit(this);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Knight{"
                + "hp=" + hp
                + ", location: x = " + getLocationHistory().getX()
                + ", y = " + getLocationHistory().getY()
                + '}';
    }

    /**
     * @return
     */
    @Override
    public String displayRace() {
        return "K";
    }
}
