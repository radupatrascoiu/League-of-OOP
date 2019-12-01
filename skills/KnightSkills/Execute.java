package skills.KnightSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Execute implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private float percentage;

    private Knight knight;

    public Execute(final Knight knight) {
        // se calculeaza damage-ul
        this.knight = knight;
        this.baseDamagePerLevel = Constants.EXECUTE_BASE_DAMAGE_PER_LEVEL
                * this.knight.getLevel();
        this.baseDamage = Constants.EXECUTE_BASE_DAMAGE
                + this.baseDamagePerLevel;
        this.percentage = Constants.PERCENTAGE_OF_HP_EXECUTE
                + this.knight.getLevel()
                        * Constants.PERCENTAGE_OF_HP_EXECUTE_PER_LEVEL;

    }

    /**
     * @param pyromancer
     */
    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() < this.percentage * pyromancer.getMaxHp()) {

            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + pyromancer.getHp()));
            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + pyromancer.getHp());
            pyromancer.increaseDamage(pyromancer.getHp(), this.knight);
        } else {
            float levelLandDamage = this.baseDamage
                   * this.knight.getLandModifier();
            int totalDamage = Math.round(levelLandDamage
                    * Constants.EXECUTE_VS_PYROMANCER_MODIFIER);
            // se seteaza damage-ul dat
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.
                    getEffects().getLevelLandDamage() + levelLandDamage));
            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + totalDamage);
            // se mareste damage-ul primit
            pyromancer.increaseDamage(totalDamage, this.knight);
        }
    }

    /**
     * @param knightToAttack
     */
    @Override
    public void visit(final Knight knightToAttack) {
        if (knightToAttack.getHp() < this.percentage * knightToAttack.getMaxHp()) {
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + knightToAttack.getHp()));

            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + knightToAttack.getHp());
            knightToAttack.increaseDamage(knightToAttack.getHp(), this.knight);
        } else {
            float levelLandDamage = this.baseDamage
                    * this.knight.getLandModifier();
            int totalDamage = Math.round(levelLandDamage
                    * Constants.EXECUTE_VS_KNIGHT_MODIFIER);
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.
                    getEffects().
                    getLevelLandDamage() + levelLandDamage));
            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + totalDamage);
            knightToAttack.increaseDamage(totalDamage, this.knight);
        }

    }

    /**
     * @param wizard
     */
    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHp() < this.percentage * wizard.getMaxHp()) {
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + wizard.getHp()));

            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + wizard.getHp());
            wizard.increaseDamage(wizard.getHp(), this.knight);
        } else {
            float levelLandDamage = this.baseDamage
                    * this.knight.getLandModifier();
            int totalDamage = Math.round(levelLandDamage
                    * Constants.EXECUTE_VS_WIZARD_MODIFIER);
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + levelLandDamage));
            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + totalDamage);
            wizard.increaseDamage(totalDamage, this.knight);
        }
    }

    /**
     * @param rogue
     */
    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHp() < this.percentage * rogue.getMaxHp()) {
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + rogue.getHp()));

            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + rogue.getHp());
            rogue.increaseDamage(rogue.getHp(), this.knight);
        } else {
            float levelLandDamage = this.baseDamage
                    * this.knight.getLandModifier();
            int totalDamage = Math.round(levelLandDamage
                    * Constants.EXECUTE_VS_ROGUE_MODIFIER);
            this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                    getLevelLandDamage() + levelLandDamage));
            this.knight.getEffects().setTotalDamage(this.knight.getEffects().
                    getTotalDamage() + totalDamage);
            rogue.increaseDamage(totalDamage, this.knight);
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Execute";
    }
}
