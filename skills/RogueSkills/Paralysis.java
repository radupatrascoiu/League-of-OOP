package skills.RogueSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Paralysis implements Skill {
    private int baseDamage;
    private int baseDamegePerLevel;

    public Paralysis(Rogue rogue) {
        this.baseDamegePerLevel = Constants.PARALYSIS_BASE_DAMAGE_PER_LEVEL *
                rogue.getLevel();
        this.baseDamage = Constants.PARALYSIS_BASE_DAMAGE +
                this.baseDamegePerLevel;
        //TODO: STUN && OVERTIME
        //TODO
        //TODO
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamegePerLevel() {
        return baseDamegePerLevel;
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
