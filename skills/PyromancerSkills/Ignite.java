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

    public Ignite(Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
        this.baseDamagePerLevel = Constants.IGNITE_BASE_DAMAGE_PER_LEVEL *
                this.pyromancer.getLevel();
        this.baseDamage = Constants.IGNITE_BASE_DAMAGE +
                this.baseDamagePerLevel;

        //TODO ?????? overtime-ul

        this.damageOvertimePerLevel =
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL *
                        this.pyromancer.getLevel();
        this.damageOvertime = Constants.IGNITE_OVERTIME_DAMAGE +
                this.damageOvertimePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public int getDamageOvertime() {
        return damageOvertime;
    }

    public int getDamageOvertimePerLevel() {
        return damageOvertimePerLevel;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.pyromancer.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.IGNITE_VS_PYROMANCER_MODIFIER);
        System.out.println("Fireblast Damage total dat = " + totalDamage);
//        pyromancer.increaseDamage(totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage);
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        pyromancer.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel() *
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        pyromancer.getBuff().setTime(2);

        pyromancer.increaseDamage(totalDamage, this.pyromancer);
    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.pyromancer.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.IGNITE_VS_KNIGHT_MODIFIER);
        System.out.println("Ignite Damage total dat = " + totalDamage);
//        knight.increaseDamage(totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage);
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        knight.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel() *
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        knight.getBuff().setTime(2);

        knight.increaseDamage(totalDamage, this.pyromancer);

    }

    @Override
    public void visit(Wizard wizard) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.pyromancer.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.IGNITE_VS_WIZARD_MODIFIER);
        System.out.println("Ignite Damage total dat = " + totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage);
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        System.out.println("damage fara race: " + levelLandDamage);

        wizard.getBuff().setDamageOverTime(Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel() *
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL);
        wizard.getBuff().setTime(2);

        wizard.increaseDamage(totalDamage, this.pyromancer);

    }

    @Override
    public void visit(Rogue rogue) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.pyromancer.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.IGNITE_VS_ROGUE_MODIFIER);
        System.out.println("Ignite Damage total dat = " + totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage);
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);

        rogue.getBuff().setDamageOverTime(Math.round( (Constants.IGNITE_OVERTIME_DAMAGE
                + this.pyromancer.getLevel() *
                Constants.IGNITE_OVERTIME_DAMAGE_PER_LEVEL) * Constants.IGNITE_VS_ROGUE_MODIFIER));
        rogue.getBuff().setTime(2);

        rogue.increaseDamage(totalDamage, this.pyromancer);
    }

    @Override
    public String toString() {
        return "Ignite";
    }
}
