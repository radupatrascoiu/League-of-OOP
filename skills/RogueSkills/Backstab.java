package skills.RogueSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Backstab implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private int numberOfHits;

    public Backstab(Rogue rogue) {
        this.baseDamagePerLevel = Constants.BACKSTAB_BASE_DAMAGE_PER_LEVEL *
                rogue.getLevel();
        this.baseDamage = Constants.BACKSTAB_BASE_DAMAGE +
                this.baseDamagePerLevel;
        this.numberOfHits = 0;
        //TODO CRITICA
        //TODO
        //TODO
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public int getNumberOfHits() {
        return numberOfHits;
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
