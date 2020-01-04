package skills.WizardSkills;


import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Drain implements Skill {
    private float baseDamage;
    private float percentage;
    private float percentagePerLevel;
    private Wizard wizard;

    public Drain(final Wizard wizard, final Hero opponentHero) {
        this.percentagePerLevel = Constants.DRAIN_PERCENTAGE_PER_LEVEL
                * wizard.getLevel();
        this.percentage = Constants.DRAIN_PERCENTAGE + this.percentagePerLevel;
        this.baseDamage = Math.min(Constants.DRAIN_PERCENTAGEE_FORMULA
                * opponentHero.getMaxHp(), opponentHero.getHp());
        this.wizard = wizard;
    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        float levelLandDamage = this.percentage * this.baseDamage
                * this.wizard.getLandModifier();
        this.percentage *= (Constants.DRAIN_VS_PYROMANCER_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels());
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage)
                * this.wizard.getLandModifier();
        int totalDamage = (int) this.baseDamage;
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.wizard);
    }

    /**
     * @param knight
     */
    @Override
    public void visit(final Knight knight) {
        float levelLandDamage = this.percentage * this.baseDamage
                * this.wizard.getLandModifier();

        this.percentage *= (Constants.DRAIN_VS_KNIGHT_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels());
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage
                * this.wizard.getLandModifier());
        int totalDamage = (int) this.baseDamage;
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.wizard);
    }

    /**
     * @param wizardToAttack
     */
    @Override
    public void visit(final Wizard wizardToAttack) {
        float levelLandDamage = this.percentage * this.baseDamage
                * this.wizard.getLandModifier();

        this.percentage *= (Constants.DRAIN_VS_WIZARD_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels());
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage
                * this.wizard.getLandModifier());
        int totalDamage = (int) this.baseDamage;
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        wizardToAttack.increaseDamage(totalDamage, this.wizard);
    }

    /**
     * @param rogue
     */
    @Override
    public void visit(final Rogue rogue) {
        float levelLandDamage = this.percentage * this.baseDamage
                * this.wizard.getLandModifier();

        this.percentage *= (Constants.DRAIN_VS_ROGUE_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels());
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage
                * this.wizard.getLandModifier());
        int totalDamage = (int) this.baseDamage;
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.wizard);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Drain";
    }
}
