package skills.WizardSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Drain implements Skill {
    private float baseDamage;
    private float precentage;
    private float percentagePerLevel;

    public Drain(Wizard wizard, Hero opponentHero) {
        this.percentagePerLevel = Constants.DRAIN_PERCENTAGE_PER_LEVEL *
                wizard.getLevel(); // ??????????
        this.precentage = Constants.DRAIN_PERCENTAGE + this.percentagePerLevel;
        this.baseDamage = this.precentage *
                Math.min(Constants.DRAIN_PERCENTAGEE_FORMULA *
                        opponentHero.getMaxHp(), opponentHero.getHp());
    }

    public float getBaseDamage() {
        return baseDamage;
    }

    public float getPrecentage() {
        return precentage;
    }

    public float getPercentagePerLevel() {
        return percentagePerLevel;
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
