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
    private Rogue rogue;
    private float criticalDamage;

    public Backstab(final Rogue rogue) {
        this.rogue = rogue;
        this.baseDamagePerLevel = Constants.BACKSTAB_BASE_DAMAGE_PER_LEVEL
                * rogue.getLevel();
        this.baseDamage = Constants.BACKSTAB_BASE_DAMAGE
                + this.baseDamagePerLevel;
        this.numberOfHits = 0;
        this.criticalDamage = 1;

    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();

        if (this.rogue.getLandModifier() != 1) {
            if (this.rogue.getEffects().getNumberHits()
                    % Constants.CRITICAL_DIVIDER == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage
                * Constants.BACKSTAB_VS_PYROMANCER_MODIFIER * criticalDamage);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param knight
     */
    @Override
    public void visit(final Knight knight) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        if (this.rogue.getLandModifier() != 1) {
            if (this.rogue.getEffects().getNumberHits()
                    % Constants.CRITICAL_DIVIDER == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage
                * Constants.BACKSTAB_VS_KNIGHT_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param wizard
     */
    @Override
    public void visit(final Wizard wizard) {
        System.out.println(this.baseDamage);

        if (this.rogue.getLandModifier() != 1) {
            if (this.rogue.getEffects().getNumberHits() % Constants.CRITICAL_DIVIDER == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier() * criticalDamage;

        int totalDamage = Math.round(levelLandDamage
                * Constants.BACKSTAB_VS_WIZARD_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @param rogueToAttack
     */
    @Override
    public void visit(final Rogue rogueToAttack) {
        float levelLandDamage = this.baseDamage
                * this.rogue.getLandModifier();
        if (this.rogue.getLandModifier() != 1) {
            if (this.rogue.getEffects().getNumberHits()
                    % Constants.CRITICAL_DIVIDER == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage
                * Constants.BACKSTAB_VS_ROGUE_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        this.rogue.getEffects().setLevelLandDamage(Math.round(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().
                getTotalDamage() + totalDamage);
        rogueToAttack.increaseDamage(totalDamage, this.rogue);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Backstab";
    }
}
