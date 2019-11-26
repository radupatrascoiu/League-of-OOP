package skills.WizardSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Deflect implements Skill {
    private float baseDamage;
    private float precentage;
    private float percentagePerLevel;

    public Deflect(Wizard wizard, Hero opponentHero) {
        this.percentagePerLevel = Constants.DEFLECT_PERCENTAGE_PER_LEVEL *
                wizard.getLevel();
        this.precentage = Constants.DEFLECT_PERCENTAGE +
                this.percentagePerLevel;
        this.baseDamage = Math.round(this.precentage *
                opponentHero.getDamageWithoutRaceModifiers());
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
        // nu face nimic pentru wizard
    }

    @Override
    public void visit(Rogue rogue) {

    }
}
