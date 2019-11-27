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

    public Backstab(Rogue rogue) {
        this.rogue = rogue;
        this.baseDamagePerLevel = Constants.BACKSTAB_BASE_DAMAGE_PER_LEVEL *
                rogue.getLevel();
        this.baseDamage = Constants.BACKSTAB_BASE_DAMAGE +
                this.baseDamagePerLevel;
        this.numberOfHits = 0;
        this.criticalDamage = 1;
        //TODO CRITICA
        //TODO
        //TODO
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());

        if(this.rogue.getLandModifier() != 1) {
            if(this.rogue.getEffects().getNumberHits() % 3 == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage *
                Constants.BACKSTAB_VS_PYROMANCER_MODIFIER * criticalDamage);
//        totalDamage = totalDamage * criticalDamage;
        System.out.println("Backstab Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);
        pyromancer.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        if(this.rogue.getLandModifier() != 1) {
            if(this.rogue.getEffects().getNumberHits() % 3 == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage *
                Constants.BACKSTAB_VS_KNIGHT_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        System.out.println("Backstab Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);
        knight.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Wizard wizard) {
        System.out.println(this.baseDamage);

        if(this.rogue.getLandModifier() != 1) {
            if(this.rogue.getEffects().getNumberHits() % 3 == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier() * criticalDamage);

        int totalDamage = Math.round(levelLandDamage *
                Constants.BACKSTAB_VS_WIZARD_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        System.out.println("Backstab Damage total dat = " + totalDamage);
        System.out.println("Backstab Damage fara Race = " + levelLandDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);
        wizard.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Rogue rogue) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        if(this.rogue.getLandModifier() != 1) {
            if(this.rogue.getEffects().getNumberHits() % 3 == 0) {
                this.rogue.getEffects().setNumberHits(this.rogue.getEffects()
                        .getNumberHits() + 1);
                criticalDamage = this.rogue.getEffects().getCriticalDamage();
            }
        }

        int totalDamage = Math.round(levelLandDamage *
                Constants.BACKSTAB_VS_ROGUE_MODIFIER);
        totalDamage = Math.round(totalDamage * criticalDamage);
        System.out.println("Backstab Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);
        rogue.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public String toString() {
        return "Backstab";
    }
}
