package skills.KnightSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Slam implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private Knight knight;

    public Slam(final Knight knight) {
        this.knight = knight;
        this.baseDamagePerLevel = Constants.SLAM_BASE_DAMAGE_PER_LEVEL
                * this.knight.getLevel();
        this.baseDamage = Constants.SLAM_BASE_DAMAGE
                + this.baseDamagePerLevel;

    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage
                * this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.SLAM_VS_PYROMANCER_MODIFIER);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects()
                .getTotalDamage() + totalDamage);

        pyromancer.getStun().setStun(true);
        pyromancer.getStun().setTime(1);

        pyromancer.increaseDamage(totalDamage, this.knight);

    }

    /**
     * @param knightToAttack
     */
    @Override
    public void visit(final Knight knightToAttack) {
        float levelLandDamage = this.baseDamage
                * this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.SLAM_VS_KNIGHT_MODIFIER);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                getTotalDamage() + totalDamage);

        knightToAttack.getStun().setStun(true);
        knightToAttack.getStun().setTime(1);

        knightToAttack.increaseDamage(totalDamage, this.knight);

    }

    /**
     * @param wizard
     */
    @Override
    public void visit(final Wizard wizard) {
        float levelLandDamage = this.baseDamage
                * this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.SLAM_VS_WIZARD_MODIFIER);

        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                getTotalDamage() + totalDamage);

        wizard.getStun().setStun(true);
        wizard.getStun().setTime(1);

        wizard.increaseDamage(totalDamage, this.knight);
    }

    /**
     * @param rogue
     */
    @Override
    public void visit(final Rogue rogue) {
        float levelLandDamage = this.baseDamage
                * this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage
                * Constants.SLAM_VS_ROGUE_MODIFIER);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                getTotalDamage() + totalDamage);

        rogue.getStun().setStun(true);
        rogue.getStun().setTime(1);

        rogue.increaseDamage(totalDamage, this.knight);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Slam";
    }
}
