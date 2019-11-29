package skills.WizardSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Deflect implements Skill {
    private float baseDamage;
    private float percentage;
    private float percentagePerLevel;
    private Wizard wizard;

    public Deflect(Wizard wizard, Hero opponentHero) {
        this.wizard = wizard;
        this.percentagePerLevel = Math.round(Constants.DEFLECT_PERCENTAGE_PER_LEVEL *
                this.wizard.getLevel());
        this.percentage = Constants.DEFLECT_PERCENTAGE +
                this.percentagePerLevel;
        this.baseDamage = Math.round(this.percentage *
                opponentHero.getEffects().getLevelLandDamage());
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.wizard.getLandModifier());
//        System.out.println(this.baseDamage);
        int totalDamage = Math.round( levelLandDamage *
                Constants.DEFLECT_VS_PYROMANCER_MODIFIER);
        System.out.println("Deflect Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.wizard.getLandModifier());
//        System.out.println(this.baseDamage);
        int totalDamage = Math.round( levelLandDamage *
                Constants.DEFLECT_VS_KNIGHT_MODIFIER);
        System.out.println("Deflect Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.wizard);

    }

    @Override
    public void visit(Wizard wizard) {
        // nu face nimic pentru wizard
    }

    @Override
    public void visit(Rogue rogue) {
        float levelLandDamage = this.baseDamage *
                this.wizard.getLandModifier();
        System.out.println("AICI = " + levelLandDamage);
        int totalDamage = Math.round(levelLandDamage *
                Constants.DEFLECT_VS_ROGUE_MODIFIER);

        System.out.println("Deflect Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public String toString() {
        return "Deflect";
    }
}
