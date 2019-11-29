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
    private Rogue rogue;

    public Paralysis(final Rogue rogue) {
        this.rogue = rogue;
        this.baseDamegePerLevel = Constants.PARALYSIS_BASE_DAMAGE_PER_LEVEL
                * rogue.getLevel();
        this.baseDamage = Constants.PARALYSIS_BASE_DAMAGE
                + this.baseDamegePerLevel;
    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.PARALYSIS_VS_PYROMANCER_MODIFIER);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);

        if (this.rogue.getLandModifier() == 'W') {
            pyromancer.getStun().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
            pyromancer.getBuff().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
        } else {
            pyromancer.getStun().setTime(Constants.PARALYSIS_OVERTIME);
            pyromancer.getBuff().setTime(Constants.PARALYSIS_OVERTIME);
        }

        pyromancer.getStun().setStun(true);
        pyromancer.getBuff().setDamageOverTime(totalDamage);

        pyromancer.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param knight
     */
    @Override
    public void visit(final Knight knight) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.PARALYSIS_VS_KNIGHT_MODIFIER);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);

        if (this.rogue.getLandModifier() == 'W') {
            knight.getStun().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
            knight.getBuff().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
        } else {
            knight.getStun().setTime(Constants.PARALYSIS_OVERTIME);
            knight.getBuff().setTime(Constants.PARALYSIS_OVERTIME);
        }

        knight.getStun().setStun(true);
        knight.getBuff().setDamageOverTime(totalDamage);

        knight.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param wizard
     */
    @Override
    public void visit(final Wizard wizard) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.PARALYSIS_VS_WIZARD_MODIFIER);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);

        if (this.rogue.getLandModifier() == 'W') {
            wizard.getStun().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
            wizard.getBuff().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
        } else {
            wizard.getStun().setTime(Constants.PARALYSIS_OVERTIME);
            wizard.getBuff().setTime(Constants.PARALYSIS_OVERTIME);
        }

        wizard.getStun().setStun(true);
        wizard.getBuff().setDamageOverTime(totalDamage);

        wizard.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param rogueToAttack
     */
    @Override
    public void visit(final Rogue rogueToAttack) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.PARALYSIS_VS_ROGUE_MODIFIER);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);

        if (this.rogue.getLandModifier() == 'W') {
            rogueToAttack.getStun().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
            rogueToAttack.getBuff().setTime(Constants.PARALYSIS_OVERTIME_WOODS);
        } else {
            rogueToAttack.getStun().setTime(Constants.PARALYSIS_OVERTIME);
            rogueToAttack.getBuff().setTime(Constants.PARALYSIS_OVERTIME);
        }

        rogueToAttack.getStun().setStun(true);
        rogueToAttack.getBuff().setDamageOverTime(totalDamage);

        rogueToAttack.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Paralysis";
    }
}
