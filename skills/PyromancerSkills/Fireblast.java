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

    public Fireblast(Pyromancer pyromancer) {
        this.pyromancer = pyromancer;
        this.baseDamagePerLevel = Constants.FIREBLAST_DAMAGE_PER_LEVER *
                this.pyromancer.getLevel();
        this.baseDamage = Constants.FIREBLAST_BASE_DAMAGE +
                this.baseDamagePerLevel;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        float levelLandDamage = this.baseDamage *
                this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.FIREBLAST_VS_PYROMANCER_MODIFIER);
        System.out.println("Fireblast Damage total dat = " + totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.pyromancer);

    }

    @Override
    public void visit(Knight knight) {
        float levelLandDamage = this.baseDamage *
                this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.FIREBLAST_VS_KNIGHT_MODIFIER);
        System.out.println("Fireblast Damage total dat = " + totalDamage);
        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.pyromancer);
    }

    @Override
    public void visit(Wizard wizard) {
        float levelLandDamage = this.baseDamage *
                this.pyromancer.getLandModifier();

        int totalDamage = Math.round(levelLandDamage *
                Constants.FIREBLAST_VS_WIZARD_MODIFIER);
        System.out.println("Fireblast Damage total dat = " + totalDamage);

        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        System.out.println("damage fara race: " + levelLandDamage);
        wizard.increaseDamage(totalDamage, this.pyromancer);

    }

    @Override
    public void visit(Rogue rogue) {
        float levelLandDamage = this.baseDamage *
                this.pyromancer.getLandModifier();
        int totalDamage = Math.round(levelLandDamage *
                Constants.FIREBLAST_VS_ROGUE_MODIFIER);
        System.out.println("Fireblast Damage total dat = " + totalDamage);

        this.pyromancer.getEffects().setLevelLandDamage(Math.round(this.pyromancer.
                getEffects().getLevelLandDamage() + levelLandDamage));
        this.pyromancer.getEffects().setTotalDamage(this.pyromancer.
                getEffects().getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.pyromancer);

    }

    @Override
    public String toString() {
        return "Fireblast";
    }
}
