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
    //TODO HP LIMIT?????

    private Knight knight;

    public Execute(Knight knight) {
        this.knight = knight;
        this.baseDamagePerLevel = Constants.EXECUTE_BASE_DAMAGE_PER_LEVEL *
                this.knight.getLevel();
        this.baseDamage = Constants.EXECUTE_BASE_DAMAGE +
                this.baseDamagePerLevel;

    }
    
    @Override
    public void visit(Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_PYROMANCER_MODIFIER);
        System.out.println("Execute Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Knight knight) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_KNIGHT_MODIFIER);
        System.out.println("Execute Damage total dat = " + totalDamage);
//        knight.increaseDamage(totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Wizard wizard) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_WIZARD_MODIFIER);
        System.out.println("Execute Damage total dat = " + totalDamage);
//        knight.increaseDamage(totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        System.out.println("Execute Damage fara Race = " + levelLandDamage);
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.knight);
    }

    @Override
    public void visit(Rogue rogue) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_ROGUE_MODIFIER);
        System.out.println("Execute Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.knight);
    }

    @Override
    public String toString() {
        return "Execute";
    }
}
