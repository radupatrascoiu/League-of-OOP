package skills.PyromancerSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Fireblast implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;

    public Fireblast(Pyromancer pyromancer) {
        this.baseDamagePerLevel = Constants.FIREBLAST_DAMAGE_PER_LEVER *
                pyromancer.getLevel();
        this.baseDamage = Constants.FIREBLAST_BASE_DAMAGE +
                this.baseDamagePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
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
