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
    private Pyromancer pyromancer;

    public Fireblast(final Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
        this.baseDamagePerLevel = Constants.FIREBLAST_DAMAGE_PER_LEVER
                * this.pyromancer.getLevel();
        this.baseDamage = Constants.FIREBLAST_BASE_DAMAGE
                + this.baseDamagePerLevel;
    }

    /**
     * @param pyromancerToAttack
     */
    @Override
    public void visit(final Pyromancer pyromancerToAttack) {
        float levelLandDamage = this.baseDamage
                * this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * (Constants.FIREBLAST_VS_PYROMANCER_MODIFIER + pyromancer.getCoefficientsStrategy() +
                pyromancer.getCoefficientsAngels()));
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        pyromancerToAttack.increaseDamage(totalDamage, this.pyromancer);

    }

    /**
     * @param knight
     */
    @Override
    public void visit(final Knight knight) {
        float levelLandDamage = this.baseDamage
                * this.pyromancer.getLandModifier();

        int totalDamage = Math.round(levelLandDamage
                * (Constants.FIREBLAST_VS_KNIGHT_MODIFIER + pyromancer.getCoefficientsStrategy() +
                pyromancer.getCoefficientsAngels()));
        System.out.println("Fireblast total damage = " + totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.pyromancer);
    }

    /**
     * @param wizard
     */
    @Override
    public void visit(final Wizard wizard) {
        float levelLandDamage = this.baseDamage
                * this.pyromancer.getLandModifier();

        int totalDamage = Math.round(levelLandDamage
                * (Constants.FIREBLAST_VS_WIZARD_MODIFIER + pyromancer.getCoefficientsStrategy() +
                pyromancer.getCoefficientsAngels()));
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.pyromancer);

    }

    /**
     * @param rogue
     */
    @Override
    public void visit(final Rogue rogue) {
        float levelLandDamage = this.baseDamage
                * this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * (Constants.FIREBLAST_VS_ROGUE_MODIFIER + pyromancer.getCoefficientsStrategy() +
                pyromancer.getCoefficientsAngels()));
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.pyromancer);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Fireblast";
    }
}
