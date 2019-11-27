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

    public Paralysis(Rogue rogue) {
        this.rogue = rogue;
        this.baseDamegePerLevel = Constants.PARALYSIS_BASE_DAMAGE_PER_LEVEL *
                rogue.getLevel();
        this.baseDamage = Constants.PARALYSIS_BASE_DAMAGE +
                this.baseDamegePerLevel;
        //TODO: STUN && OVERTIME
        //TODO
        //TODO
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamegePerLevel() {
        return baseDamegePerLevel;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.PARALYSIS_VS_PYROMANCER_MODIFIER);
        System.out.println("Paralysis Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);

        if(this.rogue.getLandModifier() == 'W') {
            pyromancer.getStun().setTime(6);
            pyromancer.getBuff().setTime(6);
        } else {
            pyromancer.getStun().setTime(3);
            pyromancer.getBuff().setTime(3);
        }

        pyromancer.getStun().setStun(true);
        pyromancer.getBuff().setDamageOverTime(totalDamage);

        pyromancer.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.PARALYSIS_VS_KNIGHT_MODIFIER);
        System.out.println("Paralysis Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);

        if(this.rogue.getLandModifier() == 'W') {
            knight.getStun().setTime(6);
            knight.getBuff().setTime(6);
        } else {
            knight.getStun().setTime(3);
            knight.getBuff().setTime(3);
        }

        knight.getStun().setStun(true);
        knight.getBuff().setDamageOverTime(totalDamage);

        knight.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Wizard wizard) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.PARALYSIS_VS_WIZARD_MODIFIER);
        System.out.println("Paralysis Damage total dat = " + totalDamage);
        System.out.println("Paralysis Damage fara Race = " + levelLandDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);

        if(this.rogue.getLandModifier() == 'W') {
            wizard.getStun().setTime(6);
            wizard.getBuff().setTime(6);
        } else {
            wizard.getStun().setTime(3);
            wizard.getBuff().setTime(3);
        }

        wizard.getStun().setStun(true);
        wizard.getBuff().setDamageOverTime(totalDamage);

        wizard.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public void visit(Rogue rogue) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.rogue.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.PARALYSIS_VS_ROGUE_MODIFIER);
        System.out.println("Paralysis Damage total dat = " + totalDamage);
        this.rogue.getEffects().setLevelLandDamage(this.rogue.getEffects().
                getLevelLandDamage() + levelLandDamage);
        this.rogue.getEffects().setTotalDamage(this.rogue.getEffects().getTotalDamage() + totalDamage);

        if(this.rogue.getLandModifier() == 'W') {
            rogue.getStun().setTime(6);
            rogue.getBuff().setTime(6);
        } else {
            rogue.getStun().setTime(3);
            rogue.getBuff().setTime(3);
        }

        rogue.getStun().setStun(true);
        rogue.getBuff().setDamageOverTime(totalDamage);

        rogue.increaseDamage(totalDamage, this.rogue);
    }

    @Override
    public String toString() {
        return "Paralysis";
    }
}
