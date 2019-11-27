package skills.KnightSkills;


import common.Constants;
import heroes.*;
import skills.Skill;

public class Slam implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    private Knight knight;

    public Slam(Knight knight) {
        this.knight = knight;
        this.baseDamagePerLevel = Constants.SLAM_BASE_DAMAGE_PER_LEVEL *
                this.knight.getLevel();
        this.baseDamage = Constants.SLAM_BASE_DAMAGE +
                this.baseDamagePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public void stun(Hero hero) {
        //TODO
        //TODO
        //TODO
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_PYROMANCER_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_KNIGHT_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Wizard wizard) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_WIZARD_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
//        knight.increaseDamage(totalDamage);
        this.knight.getEffects().setLevelLandDamage(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage);
        System.out.println("Slam Damage fara Race = " + levelLandDamage);
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.knight);
    }

    @Override
    public void visit(Rogue rogue) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_ROGUE_MODIFIER);
    }

    @Override
    public String toString() {
        return "Slam";
    }
}
