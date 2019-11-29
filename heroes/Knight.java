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
//        System.out.println("Knight accepta skillul " + skill);
        skill.visit(this);
    }

    /**
     * @param damageReceived
     * @param hero
     */
    @Override
    public void increaseDamage(final int damageReceived, final Hero hero) {
        super.setAttacker(hero);
        this.damageReceived += damageReceived;
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
