package skills.KnightSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Slam implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;

    public Slam(Knight knight) {
        this.baseDamagePerLevel = Constants.SLAM_BASE_DAMAGE_PER_LEVEL *
                knight.getLevel();
        this.baseDamage = Constants.SLAM_BASE_DAMAGE +
                this.baseDamagePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public void stun(Hero hero) {
        //TODO
        //TODO
        //TODO
    }

    @Override
    public void visit(Pyromancer pyromancer) {

    }

    @Override
    public void visit(Knight knight) {

    }

    @Override
    public void visit(Wizard wizard) {

    }

    @Override
    public void visit(Rogue rogue) {

    }
}
