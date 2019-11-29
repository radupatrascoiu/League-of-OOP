package skills.WizardSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Drain implements Skill {
    private float baseDamage;
    private float percentage;
    private float percentagePerLevel;
    private Wizard wizard;

    public Drain(Wizard wizard, Hero opponentHero) {
        this.percentagePerLevel = Constants.DRAIN_PERCENTAGE_PER_LEVEL *
                wizard.getLevel();
        this.percentage = Constants.DRAIN_PERCENTAGE + this.percentagePerLevel;
        this.baseDamage = Math.min(Constants.DRAIN_PERCENTAGEE_FORMULA *
                        opponentHero.getMaxHp(), opponentHero.getHp());
        this.wizard = wizard;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        float levelLandDamage = this.percentage * this.baseDamage *
                this.wizard.getLandModifier();

        this.percentage *= Constants.DRAIN_VS_PYROMANCER_MODIFIER;
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage) * this.wizard.getLandModifier();
        int totalDamage = (int)this.baseDamage;
        System.out.println("Drain Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public void visit(Knight knight) {
        float levelLandDamage = this.percentage * this.baseDamage *
                this.wizard.getLandModifier();

        this.percentage *= Constants.DRAIN_VS_KNIGHT_MODIFIER;
        System.out.println("procent = " + this.percentage);
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage * this.wizard.getLandModifier());
        int totalDamage = (int)this.baseDamage;
        System.out.println("Drain Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public void visit(Wizard wizard) {
        float levelLandDamage = this.percentage * this.baseDamage *
                this.wizard.getLandModifier();

        this.percentage *= Constants.DRAIN_VS_WIZARD_MODIFIER;
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage * this.wizard.getLandModifier());
        int totalDamage = (int)this.baseDamage;
        System.out.println("Drain Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public void visit(Rogue rogue) {
        float levelLandDamage = this.percentage * this.baseDamage *
                this.wizard.getLandModifier();

        this.percentage *= Constants.DRAIN_VS_ROGUE_MODIFIER;
        // se calculeaza din nou, pentru race modifier
        this.baseDamage = Math.round(this.baseDamage * this.percentage * this.wizard.getLandModifier());
        int totalDamage = (int)this.baseDamage;
        System.out.println("Drain Damage total dat = " + totalDamage);
        this.wizard.getEffects().setLevelLandDamage(Math.round(this.wizard.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.wizard.getEffects().setTotalDamage(this.wizard.getEffects().
                getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.wizard);
    }

    @Override
    public String toString() {
        return "Drain";
    }
}
