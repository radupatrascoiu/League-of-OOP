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

    @Override
    public void visit(Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_PYROMANCER_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);

        pyromancer.getStun().setStun(true);
        pyromancer.getStun().setTime(1);

        pyromancer.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Knight knight) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_KNIGHT_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);

        knight.getStun().setStun(true);
        knight.getStun().setTime(1);

        knight.increaseDamage(totalDamage, this.knight);

    }

    @Override
    public void visit(Wizard wizard) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_WIZARD_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
//        knight.increaseDamage(totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        System.out.println("Slam Damage fara Race = " + levelLandDamage);
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);

        wizard.getStun().setStun(true);
        wizard.getStun().setTime(1);

        wizard.increaseDamage(totalDamage, this.knight);
    }

    @Override
    public void visit(Rogue rogue) {
        float levelLandDamage = this.baseDamage *
                this.knight.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.SLAM_VS_ROGUE_MODIFIER);
        System.out.println("Slam Damage total dat = " + totalDamage);
        this.knight.getEffects().setLevelLandDamage(Math.round(this.knight.getEffects().
                getLevelLandDamage() + levelLandDamage));
        this.knight.getEffects().setTotalDamage(this.knight.getEffects().getTotalDamage() + totalDamage);

        rogue.getStun().setStun(true);
        rogue.getStun().setTime(1);

        rogue.increaseDamage(totalDamage, this.knight);
    }

    @Override
    public String toString() {
        return "Slam";
    }
}
