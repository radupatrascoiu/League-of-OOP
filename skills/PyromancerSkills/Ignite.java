package skills.PyromancerSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Ignite implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private int damageOvertime;
    private int damageOvertimePerLevel;
    private Pyromancer pyromancer;

    public Ignite(final Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
        this.baseDamagePerLevel = Constants.IGNITE_BASE_DAMAGE_PER_LEVEL
                * this.pyromancer.getLevel();
        this.baseDamage = Constants.IGNITE_BASE_DAMAGE
                + this.baseDamagePerLevel;

        this.damageOvertimePerLevel =
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL
                        * this.pyromancer.getLevel();
        this.damageOvertime = Constants.IGNITE_OVERTIME_DAMAGE
                + this.damageOvertimePerLevel;

    }

    /**
     * @param pyromancerToAttack
     */
    @Override
    public void visit(final Pyromancer pyromancerToAttack) {
        float levelLandDamage = this.baseDamage
                * this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.IGNITE_VS_PYROMANCER_MODIFIER);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        pyromancerToAttack.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel()
                * Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        pyromancerToAttack.getBuff().setTime(2);

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
                * Constants.IGNITE_VS_KNIGHT_MODIFIER);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        knight.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel()
                * Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        knight.getBuff().setTime(2);

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
                * Constants.IGNITE_VS_WIZARD_MODIFIER);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        wizard.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel()
                * Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        wizard.getBuff().setTime(2);

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
                * Constants.IGNITE_VS_ROGUE_MODIFIER);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        rogue.getBuff().setDamageOverTime(Math.round((Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel()
                * Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL)
                * Constants.IGNITE_VS_ROGUE_MODIFIER));
        rogue.getBuff().setTime(2);

        rogue.increaseDamage(totalDamage, this.pyromancer);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Ignite";
    }
}
