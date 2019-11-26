package skills.PyromancerSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Ignite implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private int damageOvertime;
    private int damageOvertimePerLevel;

    public Ignite(Pyromancer pyromancer) {
        this.baseDamagePerLevel = Constants.IGNITE_BASE_DAMAGE_PER_LEVEL *
                pyromancer.getLevel();
        this.baseDamage = Constants.IGNITE_BASE_DAMAGE +
                this.baseDamagePerLevel;

        //TODO ?????? overtime-ul

        this.damageOvertimePerLevel =
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL *
                        pyromancer.getLevel();
        this.damageOvertime = Constants.IGNITE_OVERTIME_DAMAGE +
                this.damageOvertimePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public int getDamageOvertime() {
        return damageOvertime;
    }

    public int getDamageOvertimePerLevel() {
        return damageOvertimePerLevel;
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
