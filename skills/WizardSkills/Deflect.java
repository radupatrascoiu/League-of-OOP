package skills.WizardSkills;


import common.Constants;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Deflect implements Skill {
    private float baseDamage;
    private float percentage;
    private float percentagePerLevel;
    private Wizard wizard;

    public Deflect(final Wizard wizard, final Hero opponentHero) {
        this.wizard = wizard;
        this.percentagePerLevel = Math.round(Constants.
                DEFLECT_PERCENTAGE_PER_LEVEL * this.wizard.getLevel());
        this.percentage = Constants.DEFLECT_PERCENTAGE
                + this.percentagePerLevel;
        this.baseDamage = Math.round(this.percentage
                * opponentHero.getEffects().getLevelLandDamage());
    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage
                * this.wizard.getLandModifier());
        int totalDamage = Math.round(levelLandDamage
                * (Constants.DEFLECT_VS_PYROMANCER_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels()));
        this.wizard.getEffects().setLevelLandDamage(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.wizard);
    }

    /**
     * @param knight
     */
    @Override
    public void visit(final Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage
                * this.wizard.getLandModifier());
        int totalDamage = Math.round(levelLandDamage
                * (Constants.DEFLECT_VS_KNIGHT_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels()));
        System.out.println(wizard.getCoefficientsStrategy());
        this.wizard.getEffects().setLevelLandDamage(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.wizard);

    }

    /**
     * @param wizardToAttack
     */
    @Override
    public void visit(final Wizard wizardToAttack) {
        // nu face nimic pentru wizard
    }

    /**
     * @param rogue
     */
    @Override
    public void visit(final Rogue rogue) {
        float levelLandDamage = this.baseDamage
                * this.wizard.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * (Constants.DEFLECT_VS_ROGUE_MODIFIER + wizard.getCoefficientsStrategy() +
                wizard.getCoefficientsAngels()));

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
        return "Deflect";
    }
}
